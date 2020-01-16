/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sqlmoviedatabase.model;

import sqlmoviedatabase.be.Category;

/**
 *
 * @author Martyna Cieslik
 */
public class MainModel {
    private static MainModel instance;
    private Category categorytodel,categorytoedit;
    private boolean editing;
     private MainModel()
     {
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
}
