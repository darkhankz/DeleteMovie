package com.example.mymoviesapptwo.model.repository

import com.example.mymoviesapptwo.data.MoviesData
import retrofit2.Call

interface MovieDBRepository {
    fun getMovies(): Call<MoviesData>

    fun getMoviesDetails(): Call<MoviesData>
}