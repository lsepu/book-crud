package com.crud.crudbook.entity;

import javax.persistence.*;

@Entity(name = "Movie")
@Table(name = "movie")
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String title;
    private String director;
    private Double duration;

    public String getDirector() {
        return director;
    }

    public Double getDuration() {
        return duration;
    }

    public String getGenre() {
        return genre;
    }

    private String genre;

    public String getTitle() {
        return title;
    }

    public Long getId() {
        return id;
    }
}
