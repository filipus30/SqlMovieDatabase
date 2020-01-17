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
public class Category {
private String Catname;
    public Category(String catname)
    {
        this.Catname = catname;
    }
            
     public String getCatname()
    {
        return Catname;
    }
    @Override
    public String toString() {
        
        return  getCatname();
    }
}