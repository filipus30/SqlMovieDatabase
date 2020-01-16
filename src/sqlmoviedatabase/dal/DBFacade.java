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

    List<Movie> getAllMovies();

    Movie UpdateMovie(Movie movie, String title, int personalRating, float imdbRating, String lastView, String fileLocation, String duration, String categories);

     void deleteMovie(Movie movie);

     void createCategory(Category category);

     List<Category> getAllCategories();



    Category createCategory(String name);



     void deleteCategory(Category category);


     void createGenre(String name);


     List<String> getAllGenres();


     void deleteGenre(String name);

    void UpdateMovie(Movie movie, String editedTitle, String editedGenre, int editedTime, String editedPath);

    Movie createMovie(String title, int time, String path, String genre);

    void deleteCategory(String name);

}
