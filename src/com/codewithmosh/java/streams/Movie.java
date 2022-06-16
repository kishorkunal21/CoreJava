package com.codewithmosh.java.streams;

public class Movie implements Comparable<Movie> {

	private String title;
	private int likes;
	GENRE genre;

	public enum GENRE {
		COMEDY, ACTION, DRAMA
	}

	public Movie(String title, int likes) {
		super();
		this.title = title;
		this.likes = likes;
	}

	public Movie(String title, int likes, GENRE genre) {
		super();
		this.title = title;
		this.likes = likes;
		this.genre = genre;
	}

	public String getTitle() {
		return title;
	}

	public int getLikes() {
		return likes;
	}

	public GENRE getGenre() {
		return genre;
	}

	@Override
	public int compareTo(Movie o) {
		if (this.getLikes() > o.getLikes())
			return 1;
		else
			return -1;
	}

}
