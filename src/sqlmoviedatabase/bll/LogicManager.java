/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sqlmoviedatabase.bll;

import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import sqlmoviedatabase.be.Movie;
import sqlmoviedatabase.dal.DalController;

/**
 *
 * @author Abdi
 */
public class LogicManager {
    DalController dc = new DalController();
    
    public List<Movie> getAllMovies()
    {
        return dc.getAllMovies();
    }
    
    
     public ObservableList<Movie> search(ObservableList<Movie> searchBase, String query) {
          
       ObservableList<Movie> filtered = FXCollections.observableArrayList();

        if (query.isEmpty()) {
            return searchBase;
        }

        for (Movie movie : searchBase) {
            if (movie.getTitle().toLowerCase().contains(query.toLowerCase() )) //|| movie.getCategory().toLowerCase().contains(query.toLowerCase())
            {
                filtered.add(movie);
            }
        }

        return filtered;
    }
}
