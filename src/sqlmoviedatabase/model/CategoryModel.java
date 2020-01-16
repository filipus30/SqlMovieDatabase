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
import sqlmoviedatabase.be.Category;
import sqlmoviedatabase.bll.LogicFacade;
import sqlmoviedatabase.bll.LogicManager;

/**
 *
 * @author PC
 */
public class CategoryModel {
    
    private ObservableList<Category> categorylist;
    private final LogicFacade logicLayer;

    /**
     * Initialize the BLL manager.
     */
    public CategoryModel() {
        logicLayer = (LogicFacade) new LogicManager();
    }
    
        public ObservableList<Category> getcategorylist() {
        List<Category> allCategories = logicLayer.getAllCategories();
        for (Category category1 : allCategories) {
            //Save the converted time in the hh:mm:ss format before adding the  to an ObservableList.
        //category1.setStringTime(sec_To_Format(category1.getDuration()));
        }
        categorylist = FXCollections.observableArrayList(allCategories);
        return categorylist;
    }

    /**
     * Gets all genres from the database.
     *
     * @return A String list of all genres.
     */
    public List<Category> getAllCategories() {
        return logicLayer.getAllCategories();
    }

    /**
     * Creates a new genre.
     *
     * @param name The name of the newly created genre.
     */

    public Category createCategory(String name) {
       return logicLayer.createCategory(name);

    }

    public void deleteCategory(String name) {
       logicLayer.deleteCategory(name);
    }
        
}