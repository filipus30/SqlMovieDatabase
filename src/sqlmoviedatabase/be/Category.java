/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sqlmoviedatabase.be;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Abdi
 */
    public class Category {
    private String Catname;
    private String name;
    private List<Movie> movies;
    private int numberOfMovies;
    
    public Category(String name)
    {
        this.name = name;
        movies = new ArrayList();
        numberOfMovies = movies.size();
    }
            
     public String getCatname()
    {
        return Catname;
    }
    @Override
    public String toString() {
        
        return  getCatname();
    }

 
    public String getName() {
        return name;
    }


    public void setName(String name) {
        this.name = name;
    }


    public List<Movie> getMovies() {
        return movies;
    }

    public int getNumberOfMovies() {
        return numberOfMovies;
    }


    public void addMovie(Movie movie) {
        movies.add(movie);
        numberOfMovies = movies.size();
    }


    public void removeMovies(Movie movie) {
        movies.remove(movie);
        numberOfMovies--;
    }
}