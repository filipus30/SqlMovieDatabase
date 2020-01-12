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
            String sqlStatement = "SELECT M.Title, M.Personal_Rating, M.IMDB_Rating, M.LastView, M.FileLink, C.CatName FROM Movies M, Categories C, CatMov  CM WHERE M.MovId = CM.MovId AND CM.CatId=C.CatId ORDER BY M.Title;"; //The SQL statement
            Statement statement = con.createStatement();
            ResultSet rs = statement.executeQuery(sqlStatement);//fetch the result of the SQL statement and store it.
            while(rs.next())//While there is something listed...
            {
                //Fetch all the relevant info
                String title = rs.getString("Title");
                String category = rs.getString("CatName") + " ";
                int personalrating = rs.getInt("Personal_Rating");
                float imdbrating = rs.getFloat("IMDB_Rating");
                String lastview = rs.getString("LastView");
                
                

                
                if(movies.isEmpty()){
                    //Create a new instance of the busioness entity Song with the values.
                    Movie p = new Movie(title,personalrating,imdbrating,lastview,category);
                    movies.add(p);//Add the movie to the list.
                }
                
                else if(movies.isEmpty() == false){
                    boolean movieedit = false;                   
                    
                    for(Movie m : movies){
                        Movie currentMovie = m;
                        String currentTitle = currentMovie.getTitle();

                        if(currentTitle.equals(title)) {
                            category = currentMovie.getCategory().concat(category);
                            currentMovie.setCategory(category);
                            movieedit = true;
                        }

                    }
                
                
                    if(movieedit == false){
                        //Create a new instance of the busioness entity Song with the values.
                        Movie p = new Movie(title,personalrating,imdbrating,lastview,category);
                        movies.add(p);//Add the movie to the list.
                    }
                
                }

            }
            
        }
        
        
        return movies;//return the list of movies.
    }
}