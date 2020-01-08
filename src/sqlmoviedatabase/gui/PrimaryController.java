/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sqlmoviedatabase.gui;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

/**
 *
 * @author filip
 */
public class PrimaryController implements Initializable {
    
    @FXML
    private Button moveMovies;
    @FXML
    private Button btn_addCategory;
    @FXML
    private Button btn_editCategory;
    @FXML
    private Button btn_deleteCategory;
    @FXML
    private Button btn_removeMoveInCategory;
    @FXML
    private Button btn_addMovie;
    @FXML
    private Button btn_editMovie;
    @FXML
    private Button btn_deleteMovie;
    @FXML
    private Button btn_clear;
    @FXML
    private Button btn_play;
    @FXML
    private Button btn_rateMovie;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void handle_MoveMovies(ActionEvent event) {
    }

    @FXML
    private void handle_addCategory(ActionEvent event) {
    }

    @FXML
    private void handle_editCategory(ActionEvent event) {
    }

    @FXML
    private void handle_deleteCategory(ActionEvent event) {
    }

    @FXML
    private void handle_removeMoveInCategory(ActionEvent event) {
    }

    @FXML
    private void handle_addMovie(ActionEvent event) {
    }

    @FXML
    private void handle_editMovie(ActionEvent event) {
    }

    @FXML
    private void handle_deleteMovie(ActionEvent event) {
    }

    @FXML
    private void handle_editMovieInCategory(ActionEvent event) {
    }

    @FXML
    private void handle_Clearing(ActionEvent event) {
    }

    @FXML
    private void handle_Playing(ActionEvent event) {
    }

    @FXML
    private void handle_Rating(ActionEvent event) {
    }
    
}
