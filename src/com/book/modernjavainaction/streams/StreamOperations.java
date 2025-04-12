package com.book.modernjavainaction.streams;

import com.educative.java8.streams.Streams;

import java.awt.color.ICC_Profile;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/*
Here are some practice exercises you can try with these datasets:

Mapping:
Extract just the movie titles
Create a list of movie titles with their release years
Convert durations from minutes to hours
Sorting:
Sort movies by rating (highest first)
Sort movies by year (oldest first)
Sort movies by duration (longest first)
Aggregation:
Calculate average rating of all movies
Find the highest rated movie
Calculate total budget of all movies
Grouping:
Group movies by genre
Group movies by decade
Count movies per genre
Advanced:
Find the most common genre
Calculate average rating per genre
Find the longest movie in each genre
These datasets should give you plenty of material to practice Java Stream operations like filter(), map(), sorted(), collect(), reduce(), and grouping/partitioning operations.
 */
public class StreamOperations {
    public static void main(String[] args) {
        //filterOperations();
        //findingAndMatchingShortCircuitingOperations();
        reducing();
    }

    private static void reducing() {
        //to combine all values in a stream to produce a single value result
        List<Integer> integerStream = IntStream.rangeClosed(1, 5).boxed().toList();

        System.out.println(
                integerStream.stream().reduce(0, Integer::sum)
        );
        System.out.println(
                integerStream.stream().reduce(1, (a, b) -> a * b)
        );
        System.out.println("reduce min : "+
                integerStream.stream().reduce(1, (a, b) -> a < b?a:b)
        );
        System.out.println("stream count : "+integerStream.stream().count());

        System.out.println("Counting : "+
                integerStream.stream().map(a->1).reduce(0,(a,b)->a+b)
                );

    }

    private static void findingAndMatchingShortCircuitingOperations() {
        //check to see if predicate at least one element
        //terminates as soon as it gets a true value
        //doesn't iterate the whole elements
        //allMatch, noneMatch, findFirst, and findAny don’t need to process the whole stream to produce a result.
        // As soon as an element is found, a result can be produced
        System.out.println(
                Movie.getMovies().stream().filter(a -> a.rating() > 9).findAny()
        );

        System.out.println("---------------------------");
        System.out.println(
                Movie.getMovies().stream().anyMatch(a -> a.rating() > 9)//is a terminal operation
        );
        System.out.println(
                Movie.getMovies().stream().allMatch(a -> a.rating() > 9)//is a terminal operation
        );
        System.out.println(
                Movie.getMovies().stream().noneMatch(a -> a.rating() > 9)//is a terminal operation
        );
        System.out.println(
                Movie.getMovies().stream().filter(a -> a.rating() > 9).findAny()

        );

    }

    public static void filterOperations() {
        Movie.getMovies().forEach(System.out::println);
        System.out.println("---------------------------");
        /*
        Filtering:
            Find all movies released after 2000
            Find all movies with rating > 8.5
            Find all movies in the "Sci-Fi" genre
        */

        System.out.println("---------------------------");
        //finding all movies after 2000
        System.out.println(Movie.getMovies().stream()
                .filter(a -> a.year() > 2000)
                .map(Movie::title)
                .toList()
        );

        System.out.println("---------------------------");
        //finding all movies rated 8.5>
        System.out.println(Movie.getMovies().stream()
                .filter(a -> a.rating() > 8.5)
                .map(Movie::title)
                .toList()
        );

        System.out.println("---------------------------");
        //using map
        List<String> list = Arrays.asList("Modern", "Java", "in", "action");
        System.out.println(list.stream().map(String::length).toList());
        System.out.println(list.stream().collect(Collectors.toMap(key -> key, String::length)));

        System.out.println("---------------------------");
        //from a list of word - "hello word", extract one single array of words like -
        // ["h","e","l","l""o"...word]
        list = List.of("Hello world");
        System.out.println(
                list.stream()
                        .map(a -> a.split(""))
                        .map(Arrays::toString)
                        .toList()
        );//returns Stream<String>

        System.out.println(
                list.stream()
                        .map(a -> a.split(""))
                        .flatMap(Arrays::stream)
                        .toList()
        );
        System.out.println("---------------------------");
        /*
        Given a list of numbers, how would you return a list of the square of each number?
        For example, given [1, 2, 3, 4, 5] you should return [1, 4, 9, 16, 25]*/
        List<Integer> numList = List.of(1, 2, 3, 4, 5);
        System.out.println(
                numList.stream().map(a -> a * a)
                        .toList()
        );
        /*
        2. Given two lists of numbers, how would you return all pairs of numbers?
        For example, given a list [1, 2, 3] and a list [3, 4] you should return
        [(1, 3), (1, 4), (2, 3), (2, 4), (3, 3), (3, 4)].
        For simplicity, you can represent a pair as an array with two elements.
         */
        List<Integer> numList2 = Arrays.asList(3, 4);
        System.out.println(
                numList.stream()
                        .map(a -> numList2.stream()
                                .map(b -> new int[]{a, b}))
                        .toList()
        );//not working as it returns stream of stream

        System.out.println(
                numList.stream()
                        .flatMap(a -> numList2.stream()
                                .map(b -> new int[]{a, b}).map(Arrays::toString))
                        .toList()
        );//not working as it returns stream of stream
        //How would you extend the previous example to return only pairs whose sum is divisible by 3
        System.out.println(
                numList2.stream()
                        .flatMap(a -> numList2.stream()
                                .map(b -> new int[]{a, b}))
                        .filter(c -> (c[0] + c[1]) % 3 == 0)
                        .map(Arrays::toString)
                        .toList()
        );
    }

}
