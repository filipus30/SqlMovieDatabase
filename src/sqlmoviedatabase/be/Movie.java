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
public Movie(String title,int personal_rating,float imdb_rating)
{
    this.Title = title;
  //  this.Category = category;
  this.Personal_rating = personal_rating;
  this.Imdb_rating = imdb_rating;
  
}

public String getTitle()
{
    return Title;
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
}

