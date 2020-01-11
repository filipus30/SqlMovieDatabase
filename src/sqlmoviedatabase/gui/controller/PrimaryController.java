/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sqlmoviedatabase.gui.controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;

import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;
import sqlmoviedatabase.be.Category;
import sqlmoviedatabase.be.Movie;
import sqlmoviedatabase.bll.LogicManager;
import sqlmoviedatabase.dal.MovieDAO;


/**
 * FXML Controller class
 *
 * @author Abdi
 */
public class PrimaryController implements Initializable {



    @FXML
    private Button btn_add;
    @FXML
    private Button btn_addCategory;
    @FXML
    private Button btn_deleteCategory;
    @FXML
    private TableColumn<?, ?> col_movieGenres;
    @FXML
    private TableColumn<?, ?> col_length;
    @FXML
    private TextField searchbar;
    @FXML
    private ComboBox<Category> categories;
    @FXML
    private ComboBox<?> filter;
    @FXML
    private TableColumn<Movie,String> col_lastViewed;
    @FXML
    private TableView<Movie> tbv_Library;
    @FXML
    private Button btn_edit;
    @FXML
    private Button btn_remove;
    @FXML
    private TableColumn<Movie,String> col_movieTitle;
    @FXML
    private TableColumn<Movie,String> col_IMDbRating;
    @FXML
    private TableColumn<Movie,String> col_userRating;
    @FXML
    private Button btn_editCategory;
     LogicManager lm = new LogicManager();
    @Override
    public void initialize(URL url, ResourceBundle rb) {
     ObservableList<Movie> movielist = FXCollections.observableArrayList(lm.getAllMovies());
     ObservableList<Category> categorylist = FXCollections.observableArrayList(lm.getAllCategories());
     col_movieTitle.setCellValueFactory(new PropertyValueFactory ("Title"));
     col_IMDbRating.setCellValueFactory(new PropertyValueFactory ("Imdb_Rating"));
     col_userRating.setCellValueFactory(new PropertyValueFactory ("Personal_Rating"));
     col_lastViewed.setCellValueFactory(new PropertyValueFactory ("LastView"));
     tbv_Library.setItems(movielist);
     categories.setItems(categorylist);
    }    




    @FXML
    private void handle_Adding(ActionEvent event) {
    }

    @FXML
    private void handle_Search(ActionEvent event) {
    }

    @FXML
    private void handle_Filter(ActionEvent event) {
    }

    @FXML
    private void handle_Categories(ActionEvent event) {
    }


    @FXML
    private void handle_addCategory(ActionEvent event) {
    }

    @FXML
    private void handle_deleteCategory(ActionEvent event) {
    }

    @FXML
    private void handle_editMovie(ActionEvent event) {
    }

    @FXML
    private void handle_removeMovie(ActionEvent event) {
    }

    @FXML
    private void handle_editCategory(ActionEvent event) {

    }

    @FXML
    private void handle_search(KeyEvent event) {
             ObservableList<Movie> movielist = FXCollections.observableArrayList(lm.getAllMovies());
       tbv_Library.setItems( lm.search(movielist,searchbar.getText()));
       
    }
    
}
