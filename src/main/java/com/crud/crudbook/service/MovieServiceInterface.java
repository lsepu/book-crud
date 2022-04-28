package com.crud.crudbook.service;

import com.crud.crudbook.entity.Book;
import com.crud.crudbook.entity.Movie;

import java.util.List;

public interface MovieServiceInterface {

    List<Movie> getAllMovies();

    void saveMovie(Movie movie);

    void updateMovie(Movie movie);

    void deleteMovie(Long id);

}
