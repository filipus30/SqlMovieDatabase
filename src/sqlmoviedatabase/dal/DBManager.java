/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sqlmoviedatabase.dal;

import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import sqlmoviedatabase.be.Category;
import sqlmoviedatabase.be.Movie;
import sqlmoviedatabase.bll.LogicManager;

/**
 *
 * @author Abdi
 */
public class DBManager implements DBFacade {
    
    private CategoryDAO categoryDAO;
    private MovieDAO movieDAO;
    private final GenreDAO genreDAO;

    /**
     * Constructs data access objects.
     */
    public DBManager() {
        categoryDAO = new CategoryDAO();
        movieDAO = new MovieDAO();
        genreDAO = new GenreDAO();
    }

    public Movie createMovie(int movid, String title,int personal_rating,float imdb_rating, String lastview ,String fileLocation, String category, String duration){
        return movieDAO.createMovie(movid, title, personal_rating,imdb_rating, lastview, fileLocation, category, duration);
    }

    public List<Movie> getAllMovies() {
        try {
            return movieDAO.getAllMovies();
        } catch (SQLException ex) {
            Logger.getLogger(LogicManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public Movie UpdateMovie(Movie movie, String title, int personalRating, float imdbRating, String lastView, String fileLocation, String duration, String categories) {
          return new Movie(movie.getmovId(), title, personalRating, imdbRating, lastView, fileLocation, categories, duration);
        //return movieDAO.UpdateMovie(movId, title, personalRating, imdbRating, lastView, fileLocation, categories, duration);
    }

    public void deleteMovie(Movie movie) {
        movieDAO.deleteMovie(movie);
    }


    public void createCategory(Category category) {
        categoryDAO.createCategory(category);
    }

    public List<Category> getAllCategories() {
        return categoryDAO.getAllCategories();

    }

    public Category updateCategory(Category category, String editedName) {
        return categoryDAO.updateCategory(category, editedName);
    }

    public void deleteCategory(Category category) {
        categoryDAO.deleteCategory(category);
    }

    public void createGenre(String name) {
        genreDAO.createGenre(name);
    }

    public List<String> getAllGenres() {
        return genreDAO.getAllGenres();
    }

    public void deleteGenre(String name) {
        genreDAO.deleteGenre(name);
    }

    @Override
    public void UpdateMovie(Movie movie, String editedTitle, String editedGenre, int editedTime, String editedPath) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Movie createMovie(String title, int time, String path, String genre) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void deleteCategory(String name) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
