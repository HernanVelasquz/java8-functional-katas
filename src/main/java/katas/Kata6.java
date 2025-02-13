package katas;

import model.Movie;
import util.DataUtil;

import java.util.List;

/*
    Goal: Retrieve the url of the largest boxart using map() and reduce()
    DataSource: DataUtil.getMovieLists()
    Output: String
*/
public class Kata6 {
    public static String execute() {
        List<Movie> movies = DataUtil.getMovies();

        return movies.stream()
                .map(listBoxFla -> listBoxFla.getBoxarts())
                .flatMap(boxArts -> boxArts.stream())
                .map(url -> url.getUrl())
                .reduce((a , b) -> (a.length() > b.length()) ? a : b)
                .get();
    }
}
