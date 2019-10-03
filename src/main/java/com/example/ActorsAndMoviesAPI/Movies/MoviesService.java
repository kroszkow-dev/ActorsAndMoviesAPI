package com.example.ActorsAndMoviesAPI.Movies;

import com.example.ActorsAndMoviesAPI.Actors.Actors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class MoviesService {

    @Autowired
    MoviesRepository moviesRepository;

    public List<Movies> getAllMovies(Integer page, Integer pageSize, String name){

        if(name != null){
            return moviesRepository.findById(name).stream().collect(Collectors.toList());
        }

        Pageable paging = PageRequest.of(page, pageSize);
        Page<Movies> pagedResult = moviesRepository.findAll(paging);
        return  pagedResult.getContent();
    }

    public Movies getMovieByID(String id){
       return moviesRepository.findById(id).get();
    }
}
