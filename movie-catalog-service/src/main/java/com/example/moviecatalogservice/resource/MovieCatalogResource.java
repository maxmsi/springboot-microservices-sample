package com.example.moviecatalogservice.resource;


import com.example.moviecatalogservice.models.CatalogItem;
import com.example.moviecatalogservice.models.Movie;
import com.example.moviecatalogservice.models.Rating;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/catalog")
public class MovieCatalogResource {
//    List<CatalogItem> items=new ArrayList<>(CatalogItem);
    @RequestMapping("/{userId}")
    public List<CatalogItem> getCatalog(@PathVariable("userId") String userID){

        RestTemplate restTemplate = new RestTemplate();

        // we want to get all rated movie ID's
        // for example purpose it will be hardcoded.
        List<Rating> ratings = Arrays.asList(
                new Rating("sampleid123",1),
                new Rating ("samppda",2)
        );
        // For each movie ID, call  info service and  get details.
        return ratings.stream().map(rating-> {
            Movie movie = restTemplate.getForObject("http://localhost:8082/movies/" + rating.getMovieId(), Movie.class);
            return new CatalogItem(movie.getName(),"desc",rating.getRating());
        })
                // list them all together
                .collect(Collectors.toList());
    }
}
