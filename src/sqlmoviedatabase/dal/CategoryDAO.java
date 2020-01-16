/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sqlmoviedatabase.dal;

import com.microsoft.sqlserver.jdbc.SQLServerDataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import sqlmoviedatabase.be.Category;
import sqlmoviedatabase.be.Movie;

/**
 *
 * @author Abdi
 */
public class CategoryDAO {
     SQLServerDataSource ds;
    public CategoryDAO()
    {
        ds = new SQLServerDataSource();
                 ds.setDatabaseName("SQLMovieDatabase");
                 ds.setUser("CSe19B_6");
                 ds.setPassword("CSe19B_6");
                 ds.setPortNumber(1433);
                 ds.setServerName("10.176.111.31");
    }
    public List<Category> getAllCategories() 
    { 
        List<Category> categories = new ArrayList();//create a list to store all our categories
        try (Connection con = ds.getConnection()){
            String sqlStatement = "SELECT * FROM CATEGORIES"; //The SQL statement
            Statement statement = con.createStatement();
            ResultSet rs = statement.executeQuery(sqlStatement);//fetch the result of the SQL statement and store it.
            while(rs.next())//While there is something listed...
            {
                //Fetch all the relevant info
                String catname = rs.getString("CatName");
               
                Category p = new Category(catname);
               categories.add(p);//Add the category to the list.
            }
            
        } catch (SQLException ex) {
             Logger.getLogger(CategoryDAO.class.getName()).log(Level.SEVERE, null, ex);
         }
        
        
        return categories;//return the list of categories.
    }
}
