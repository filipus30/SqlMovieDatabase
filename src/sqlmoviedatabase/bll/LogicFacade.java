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
    
    
    Movie createMovie(String title, int time, String genre, String path);
    
    List<Movie> getAllMovies();

    Movie UpdateMovie(Movie movie, String editedTitle, String editedGenre, int editedTime, String editedPath);
    

    void deleteMovie(Movie movie);

    
    void createGenre(String name);

 
    List<String> getAllGenres();


    void deleteGenre(String name);

    
    List<Movie> search(List<Movie> searchBase, String query);

    
    String sec_To_Format(int sec);

    
    int format_To_Sec(String formatString);
    

    List<Category> getAllCategories();

    void createCategory(Category category);
    

    void deleteCategory(Category category);
    
    Category updateCategory(Category category, String editedName);

    void deleteCategory(String name);

}