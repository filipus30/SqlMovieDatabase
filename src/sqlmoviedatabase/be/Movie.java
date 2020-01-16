/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sqlmoviedatabase.be;

/**
 *

 * @author filip
 */
public class Movie {

    private int MovId;
    private String Title;
    private String Category;
    private int Personal_rating;
    private float Imdb_rating;
    private String Lastview;
    private String Duration;
    private String FileLocation;
    
    public Movie(int movid, String title,int personal_rating,float imdb_rating, String lastview ,String fileLocation, String category, String duration)
    {
        this.MovId = movid;
        this.Title = title;
        this.Category = category;
        this.FileLocation = fileLocation;
        this.Personal_rating = personal_rating;
        this.Imdb_rating = imdb_rating;
        this.Lastview = lastview;
        this.Duration = duration;
    }
    
    public int getmovId()
    {
        return MovId;
    }

    public String getFileLocation()
    {
        return FileLocation;
    }

    public String getTitle()
    {
        return Title;
    }
    public String getCategory()
    {
        return Category;
    }

    public void setCategory(String cat)
    {
        Category = cat;
    }

    public int getPersonal_Rating()
    {
        return Personal_rating;
    }
    public float getImdb_Rating()
    {
        return Imdb_rating;
    }
    public String getLastView()
    {
        return Lastview;
    }
    
    public String getDuration()
    {
        return Duration;
    }
    
    public void setDuration(String duration)
    {
        this.Duration = duration;
    }

       @Override
    public String toString() {
        return Title;
    }
   
     
    

}