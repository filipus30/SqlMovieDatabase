/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sqlmoviedatabase.dal;

/**
 *
 * @author Abdi
 */
 

import com.microsoft.sqlserver.jdbc.SQLServerDataSource;
import com.microsoft.sqlserver.jdbc.SQLServerException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import sqlmoviedatabase.be.Movie;

public class MovieDAO {
    SQLServerDataSource ds;
    public MovieDAO()
            {
                 ds = new SQLServerDataSource();
                 ds.setDatabaseName("SQLMovieDatabase");
                 ds.setUser("CSe19B_6");
                 ds.setPassword("CSe19B_6");
                 ds.setPortNumber(1433);
                 ds.setServerName("10.176.111.31");
            }
    public List<Movie> getAllMovies() throws SQLException
    { 
        List<Movie> movies = new ArrayList();//create a list to store all our movies
        try (Connection con = ds.getConnection()){
            String sqlStatement = "SELECT * FROM MOVIES"; //The SQL statement
            Statement statement = con.createStatement();
            ResultSet rs = statement.executeQuery(sqlStatement);//fetch the result of the SQL statement and store it.
            while(rs.next())//While there is something listed...
            {
                //Fetch all the relevant info
                String title = rs.getString("Title");
                int personalrating = rs.getInt("Personal_Rating");
                float imdbrating = rs.getFloat("IMDB_Rating");
                String lastview = rs.getString("LastView");
                String path = rs.getString("Path");
                int time = rs.getInt("Time");
                
                // String category = rs.getString("CatName");
              //  int id = rs.getInt("id");
                //Create a new instance of the busioness entity Song with the values.
                Movie p = new Movie(title,personalrating,imdbrating,lastview,time,path);
                movies.add(p);//Add the movie to the list.
            }
            
        }
        
        
        return movies;//return the list of movies.
    }
}
