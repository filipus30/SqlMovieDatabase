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
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Abdi
 */
public class DeleteMovieSceneController implements Initializable {

    @FXML
    private Button btn_confirmMovie;
    @FXML
    private Button btn_cancel;
    
    
    
    private PrimaryController pCon;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void handle_confirmMovie(ActionEvent event) {
        Stage stage;
        stage = (Stage) btn_confirmMovie.getScene().getWindow();
        stage.close();
        
    }

    @FXML
    private void handle_closeScene(ActionEvent event) {
        Stage stage = (Stage) btn_cancel.getScene().getWindow();
        stage.close();
    }
    
        public void setContr(PrimaryController pCon) {
        this.pCon = pCon;
    }
    
}
