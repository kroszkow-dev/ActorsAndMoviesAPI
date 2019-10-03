package com.example.ActorsAndMoviesAPI.Movies;

import lombok.Data;
import org.hibernate.annotations.Type;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;

@Data
@Entity
public class Movies {
    @Id
    private String tconst;
    private String titleType;
    @Lob
    @Type(type = "org.hibernate.type.TextType")
    private String primaryTitle;
    @Lob
    @Type(type = "org.hibernate.type.TextType")
    private String originalTitle;
    private boolean isAdult;
    private String startYear;
    private String endYear;
    private String runtimeMinutes;
    private String genres;
}
