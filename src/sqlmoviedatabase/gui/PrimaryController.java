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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author PC
 */
public class PrimaryController implements Initializable {

    @FXML
    private TableView<?> tbv_Library;
    @FXML
    private TableColumn<?, ?> col_MovieLibrary;
    @FXML
    private TableColumn<?, ?> col_IMDbRating;
    @FXML
    private TextField SearchBar;
    @FXML
    private Button btn_play;
    @FXML
    private Button btn_edit;
    @FXML
    private Button btn_remove;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void handle_Playing(ActionEvent event) {
    }

    @FXML
    private void handle_EditMovie(ActionEvent event) {
    }

    @FXML
    private void handle_RemoveMovie(ActionEvent event) {
    }
    
}
