/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sqlmoviedatabase.dal;
import com.microsoft.sqlserver.jdbc.SQLServerDataSource;
import com.microsoft.sqlserver.jdbc.SQLServerException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import sqlmoviedatabase.be.Category;
import sqlmoviedatabase.be.Movie;
/**
 *
 * @author filip
 */
public class DalController {
     private List<Movie> movielist;
     private List<Category> categorylist;
     private MovieDAO moviedao;
     private CategoryDAO categorydao;

    public DalController()
    {
    categorydao = new CategoryDAO();
    moviedao = new MovieDAO();
    }
         
     public List<Movie> getAllMovies()
     {
         try
         {
        movielist = moviedao.getAllMovies();
         }
          catch(SQLException e)
          {
              
          }
         return movielist;
     }
     
     public List<Category> getAllCategories()
     {
         try
         {
             categorylist = categorydao.getAllCategories();
         }
         catch(SQLException e)
         {
             
         }
         return categorylist;
     }

}
