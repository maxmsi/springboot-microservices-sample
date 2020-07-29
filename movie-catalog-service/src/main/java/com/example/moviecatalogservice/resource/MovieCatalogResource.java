package com.example.moviecatalogservice.resource;


import com.example.moviecatalogservice.models.CatalogItem;
import com.example.moviecatalogservice.models.Movie;
import com.example.moviecatalogservice.models.Rating;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/catalog")
public class MovieCatalogResource {
    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping("/{userId}")
    public List<CatalogItem> getCatalog(@PathVariable("userId") String userId){

        // we want to get all rated movie ID's
        // for example purpose it will be hardcoded.
        List<Rating> ratings = Arrays.asList(
                new Rating("sampleID",1),
                new Rating ("secondID",2)
        );
        // For each movie ID, call  movie info service and  get details. ( description temporary hardcoded )
        return ratings.stream().map(rating-> {
            Movie movie = restTemplate.getForObject("http://localhost:8084/movies/"+rating.getMovieId(), Movie.class);
            return new CatalogItem("hard test","desc",rating.getRating());
        })
                // list them all together
                .collect(Collectors.toList());
    }
}
