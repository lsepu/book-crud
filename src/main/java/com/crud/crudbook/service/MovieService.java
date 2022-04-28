package com.crud.crudbook.service;

import com.crud.crudbook.entity.Movie;
import com.crud.crudbook.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MovieService implements MovieServiceInterface {

    @Autowired
    private MovieRepository movieRepository;

    @Override
    public List<Movie> getAllMovies() {
        return movieRepository.findAll();
    }

    @Override
    public void saveMovie(Movie movie) {
        Optional<Movie> movieOptional = movieRepository.findMovieByTitle(movie.getTitle());
        if (movieOptional.isPresent()) {
            throw new IllegalStateException("A movie with that title already exists");
        }
        movieRepository.save(movie);
    }

    @Override
    public void deleteMovie(Long movieId) {
        boolean exists = movieRepository.existsById(movieId);
        if (!exists) {
            throw new IllegalStateException(
                    "movie with id " + movieId + " does not exists"
            );
        }
        movieRepository.deleteById(movieId);
    }


    @Override
    public void updateMovie(Movie movie) {

        movieRepository.findById(movie.getId())
                .orElseThrow(() -> new IllegalStateException((
                        "Movie with id " + movie.getId() + "does not exist"
                )));
        movieRepository.save(movie);
    }

}
