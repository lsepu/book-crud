package com.crud.crudbook.controller;

import com.crud.crudbook.entity.Movie;
import com.crud.crudbook.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/")
public class MovieController {

    @Autowired
    private MovieService movieService;

    @GetMapping("get/movies")
    public List<Movie> getAllMovies(){
        return movieService.getAllMovies();
    }

    @PostMapping("save/movie")
    public ResponseEntity<Movie> saveMovie(@RequestBody Movie movie){
        movieService.saveMovie(movie);
        return new ResponseEntity<>(movie, HttpStatus.CREATED);
    }

    @DeleteMapping("delete/movie/{movieId}")
    public void deleteMovie(@PathVariable("movieId") Long movieId){
        movieService.deleteMovie(movieId);
    }

    @PutMapping("update/movie")
    public void updateMovie(@RequestBody Movie movie){
        movieService.updateMovie(movie);
    }

}
