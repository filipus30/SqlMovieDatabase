/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sqlmoviedatabase.model;

import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import sqlmoviedatabase.be.Category;
import sqlmoviedatabase.be.Movie;
import sqlmoviedatabase.bll.LogicFacade;
import sqlmoviedatabase.bll.LogicManager;

/**
 *
 * @author Martyna Cieslik
 */
public class MainModel {
    private static MainModel instance;
    private Category categorytodel,categorytoedit;
    private boolean editing;
    private LogicFacade logicManager;
    private List<Movie> movieList;
     private MainModel()
     {
        logicManager = new LogicManager();
        movieList = FXCollections.observableArrayList(logicManager.getAllMovies());
         editing = false;
         categorytodel = new Category("");
     }
    public static MainModel GetInstance() //Needed so that we always work in the same instance of the MainModel.
    {
        if(instance == null)
        {
            instance = new MainModel();
        }
        return instance;
    }
    
    
    public Category getCategory()
    {
        return categorytodel;
    }
    
    public void setCategory(Category category)
    {
        categorytodel = category;
    }
    public boolean getEditing()
    {
        return editing;
    }
    public void setEditingTrue()
    {
        editing = true;
    }
    public void setEditingFalse()
    {
        editing = false;
    }
    public void setMovieList(List<Movie> filtered)
    {
        movieList = filtered;
    }
    public List<Movie> getMovieList()
    {
        return movieList;
    }
}
