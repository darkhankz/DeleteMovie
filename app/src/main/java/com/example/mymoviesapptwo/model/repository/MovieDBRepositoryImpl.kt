package com.example.mymoviesapptwo.model.repository

import com.example.mymoviesapptwo.data.MoviesData
import com.example.mymoviesapptwo.model.apis.ApiInterface
import retrofit2.Call

class MovieDBRepositoryImpl : MovieDBRepository {
    private val apiInterface = ApiInterface.create()

    override fun getMovies(): Call<MoviesData> {
        return apiInterface.getMovies("6e76ecffda0a59dc4f19a343c6e7648a")

    }

    override fun getMoviesDetails() : Call<MoviesData> {
        return apiInterface.getMovies("dhgfhsjgf")

    }
}