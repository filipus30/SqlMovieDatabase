/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sqlmoviedatabase.model;

import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import sqlmoviedatabase.be.Movie;
import sqlmoviedatabase.bll.LogicFacade;

/**
 *
 * @author PC
 */


public final class MovieModel  {
  
    private ObservableList<Movie> LibraryList;
    private LogicFacade logicManager;
    
    
        public ObservableList<Movie> getLibraryList() {
        List<Movie> allMovies = logicManager.getAllMovies();
        for (Movie movie1 : allMovies) {
            //Save the converted time in the hh:mm:ss format before adding the song to an ObservableList.
            movie1.setStringTime(sec_To_Format(movie1.getTime()));
        }
        LibraryList = FXCollections.observableArrayList(allMovies);
        return LibraryList;
    }
        public String sec_To_Format(int sec) {
        return logicManager.sec_To_Format(sec);
    }
      
        public int format_To_Sec(String timeString) {
        return logicManager.format_To_Sec(timeString);
    }
        public void createMovie(String title, int time, String genre, String path) {
        Movie movie = logicManager.createMovie(title, time, path, genre);
        LibraryList.add(movie);
    }
        
        public void updateMovie(Movie movie, String editedTitle, String editedGenre, int editedTime, String editedPath) {
        logicManager.updateMovie(movie, editedTitle, editedGenre, editedTime, editedPath);
    }
        
        public void deleteMovie(Movie movie) {
        logicManager.deleteMovie(movie);
        LibraryList.remove(movie);
    }

}
