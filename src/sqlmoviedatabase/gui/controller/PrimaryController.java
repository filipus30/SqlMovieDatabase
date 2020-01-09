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
    private TextField SearchBar;
    @FXML
    private Button btn_edit;
    @FXML
    private Button btn_remove;
    @FXML
    private TableColumn<?, ?> col_MovieTitle;
    @FXML
    private TableColumn<?, ?> col_Length;
    @FXML
    private TableColumn<?, ?> col_UserRating;
    @FXML
    private Button btn_add;
    @FXML
    private ComboBox<?> Categories;
    @FXML
    private ComboBox<?> Filter;
    @FXML
    private Button btn_editCategory;
    @FXML
    private Button btn_addCategory;
    @FXML
    private TableColumn<?, ?> col_MovieGenres;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    


    @FXML
    private void handle_EditMovie(ActionEvent event) {
    }

    @FXML
    private void handle_RemoveMovie(ActionEvent event) {
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
    private void handle_EditCategory(ActionEvent event) {
    }

    @FXML
    private void handle_addCategory(ActionEvent event) {
    }
    
}
