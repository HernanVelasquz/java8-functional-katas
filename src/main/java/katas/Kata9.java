package katas;

import com.codepoetics.protonpack.StreamUtils;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import model.Bookmark;
import model.Movie;
import model.MovieList;
import util.DataUtil;

import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/*
    Goal: Retrieve each video's id, title, middle interesting moment time, and smallest box art url
    DataSource: DataUtil.getMovies()
    Output: List of ImmutableMap.of("id", 5, "title", "some title", "time", new Date(), "url", "someUrl")
*/
public class Kata9 {
    public static List<Map> execute() {
        List<MovieList> movieLists = DataUtil.getMovieLists();
        return movieLists.stream()
                .map(listM -> listM.getVideos())
                .flatMap(x -> x.stream())
                .map(list ->
                        ImmutableMap.of("id", list.getId(), "title", list.getTitle(), "time",
                                new Date(), "url",
                                list.getBoxarts().stream().min(Comparator.comparing(boxArt -> boxArt.getWidth()))
                        )).collect(Collectors.toList());
    }
}
