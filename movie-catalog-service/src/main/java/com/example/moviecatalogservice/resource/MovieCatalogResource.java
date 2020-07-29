package com.example.moviecatalogservice.resource;


import com.example.moviecatalogservice.models.CatalogItem;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/catalog")
public class MovieCatalogResource {
//    List<CatalogItem> items=new ArrayList<>(CatalogItem);
    @RequestMapping("/{userId}")
    public List<CatalogItem> getCatalog(@PathVariable("userId") String userID){
        return Collections.singletonList(
                new CatalogItem("Titanic","test",10)
        );
    }
}
