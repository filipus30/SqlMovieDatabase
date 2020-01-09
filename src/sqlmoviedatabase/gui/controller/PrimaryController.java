/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sqlmoviedatabase.gui.controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author Abdi
 */
public class PrimaryController implements Initializable {

    @FXML
    private TableView<?> tbv_Library;
    @FXML
    private TableColumn<?, ?> col_IMDbRating;
    @FXML
    private Button btn_edit;
    @FXML
    private Button btn_remove;
    @FXML
    private Button btn_add;
    @FXML
    private Button btn_editCategory;
    @FXML
    private Button btn_addCategory;
    @FXML
    private Button btn_deleteCategory;
    @FXML
    private TableColumn<?, ?> col_movieTitle;
    @FXML
    private TableColumn<?, ?> col_movieGenres;
    @FXML
    private TableColumn<?, ?> col_length;
    @FXML
    private TableColumn<?, ?> col_userRating;
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
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
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
