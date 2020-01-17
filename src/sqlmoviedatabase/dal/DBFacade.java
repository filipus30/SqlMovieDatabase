/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sqlmoviedatabase.dal;

import java.util.List;
import sqlmoviedatabase.be.Category;
import sqlmoviedatabase.be.Movie;

/**
 *
 * @author Abdi
 */
public interface DBFacade {
    

  Movie createMovie(int movid, String title,int personal_rating,float imdb_rating, String lastview ,String fileLocation, String category, String duration);


  Movie UpdateMovie(Movie movie, String title, int personalRating, float imdbRating, String lastView, String fileLocation, String duration, String categories);

    Movie createMovie(String title, String artist, int time, String path, String genre);


   



    void deleteMovie(Movie movie);


    List<Movie> getAllMovies();

    Category createCategory(String name);


    List<String> getAllGenres();


    void createGenre(String name);


    void deleteGenre(String name);

    public void UpdateMovie(Movie movie, String editedTitle, String editedGenre, int editedTime, String editedPath);
}
