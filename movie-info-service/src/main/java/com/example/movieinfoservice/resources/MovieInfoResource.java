package com.example.movieinfoservice.resources;

import com.example.movieinfoservice.models.Movie;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/movie")
public class MovieInfoResource {

    @RequestMapping("/{movieId}")
    public Movie getMovie(@PathVariable("movieId")int movieId){
               return new Movie(movieId,"test");

    }
}
