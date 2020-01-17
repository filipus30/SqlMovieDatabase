/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sqlmoviedatabase.bll;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import sqlmoviedatabase.be.Category;
import sqlmoviedatabase.be.Movie;
import sqlmoviedatabase.bll.util.TimeConverter;
import sqlmoviedatabase.dal.CategoryDAO;
import sqlmoviedatabase.dal.DalController;
import sqlmoviedatabase.dal.MovieDAO;

/**
 *
 * @author Abdi
 */

public class LogicManager implements LogicFacade{
    DalController dc = new DalController();
    CategoryDAO cd = new CategoryDAO();
    MovieDAO md = new MovieDAO();
    private final TimeConverter timeConverter;
    
        public LogicManager() {
            
        timeConverter = new TimeConverter();
    }
    
    public List<Movie> getAllMovies()
    {
        return dc.getAllMovies();
    }

     public List<Movie> search(List<Movie> searchBase, String query) {
          
       List<Movie> filtered = FXCollections.observableArrayList();

        if (query.isEmpty()) {
            return searchBase;
        }

        for (Movie movie : searchBase) {
            if (movie.getTitle().toLowerCase().contains(query.toLowerCase()))
            {
                filtered.add(movie);
            }
        }

        return filtered;
    }

     
       public List<Movie> searchcat(List<Movie> searchBase, String query) {
          
       List<Movie> filtered = FXCollections.observableArrayList();

        if (query.isEmpty()) {
            return searchBase;
        }

        for (Movie movie : searchBase) {
            if (movie.getCategory().toLowerCase().contains(query.toLowerCase() )) //|| movie.getCategory().toLowerCase().contains(query.toLowerCase())
            {
                filtered.add(movie);
            }
        }

        return filtered;
    }
       
        public List<Movie> searchrat(List<Movie> searchBase, int rate) {
          
       List<Movie> filtered = FXCollections.observableArrayList();

        for (Movie movie : searchBase) {
            if (movie.getImdb_Rating() >= rate ) //|| movie.getCategory().toLowerCase().contains(query.toLowerCase())
            {
                filtered.add(movie);
            }
        }

        return filtered;
    }
    @Override
    public Movie createMovie(String title, int time, String path, String genre) {
      return md.createMovie(time, title, time, time, path, path, genre, path);
    }

    @Override
    public Movie updateMovie(Movie movie, String editedTitle, String editedGenre, int editedTime, String editedPath) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void deleteMovie(Movie movie) {
       md.deleteMovie(movie); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void createGenre(String name) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<String> getAllGenres() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void deleteGenre(String name) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String sec_To_Format(int sec) {
        return timeConverter.sec_To_Format(sec);
    }

    @Override
    public int format_To_Sec(String formatString) {
        return timeConverter.format_To_Sec(formatString);
    }

       public int getNewMovId(){
        int newMovId = md.getLastMovId();
        return newMovId +1;
    }

  
    @Override
    public List<Category> getAllCategories() {
            return  cd.getAllCategories();
      }

   
    @Override
    public Category createCategory(String name) {
      return cd.createCategory(name);
    }

    @Override
    public void deleteCategory(String name) {
       cd.deleteCategory(name);
    }
    @Override
    public void  editCategory(String name,String newname)
    {
        cd.EditCategory(name,newname);
    }
    
     

}
