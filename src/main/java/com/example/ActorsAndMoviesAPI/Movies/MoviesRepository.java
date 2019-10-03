package com.example.ActorsAndMoviesAPI.Movies;

import com.example.ActorsAndMoviesAPI.Actors.Actors;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface MoviesRepository extends PagingAndSortingRepository<Movies, String> {
}
