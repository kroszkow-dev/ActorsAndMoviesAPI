package com.example.ActorsAndMoviesAPI.Movies;

import com.weddini.throttling.Throttling;
import com.weddini.throttling.ThrottlingType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.concurrent.TimeUnit;

@RequestMapping("/movies")
@RestController
public class MoviesController {

    @Autowired
    MoviesService moviesService;

    @Throttling(type = ThrottlingType.PrincipalName, limit = 5, timeUnit = TimeUnit.MINUTES)
    @GetMapping
    private List<Movies> getAllMovies(@RequestParam(name = "page", required = false, defaultValue="0") Integer page,
                                     @RequestParam(name = "page_size", required = false, defaultValue="10") Integer pageSize,
                                     @RequestParam(name = "name", required = false) String name,
                                     HttpServletRequest request) {
        return moviesService.getAllMovies(page, pageSize, name);
    }

    @Throttling(type = ThrottlingType.PrincipalName, limit = 5, timeUnit = TimeUnit.MINUTES)
    @GetMapping("/{id}")
    private Movies getMovieByID(@PathVariable("id") String id, HttpServletRequest request) {

        return moviesService.getMovieByID(id);
    }
}
