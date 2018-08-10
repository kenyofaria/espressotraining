package info.androidhive.recyclerview;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by kenyo on 07/08/18.
 */

public class DataMovie {

    private static List<Movie> movies = new ArrayList();

    public static void addMovie(Movie movie){
        movies.add(movie);
    }

    public static List<Movie> getMovies(){
        return movies;
    }
}
