package com.book.modernjavainaction.streams.chapter5;

import java.util.List;

public record Movie(String title,
                    int year,
                    double rating,
                    String genre,
                    int duration, // in minutes
                    long budget ) {

    public static List<Movie> getMovies(){
        return List.of(new Movie("The Shawshank Redemption", 1994, 9.3, "Drama", 142, 25000000),
                new Movie("The Godfather", 1972, 9.2, "Crime", 175, 6000000),
                new Movie("The Dark Knight", 2008, 9.0, "Action", 152, 185000000),
                new Movie("Pulp Fiction", 1994, 8.9, "Crime", 154, 8000000),
                new Movie("Fight Club", 1999, 8.8, "Drama", 139, 63000000),
                new Movie("Inception", 2010, 8.8, "Sci-Fi", 148, 160000000),
                new Movie("The Matrix", 1999, 8.7, "Sci-Fi", 136, 63000000),
                new Movie("Goodfellas", 1990, 8.7, "Crime", 146, 25000000),
                new Movie("The Silence of the Lambs", 1991, 8.6, "Thriller", 118, 19000000),
                new Movie("Interstellar", 2014, 8.6, "Sci-Fi", 169, 165000000),
                new Movie("Parasite", 2019, 8.6, "Drama", 132, 11400000),
                new Movie("The Prestige", 2006, 8.5, "Drama", 130, 40000000),
                new Movie("The Departed", 2006, 8.5, "Crime", 151, 90000000),
                new Movie("Gladiator", 2000, 8.5, "Action", 155, 103000000),
                new Movie("The Lion King", 1994, 8.5, "Animation", 88, 45000000));

    }
}
