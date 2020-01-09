/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sqlmoviedatabase.be;

/**
 *
 * @author Abdi
 */
public class Movie {
    
private final int id;
    private String title;
    private int time;
    private String path;
    private String genre;
    private String stringTime;

    /**
     * Constructs a new movie.
     *
     * @param id ID of the movie.
     * @param title Title of the movie.
     * @param time Time (duration) of the movie.
     * @param path Path of the movie.
     * @param genre Genre of the movie.
     */
    public Movie(int id, String title, int time, String path, String genre) {
        this.id = id;
        this.title = title;
        this.time = time;
        this.path = path;
        this.genre = genre;
    }

    /**
     * Gets the ID of the movie.
     *
     * @return The ID of the movie.
     */
    public int getId() {
        return id;
    }

    /**
     * Gets the title of the movie.
     *
     * @return The title of the movie.
     */
    public String getTitle() {
        return title;
    }

    /**
     * Sets the title of the movie.
     *
     * @param title The title to set.
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * Gets the path of the movie.
     *
     * @return The path of the movie.
     */
    public String getPath() {
        return path;
    }

    /**
     * Sets the path of the movie.
     *
     * @param path The path to set.
     */
    public void setPath(String path) {
        this.path = path;
    }

    /**
     * Gets the genre of the movie.
     *
     * @return The genre of the movie.
     */
    public String getGenre() {
        return genre;
    }

    /**
     * Sets the genre of the movie.
     *
     * @param genre The genre to set.
     */
    public void setGenre(String genre) {
        this.genre = genre;
    }

    /**
     * Gets the time of the movie.
     *
     * @return The time of the movie.
     */
    public int getTime() {
        return time;
    }

    /**
     * Gets the time in the format hh:mm:ss.
     *
     * @return The formatted time.
     */
    public String getStringTime() {
        return stringTime;
    }

    /**
     * Sets the time in the format hh:mm:ss.
     * @param stringTime
     */
    public void setStringTime(String stringTime) {
        this.stringTime = stringTime;
    }

    @Override
    public String toString() {
        return title;
    }
}