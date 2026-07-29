package main.java.ru.alfabank.homework14;

import java.util.Comparator;
import ru.alfabank.homework14.sub1.Movie;

public class MovieRatingComparator implements Comparator<Movie> {

  @Override
  public int compare(Movie m1, Movie m2) {
    return Double.compare(m1.getRating(), m2.getRating());
  }

}
