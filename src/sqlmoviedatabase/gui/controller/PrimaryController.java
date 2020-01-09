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
import sqlmoviedatabase.be.Movie;
import sqlmoviedatabase.dal.DalController;

/**
 * FXML Controller class
 *
 * @author Abdi
 */
public class PrimaryController implements Initializable {



    @FXML
    private Button btn_add;

    @FXML
    private Button btn_play;
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
    private ComboBox<?> categories;
    @FXML
    private ComboBox<?> filter;
    @FXML
    private TableColumn<?, ?> col_lastViewed;

    /**
     * Initializes the controller class.
     */

    private TableView<Movie> tbv_Library;
    @FXML
    private TextField SearchBar;
    @FXML
    private Button btn_edit;
    @FXML
    private Button btn_remove;
    @FXML
    private TableColumn<Movie,String> col_title;
    @FXML
    private TableColumn<Movie,String> col_category;
    
     DalController dl = new DalController();
    @FXML
    private TableColumn<Movie,String> col_imdbrating;
    @FXML
    private TableColumn<Movie,String> col_userrating;
   
    @Override
    public void initialize(URL url, ResourceBundle rb) {
     ObservableList<Movie> movielist = FXCollections.observableArrayList(dl.getAllMovies());
     col_title.setCellValueFactory(new PropertyValueFactory ("title"));
     col_imdbrating.setCellValueFactory(new PropertyValueFactory ("Imdb_Rating"));
      col_userrating.setCellValueFactory(new PropertyValueFactory ("Personal_Rating"));
    tbv_Library.setItems(movielist);
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
    
}
