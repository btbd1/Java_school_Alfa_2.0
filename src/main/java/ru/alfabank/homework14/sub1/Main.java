package ru.alfabank.homework14;

import java.io.PrintStream;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.ArrayList;
import main.java.ru.alfabank.homework14.Movie;
import main.java.ru.alfabank.homework14.MovieRatingComparator;

public class Main {

  public static void main(String[] args) {
    // Установка кодировки для вывода
    System.setOut(new PrintStream(System.out, true, StandardCharsets.UTF_8));

    List<Movie> movies = new ArrayList<>();

    movies.add(new Movie("Интерстеллар", 8.7));
    movies.add(new Movie("Шрек", 8.1));
    movies.add(new Movie("Начало", 8.8));
    movies.add(new Movie("Веном", 6.6));

    System.out.println("До сортировки:");
    for (Movie movie : movies) {
      System.out.println(movie);
    }

    movies.sort(new MovieRatingComparator());

    System.out.println("\nПосле сортировки:");
    for (Movie movie : movies) {
      System.out.println(movie);
    }
  }

}
