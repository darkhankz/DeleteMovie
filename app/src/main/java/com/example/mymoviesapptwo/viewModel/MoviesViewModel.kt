package com.example.mymoviesapptwo.viewModel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.mymoviesapptwo.data.MoviesData
import com.example.mymoviesapptwo.data.Result
import com.example.mymoviesapptwo.model.repository.MovieDBRepository
import com.example.mymoviesapptwo.model.repository.MovieDBRepositoryImpl
import com.example.mymoviesapptwo.view.adapters.CustomAdapter
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MoviesViewModel  {
    private val mMoviesRepository : MovieDBRepository = MovieDBRepositoryImpl()

    private val _movies = MutableLiveData<List<Result>>()
    val movies : LiveData<List<Result>> = _movies

    private val _moviesDetails = MutableLiveData<Result>()
    val moviesDetails : LiveData<Result> = _moviesDetails

    fun getMovies(){
        val response = mMoviesRepository.getMovies()
        response.enqueue( object : Callback<MoviesData> {
            override fun onResponse(call: Call<MoviesData>?, response: Response<MoviesData>?) {
                _movies.postValue(response?.body()?.results)

            }

            override fun onFailure(call: Call<MoviesData>?, t: Throwable?) {

            }
        })
    }



}