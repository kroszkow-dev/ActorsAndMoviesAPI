package com.example.ActorsAndMoviesAPI.Actors;

import com.example.ActorsAndMoviesAPI.Movies.Movies;
import com.example.ActorsAndMoviesAPI.Movies.MoviesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ActorsService {

    @Autowired
    ActorsRepository actorsRepository;

    @Autowired
    MoviesRepository moviesRepository;

    public List<Actors> getAllActors(int page, int pageSize, String name){

        if(name != null){
            return actorsRepository.findById(name).stream().collect(Collectors.toList());
        }
        Pageable paging = PageRequest.of(page, pageSize);

        Page<Actors> pagedResult = actorsRepository.findAll(paging);
        return  pagedResult.getContent();
    }

    public Actors getActorByID(String name){
        return  actorsRepository.findById(name).get();
    }

    public ArrayList<String> getAllActorsAppearances(String id){
        Actors actor = actorsRepository.findById(id).get();
        List<Movies> movies = new ArrayList<Movies>();
        String splitTitlesId[] = actor.getKnownForTitles().split(",");
        for (String movieId: splitTitlesId
        ) {
            movies.add(moviesRepository.findById(movieId).get());
        }
        ArrayList<String> returnArray = new ArrayList<String>();
        movies.forEach(movie -> returnArray.add("movie_id: " + movie.getTconst()+ ", "
                +"movie_name: " + movie.getPrimaryTitle() + ", "
               +"character_name: " + actor.getPrimaryName()));
        return returnArray;
    }
}
