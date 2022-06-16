package com.mosh.java.streams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import com.mosh.java.streams.Movie.GENRE;

public class Main {

	public static void main(String[] args) {
		List<Movie> movies = new ArrayList<Movie>();
		movies.add((new Movie("Kedarnath", 10000, Movie.GENRE.DRAMA)));
		movies.add((new Movie("Gully boy", 2, Movie.GENRE.DRAMA)));
		movies.add((new Movie("MSD", 20000, Movie.GENRE.DRAMA)));
		movies.add((new Movie("Chhichore", 30000, Movie.GENRE.COMEDY)));
		movies.add((new Movie("Kai po che", 2000, Movie.GENRE.COMEDY)));
		movies.add((new Movie("James bond", 2000, Movie.GENRE.ACTION)));

		// String s = "".matches("[a-z,A-Z]");

		// show(movies);

		// mappingElements(movies);

		// flatMapElements();

		// infiniteStreams();

		// slicingStreams(movies);
		// sortStreams(movies);
		// getUnique(movies);
		// getPeek(movies);

		// simpleReducers(movies);
		// collectors(movies);

		// groupByCollect(movies);
		// groupByCollectPatition(movies);
		// premitivesStream();

		reduce(movies);
	}

	static void reduce(List<Movie> movies) {

		List<Integer> lst = Arrays.asList(1, 2, 3, 4, 5);

		Optional<Integer> i = lst.stream().reduce((a, b) -> a + b);

		System.out.println(i);

		Integer ii = movies.stream().map(x -> x.getLikes()).reduce(0, (a, b) -> a + b);
		System.out.println(ii);
	}

	static void premitivesStream() {
		IntStream.range(0, 10).forEach(x -> System.out.println(x));
		System.out.println("\n rangeClosed");
		IntStream.rangeClosed(0, 10).forEach(x -> System.out.println(x));
	}

	static void groupByCollectPatition(List<Movie> movies) {
		Map<Boolean, String> m_list = movies.stream().collect(
				Collectors.partitioningBy(
						x -> x.getLikes() > 10000,
						Collectors.mapping(
								Movie::getTitle,
								Collectors.joining(","))));
		System.out.println("collected as Group Partitioned by - \n" + m_list);

	}

	static void groupByCollect(List<Movie> movies) {
		Map<GENRE, List<Movie>> m_list = movies.stream().collect
				(Collectors.groupingBy(Movie::getGenre));
		System.out.println("collected as Group getGenre - \n" + m_list);

		Map<GENRE, List<Movie>> m_map = movies.stream().filter(x -> x.getLikes() > 10)
				.collect(Collectors.groupingBy(Movie::getGenre, Collectors.toList()));
		System.out.println("collected as list - " + m_map);

		Map<GENRE, String> m_map1 = movies.stream().collect(
				Collectors.groupingBy(Movie::getGenre, Collectors.mapping(Movie::getTitle, Collectors.joining(", "))));
		System.out.println("collected as list - " + m_map1);
	}

	static void collectors(List<Movie> movies) {
		List<Movie> m_list = movies.stream().filter(x -> x.getLikes() > 2000).collect(Collectors.toList());
		System.out.println("collected as list - " + m_list);

		Set<Movie> m_set = movies.stream().filter(x -> x.getLikes() > 2000).collect(Collectors.toSet());
		System.out.println("collected as Set - " + m_set);

		Map<String, Integer> m_map = movies.stream().filter(x -> x.getLikes() > 2000)
				.collect(Collectors.toMap(Movie::getTitle, Movie::getLikes));
		System.out.println("collected as Set - " + m_map);

		IntSummaryStatistics summary = movies.stream().filter(x -> x.getLikes() > 2000)
				.collect(Collectors.summarizingInt(m -> m.getLikes()));
		System.out.println("collected as IntSummaryStatistics - " + summary);

		Integer sum = movies.stream().filter(x -> x.getLikes() > 2000)
				.collect(Collectors.summingInt(m -> m.getLikes()));

		String joiner = movies.stream().map(Movie::getTitle).collect(Collectors.joining(", "));
		System.out.println("collected as summingInt - " + joiner);
	}

	// methods return last output
	static void simpleReducers(List<Movie> movies) {
		System.out.println("count - " + movies.stream().count());
		System.out.println("findFirst - " + movies.stream().findFirst());
		System.out.println("findAny - " + movies.stream().findAny());
		System.out.println("findAny - " + movies.stream().anyMatch(x -> x.getLikes() > 2000));

		// System.out.println("reduce sum - " +
		// movies.stream().reduce(identity,Integer.sum(a, b)).anyMatch(x -> x.getLikes()
		// > 2000));

	}

	static void getPeek(List<Movie> movies) {
		System.out.println("\nget getPeek - output for each operaiton -");
		movies.stream().map(Movie::getTitle).peek(x -> System.out.println("Peekd - " + x)).distinct()
				.forEach(x -> System.out.println(x));
	}

	static void getUnique(List<Movie> movies) {
		System.out.println("\nget Unique");
		movies.stream().map(Movie::getLikes)// map(x->x.getLikes())
				.distinct().forEach(x -> System.out.println(x));
	}

	static void sortStreams(List<Movie> movies) {
		System.out.println("\nsort by likes");
		movies.stream().sorted().forEach(x -> System.out.println(x.getTitle()));
		;

		System.out.println("\nsort by name");
		movies.stream().sorted((a, b) -> a.getTitle().compareTo(b.getTitle()))
				.forEach(x -> System.out.println(x.getTitle()));
		;
	}

	static void slicingStreams(List<Movie> movies) {

		System.out.println("\nLimit 2 - ");
		movies.stream().limit(2).forEach(x -> System.out.println(x.getTitle()));

		System.out.println("\nSkip 2 - ");
		movies.stream().limit(2).forEach(x -> System.out.println(x.getTitle()));

		System.out.println("\n Skip and Limit 2 - ");
		movies.stream().skip(1).limit(2).forEach(x -> System.out.println(x.getTitle()));

//		System.out.println("\ntakewhile - will exit on 1st match found");
//		movies.stream()movies.take
	}

	static void filter(List<Movie> movies) {
		Predicate<Movie> isPopular = x -> x.getLikes() > 10;

		movies.stream().filter(isPopular).forEach(x -> x.toString().toUpperCase());
	}

	static void flatMapElements() {
		System.out.println();
		List<Integer> l1 = new ArrayList<Integer>();
		l1.add(1);
		l1.add(2);
		l1.add(3);

		List<String> l2 = new ArrayList<String>();
		l2.add("a");
		l2.add("b");
		l2.add("c");

		int[] arr = { 1, 2, 3, 4, 5 };
		Stream.of(l1, l2, arr).forEach(x -> System.out.println(x));
		System.out.println("Using flatmap to merge the lists -");
		Stream.of(l1, l2).flatMap(list -> list.stream()).forEach(x -> System.out.println(x));
		;

	}

	static void mappingElements(List<Movie> movies) {
		System.out.println();
		movies.stream().map(x -> x.getTitle()).forEach(name -> System.out.println(name));

	}

	static void infiniteStreams() {
		System.out.println();
		Stream.generate(() -> Math.random()).limit(10).forEach(x -> System.out.println(x));
		System.out.println();

		Stream.iterate(1, x -> x + 1).limit(10).forEach(x -> System.out.println(x));
	}

	static void show(List<Movie> movies) {
		System.out.println();
		movies.stream().forEach(x -> System.out.println(x.getTitle()));
		long count = movies.stream().filter(movie -> movie.getLikes() > 10).count();
		System.out.println("filter count=" + count);

	}

}
