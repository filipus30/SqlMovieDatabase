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
import javafx.scene.control.Label;
import javafx.stage.Stage;
import sqlmoviedatabase.bll.LogicManager;
import sqlmoviedatabase.model.MainModel;

/**
 * FXML Controller class
 *
 * @author Abdi
 */
public class DeleteCategorySceneController implements Initializable {

    @FXML
    private Button btn_confirmCategory;
    @FXML
    private Button btn_cancel;
    
    
    private PrimaryController pCon;
    @FXML
    private Label nameofcategory;
    private MainModel model;
    LogicManager lm = new LogicManager();
   public DeleteCategorySceneController(){
         model = MainModel.GetInstance(); 
   }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
      nameofcategory.setText(model.getCategory().getCatname());
    
    }    

    @FXML
    private void handle_confirmCategory(ActionEvent event) {
            System.out.println(model.getCategory().getCatname());
        lm.deleteCategory(model.getCategory().getCatname());
         Stage stage = (Stage) btn_confirmCategory.getScene().getWindow();
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
