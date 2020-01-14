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
import java.sql.PreparedStatement;
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
            String sqlStatement = "SELECT M.MovId, M.Title, M.Personal_Rating, M.IMDB_Rating, M.LastView, M.FileLink, M.Duration, C.CatName FROM Movies M, Categories C, CatMov  CM WHERE M.MovId = CM.MovId AND CM.CatId=C.CatId ORDER BY M.Title;"; //The SQL statement
            Statement statement = con.createStatement();
            ResultSet rs = statement.executeQuery(sqlStatement);//fetch the result of the SQL statement and store it.
            while(rs.next())//While there is something listed...
            {
                //Fetch all the relevant info
                int movid = rs.getInt("MovId");
                String title = rs.getString("Title");
                String category = rs.getString("CatName") + " ";
                int personalrating = rs.getInt("Personal_Rating");
                float imdbrating = rs.getFloat("IMDB_Rating");
                String lastview = rs.getString("LastView");
                String filelocation =rs.getString("FileLink");
                String duration =rs.getString("Duration");

                

                
                
                if(movies.isEmpty()){
                    //Create a new instance of the busioness entity Song with the values.
                    Movie p = new Movie(movid, title,personalrating,imdbrating,lastview,filelocation,category,duration);
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
                        Movie p = new Movie(movid, title,personalrating,imdbrating,lastview,filelocation,category,duration);
                        movies.add(p);//Add the movie to the list.
                    }
                
                }

            }
            
        }
        
        
        return movies;//return the list of movies.
    }
    
    public Movie UpdateMovie (Movie movie, String title, int personalRating, float imdbRating, String lastView, String fileLocation, String duration, String categories){
        try(Connection con = ds.getConnection()){
        
            String sqlUpdateMovie = "UPDATE Movies SET Personal_Rating=?, IMDB_Rating=?, LastView=?, FileLink=?, Duration=? WHERE Title=?;";
            PreparedStatement pstmt = con.prepareStatement(sqlUpdateMovie);
            
            pstmt.setInt(1, personalRating);
            pstmt.setFloat(2,imdbRating);
            pstmt.setString(3, "" + lastView + "");
            pstmt.setString(4, "" + fileLocation + "");
            pstmt.setString(5, "" + duration + "");
            pstmt.setString(5, "" + title+ "");
            pstmt.execute();
            
            String sqlRemoveCategories = "DELETE FROM CatMov WHERE MovID=?";
            PreparedStatement remstmt =con.prepareStatement(sqlRemoveCategories);
            remstmt.setInt(1, movie.getmovId());
            remstmt.execute();
            
            String[] cat = categories.split(",");
            
            for(int i=0; i<cat.length ; i++){
                String catstmt = "SELECT * FROM Categories WHERE CatName=?;";
                Statement statement = con.createStatement();
                ResultSet crs = statement.executeQuery(catstmt);//fetch the result of the SQL statement and store it.
                while(crs.next()){ //While there is something listed...
                    int categoryID = crs.getInt("CatId");
                    String enterCat ="INSERT INTO CatMov VALUES MovID=?, CatID=?";
                    PreparedStatement catSetstmt = con.prepareStatement(enterCat);
                    catSetstmt.setInt(1, movie.getmovId());
                    catSetstmt.setInt(2, categoryID);
                    catSetstmt.execute();
                }
            }
            
            
        } catch (SQLServerException ex) {
            Logger.getLogger(MovieDAO.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Unable to update Movie.");
        } catch (SQLException ex) {
            Logger.getLogger(MovieDAO.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Unable to update Movie.");
        }
        
        return new Movie(movie.getmovId(), title, personalRating, imdbRating, lastView, fileLocation, categories, duration);
    }

    public void deleteMovie(Movie movie){
        try(Connection con = ds.getConnection()){
            String sqldeletestmt = "DELETE FROM CatMov WHERE MovId=? ; DELETE FROM Movies WHERE MovId=?;";
            PreparedStatement delstmt = con.prepareStatement(sqldeletestmt);
            delstmt.setInt(1, movie.getmovId());
            delstmt.setInt(2, movie.getmovId());
            delstmt.execute();
            
        } catch (SQLServerException ex) {
            Logger.getLogger(MovieDAO.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Unable to delete Movie.");
        } catch (SQLException ex) {
            Logger.getLogger(MovieDAO.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Unable to delete Movie.");
        }
    }

}
