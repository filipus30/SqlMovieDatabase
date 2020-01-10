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
private String Title;
private String Category;
private int Personal_rating;
private float Imdb_rating;
private String Lastview;
private int time;
private String stringTime;
private String path;
private String genre;

public Movie(String title,int personal_rating,float imdb_rating,String lastview)
{
    this.Title = title;
  //  this.Category = category;
  this.Personal_rating = personal_rating;
  this.Imdb_rating = imdb_rating;
  this.Lastview = lastview;
  this.time = time;
  this.path = path;

}

public String getTitle()
{
    return Title;
}
public void setTitle(String title) {
    this.Title = title;
}
public String getCategory()
{
    return Category;
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

 public int getTime() {
        return time;
    }      
  public void setStringTime(String stringTime) {
  this.stringTime = stringTime;
    }
   public String getStringTime() {
   return stringTime;
    }
       @Override
    public String toString() {
        return Title;
    }
   
       public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }
    
        public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }
    

}