package com.crud.crudbook.repository;

import com.crud.crudbook.entity.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Long> {

    @Query("SELECT s FROM Movie s WHERE s.title = ?1")
    Optional<Movie> findMovieByTitle(String title);

}
