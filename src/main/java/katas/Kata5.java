package katas;

import model.Movie;
import util.DataUtil;

import java.util.List;
import java.util.stream.Stream;

/*
    Goal: Retrieve the largest rating using reduce()
    DataSource: DataUtil.getMovies()
    Output: Double
*/
public class Kata5 {
    public static Double execute() {
        List<Movie> movies = DataUtil.getMovies();

        return movies.stream()
                .reduce((a, b) -> (a.getRating() > b.getRating()) ? a : b)
                .get()
                .getRating();
    }
}
