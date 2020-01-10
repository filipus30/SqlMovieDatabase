/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sqlmoviedatabase.dal;

import java.util.List;
import sqlmoviedatabase.be.Movie;

/**
 *
 * @author Abdi
 */
public interface DBFacade {
    
    Movie createMovie(String title, String artist, int time, String path, String genre);


    Movie updateMovie(Movie movie, String editedTitle, String editedGenre, int editedTime, String path);


    void deleteMovie(Movie movie);


    List<Movie> getAllMovie();



    List<String> getAllGenres();


    void createGenre(String name);


    void deleteGenre(String name);
}
