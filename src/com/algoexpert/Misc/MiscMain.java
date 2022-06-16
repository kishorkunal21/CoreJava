package com.algoexpert.Misc;

import java.util.ArrayList;
import java.util.List;

public class MiscMain {
    public static void main(String[] args) {
        List<Movie> movies = new ArrayList<Movie>();
        movies.add((new Movie("Kedarnath", 10000, Movie.GENRE.DRAMA)));
        movies.add((new Movie("Gully boy", 2, Movie.GENRE.DRAMA)));
        movies.add((new Movie("MSD", 20000, Movie.GENRE.DRAMA)));
        movies.add((new Movie("Chhichore", 30000, Movie.GENRE.COMEDY)));
        movies.add((new Movie("Kai po che", 2000, Movie.GENRE.COMEDY)));
        movies.add((new Movie("James bond", 2000, Movie.GENRE.ACTION)));
    }
}
