/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sqlmoviedatabase.dal;

import com.microsoft.sqlserver.jdbc.SQLServerException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Abdi
 */
public class GenreDAO {
    
    private final ConnectDAO connectDAO;

    public GenreDAO() {
        connectDAO = new ConnectDAO();
    }

    /**
     * Gets all the genres from the database table genre.
     *
     * @return A list of all the genres.
     */
    public List<String> getAllGenres() {
        //Create a String array to store all genres.
        List<String> allGenres = new ArrayList();
        try ( //Get a connection to the database.
            Connection con = connectDAO.getConnection()) {
            //Create a prepared statement.
            String sql = "SELECT * FROM genre";
            PreparedStatement pstmt = con.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                //Add the genres to the String array.
                allGenres.add(rs.getString("name"));
            }
            return allGenres;
        } catch (SQLServerException ex) {
            Logger.getLogger(GenreDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(GenreDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    /**
     * Creates and adds a new genre to the database.
     *
     * @param name The name of the newly created genre.
     */
    public void createGenre(String name) {
        try ( //Get a connection to the database.
            Connection con = connectDAO.getConnection()) {
            String sql = "INSERT INTO genre VALUES (?)";
            //Create a prepared statement.
            PreparedStatement pstmt = con.prepareStatement(sql);
            //Set parameter value.
            pstmt.setString(1, name);
            //Execute SQL query.
            pstmt.executeUpdate();

        } catch (SQLServerException ex) {
            Logger.getLogger(GenreDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(GenreDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Deletes a genre in the database.
     *
     * @param name The name of the deleted genre.
     */
    public void deleteGenre(String name) {
        try ( //Get a connection to the database.
            Connection con = connectDAO.getConnection()) {
            //Create a prepared statement.
            String sql = "DELETE FROM genre WHERE name = ?";
            PreparedStatement pstmt = con.prepareStatement(sql);
            //Set parameter values.
            pstmt.setString(1, name);
            //Execute SQL query.
            pstmt.executeUpdate();
        } catch (SQLServerException ex) {
            Logger.getLogger(GenreDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(GenreDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
