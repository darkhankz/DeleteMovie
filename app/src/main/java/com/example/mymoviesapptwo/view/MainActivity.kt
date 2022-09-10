package com.example.mymoviesapptwo.view

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.mymoviesapptwo.model.apis.ApiInterface
import com.example.mymoviesapptwo.view.adapters.CustomAdapter
import com.example.mymoviesapptwo.R
import com.example.mymoviesapptwo.data.MoviesData
import com.example.mymoviesapptwo.viewModel.MoviesViewModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    private val mViewModel : MoviesViewModel = MoviesViewModel()

    private lateinit var mMoviesRecycler: RecyclerView
    private lateinit var mMoviesAdapter: CustomAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initViews()
        initObservers()
        mViewModel.getMovies()



    }

    private fun initObservers(){
        mViewModel.apply {
            movies.observe(this@MainActivity){
                mMoviesAdapter = CustomAdapter(it)
                mMoviesRecycler.adapter = mMoviesAdapter
            }

        }

    }

    private fun initViews(){
        mMoviesRecycler = findViewById(R.id.recyclerview)
        mMoviesRecycler.layoutManager = GridLayoutManager(this, 2)
    }


}
