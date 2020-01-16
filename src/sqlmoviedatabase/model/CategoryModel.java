/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sqlmoviedatabase.model;

import java.util.List;
import sqlmoviedatabase.bll.LogicFacade;
import sqlmoviedatabase.bll.LogicManager;

/**
 *
 * @author PC
 */
public class CategoryModel {
    
    private final LogicFacade logicLayer;

    /**
     * Initialize the BLL manager.
     */
    public CategoryModel() {
        logicLayer = (LogicFacade) new LogicManager();
    }

    /**
     * Gets all genres from the database.
     *
     * @return A String list of all genres.
     */
    public List<String> getAllCategories() {
        return logicLayer.getAllCategories();
    }

    /**
     * Creates a new genre.
     *
     * @param name The name of the newly created genre.
     */
    public void createCategory(String name) {
        logicLayer.createCategory(name);
    }

    /**
     * Deletes a genre.
     *
     * @param name The name of the genre to be deleted.
     */
    public void deleteCategory(String name) {
        logicLayer.deleteCategory(name);
    }
}