/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sqlmoviedatabase.bll;

import java.util.List;
import sqlmoviedatabase.be.Category;
import sqlmoviedatabase.be.Movie;

/**
 *
 * @author Abdi
 */
public interface LogicFacade {
    
    
     public Movie createMovie(int movid, String title,int personal_rating,float imdb_rating, String lastview ,String fileLocation, String category, String duration);


    List<Movie> getAllMovies();


   Movie UpdateMovie(Movie movie, String editedTitle, int personalRating, float imdbRating, String lastView, String fileLocation, String duration, String categories);


    void deleteMovie(Movie movie);

    
    void createGenre(String name);

 
    List<String> getAllGenres();


    void deleteGenre(String name);

    
    List<Movie> search(List<Movie> searchBase, String query);

    
    String sec_To_Format(int sec);

    
    int format_To_Sec(String formatString);
    

    List<Category> getAllCategories();

    
    Category createCategory(String name);
    
    void deleteCategory(String name);
    void editCategory(String name,String newname);
    boolean checkMovieTitle(String title);
}