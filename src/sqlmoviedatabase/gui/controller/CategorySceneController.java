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
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import sqlmoviedatabase.bll.LogicManager;
import sqlmoviedatabase.model.MainModel;

/**
 * FXML Controller class
 *
 * @author Abdi
 */
public class CategorySceneController implements Initializable {

    @FXML
    private TextField txtField_Category;
    @FXML
    private Button btn_cancel;
    @FXML
    private Button btn_save;
    private MainModel model;
    public CategorySceneController()
    {
           model = MainModel.GetInstance(); 
    }
    LogicManager lm = new LogicManager();
    private PrimaryController pCon;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void handle_saveCategory(ActionEvent event) {
         if(model.getEditing())
         {
         lm.editCategory(model.getCategory().getCatname(),txtField_Category.getText());
         model.setEditingFalse();
         }
          else{
                   lm.createCategory(txtField_Category.getText());
              }
        Stage stage;
        stage = (Stage) btn_save.getScene().getWindow();
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
