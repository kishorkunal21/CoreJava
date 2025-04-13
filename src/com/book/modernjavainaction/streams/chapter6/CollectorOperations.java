package com.book.modernjavainaction.streams.chapter6;

import com.book.modernjavainaction.streams.chapter5.Movie;

import java.rmi.MarshalledObject;
import java.util.Comparator;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.*;

public class CollectorOperations {
    public static void main(String[] args) {
        //collectOperations();
        groupOperations();
    }

    private static void groupOperations() {
        System.out.println("----------------------------");
        System.out.println(
                Movie.getMovies().stream()
                        .collect(Collectors.groupingBy(Movie::genre))
        );
        System.out.println("----------------------------");
        System.out.println(
                Movie.getMovies().stream()
                        .collect(Collectors.groupingBy(
                                movie -> {
                                    if (movie.rating() > 9) {
                                        return "AWESOME";
                                    }
                                    else if (movie.rating() > 8 && movie.rating() < 9) {
                                        return "GOOD";
                                    } else return "RUBBISH";
                                }
                        ))
        );

        System.out.println("----------------------------");
        //using filtering as 2nd arg in groupingBy
        System.out.println(
                Movie.getMovies().stream()
                        .collect(Collectors.groupingBy(
                                movie -> {
                                    if (movie.rating() >= 9) {
                                        return "AWESOME";
                                    }
                                    else if (movie.rating() > 8 ) {
                                        return "GOOD";
                                    } else return "RUBBISH";
                                },
                                Collectors.filtering(m->m.year()>2000, toList())
                        ))
        );

        System.out.println("----------------------------");
        //using mapping as 2nd operation in grouping
        System.out.println(
                Movie.getMovies().stream()
                        .collect(Collectors.groupingBy(
                                movie -> {
                                    if (movie.rating() >= 9) {
                                        return "AWESOME";
                                    }
                                    else if (movie.rating() > 8 ) {
                                        return "GOOD";
                                    } else return "RUBBISH";
                                },
                                Collectors.mapping(m->m.title(), toList()))
                        )
        );

        System.out.println("----------------------------");
        //using mapping as 2nd operation in grouping
        System.out.println(
                Movie.getMovies().stream()
                        .collect(Collectors.groupingBy(
                                movie -> {
                                    if (movie.rating() >= 9) {
                                        return "AWESOME";
                                    }
                                    else if (movie.rating() > 8 ) {
                                        return "GOOD";
                                    } else return "RUBBISH";
                                },
                                Collectors.groupingBy(Movie::genre))//2nd level grouping
                        )
        );

        System.out.println("----------------------------");
        //find no of movies grouped by genre
        System.out.println(
                Movie.getMovies().stream()
                        .collect(Collectors.groupingBy(
                                movie -> {
                                    if (movie.rating() >= 9) {
                                        return "AWESOME";
                                    }
                                    else if (movie.rating() > 8 ) {
                                        return "GOOD";
                                    } else return "RUBBISH";
                                },
                                Collectors.counting())//2nd level grouping
                        )
        );

        System.out.println("----------------------------");
        //max by a group
        System.out.println(
                Movie.getMovies().stream()
                        .collect(Collectors.groupingBy(
                                movie -> {
                                    if (movie.rating() >= 9) {
                                        return "AWESOME";
                                    }
                                    else if (movie.rating() > 8 ) {
                                        return "GOOD";
                                    } else return "RUBBISH";
                                },
                                Collectors.maxBy((m1,m2)-> Math.toIntExact(m1.budget() > m2.budget() ? m1.budget() : m2.budget()))
                                )
                        )
        );

    }

    private static void collectOperations() {
        System.out.println(
                Movie.getMovies().stream().collect(Collectors.counting())
        );
        //Finding maximum and minimum in a stream of values
        System.out.println(
                Movie.getMovies().stream().max(Comparator.comparing(Movie::budget))
        );
        System.out.println("----------------------------");
        //summarization
        System.out.println(
                Movie.getMovies().stream().
                        collect(Collectors.summarizingInt(Movie::duration))
        );
        System.out.println("----------------------------");
        System.out.println(
                Movie.getMovies().stream()
                        .map(Movie::title)
                        .collect(Collectors.joining(","))
        );
        System.out.println(
                IntStream.range(1, 11).reduce((a, b) -> a + b)
        );
        System.out.println("----------------------------");
        System.out.println(
                Movie.getMovies().stream()
                        .collect(Collectors
                                .reducing((a, b) -> a.budget() > b.budget() ? a : b))
                        .stream().toList()
        );
        System.out.println("----------------------------");
        System.out.println(
                IntStream.range(0, 10).reduce(0, (a, b) -> a + b)
        );

        System.out.println("----------------------------");
        System.out.println(
                Movie.getMovies().stream()
                        .map(Movie::budget)
                        .reduce(Long::sum)
        );


    }
}
