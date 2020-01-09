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
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author Abdi
 */
public class MovieSceneController implements Initializable {

    @FXML
    private TextField txtField_title;
    @FXML
    private TextField txtField_time;
    @FXML
    private TextField txtField_filePath;
    @FXML
    private Button btn_cancel;
    @FXML
    private TextField txtField_genre;
    @FXML
    private ComboBox<?> choose_categories;
    @FXML
    private ComboBox<?> cb_rating;
    @FXML
    private Button btn_createVisible;
    @FXML
    private Button btn_deleteGenre;
    @FXML
    private Button btn_choosefile;
    @FXML
    private Button btn_save;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void handle_createVisible(ActionEvent event) {
    }

    @FXML
    private void handle_deleteGenre(ActionEvent event) {
    }

    @FXML
    private void handle_openFileChooser(ActionEvent event) {
    }

    @FXML
    private void handle_saveSong(ActionEvent event) {
    }

    @FXML
    private void handle_cancelScene(ActionEvent event) {
    }
    
}
