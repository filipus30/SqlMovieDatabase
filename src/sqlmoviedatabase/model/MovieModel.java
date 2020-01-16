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
import sqlmoviedatabase.bll.LogicManager;

/**
 *
 * @author PC
 */


public final class MovieModel  {
  
    private ObservableList<Movie> movielist;
    private LogicFacade logicManager;
    
    public MovieModel() {
        logicManager = new LogicManager();
        getmovielist();
    }
    
        public ObservableList<Movie> getmovielist() {
        List<Movie> allMovies = logicManager.getAllMovies();
        for (Movie movie1 : allMovies) {
            //Save the converted time in the hh:mm:ss format before adding the song to an ObservableList.
          // movie1.setStringTime(sec_To_Format(movie1.getDuration()));
        }
        movielist = FXCollections.observableArrayList(allMovies);
        return movielist;
    }
        public String sec_To_Format(int sec) {
        return logicManager.sec_To_Format(sec);
    }
      
        public int format_To_Sec(String timeString) {
        return logicManager.format_To_Sec(timeString);
    }
        public void createMovie(String title, int time, String genre, String path) {
        Movie movie = logicManager.createMovie(title, time, genre, path);
        movielist.add(movie);
    }
        
        public void UpdateMovie(Movie movie, String editedTitle, String editedGenre, int editedTime, String editedPath) {
        logicManager.UpdateMovie(movie, editedTitle, editedGenre, editedTime, editedPath);
    }
        
        public void deleteMovie(Movie movie) {
        logicManager.deleteMovie(movie);
        movielist.remove(movie);
    }

}
