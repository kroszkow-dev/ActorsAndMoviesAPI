package com.example.ActorsAndMoviesAPI.Actors;

import com.weddini.throttling.Throttling;
import com.weddini.throttling.ThrottlingType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

@RequestMapping("/actors")
@RestController
public class ActorsController {

    @Autowired
    ActorsService actorsService;

    @Throttling(type = ThrottlingType.PrincipalName, limit = 5, timeUnit = TimeUnit.MINUTES)
    @GetMapping
    private List<Actors> getActors(
            @RequestParam(name = "page", required = false, defaultValue="0") Integer page,
            @RequestParam(name = "page_size", required = false, defaultValue="10") Integer pageSize,
            @RequestParam(name = "name", required = false) String name,
            HttpServletRequest request) {
        return actorsService.getAllActors(page, pageSize, name);
    }

    @Throttling(type = ThrottlingType.PrincipalName, limit = 5, timeUnit = TimeUnit.MINUTES)
    @GetMapping("/{id}")
    private Actors getActorByID(@PathVariable("id") String id, HttpServletRequest request) {

        return actorsService.getActorByID(id);
    }

    @Throttling(type = ThrottlingType.PrincipalName, limit = 5, timeUnit = TimeUnit.MINUTES)
    @GetMapping("/{id}/appearances")
    private ArrayList<String> getAllActorsAppearances(@PathVariable("id") String id, HttpServletRequest request) {
        return actorsService.getAllActorsAppearances(id);
    }
}
