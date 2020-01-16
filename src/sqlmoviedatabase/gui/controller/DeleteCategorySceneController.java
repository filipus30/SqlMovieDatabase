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
import sqlmoviedatabase.be.Category;
import sqlmoviedatabase.model.CategoryModel;

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
    
    private CategoryModel categoryModel;
    private Category selectedCategory;
    private PrimaryController pCon;
    @FXML
    private Label lbl_title;
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        categoryModel = new CategoryModel();
    }    

    @FXML
    private void handle_confirmCategory(ActionEvent event) {
        categoryModel.deleteCategory(selectedCategory);

        refreshCategories();
        Stage stage;
        stage = (Stage) btn_confirmCategory.getScene().getWindow();
        stage.close();
    }

    @FXML
    private void handle_closeScene(ActionEvent event) {     
       Stage stage = (Stage) btn_cancel.getScene().getWindow();
       stage.close();
    }
    
    public void setDeleteCategoryLabel(Category category) {
        selectedCategory = category;
        lbl_title.setText(selectedCategory.getName());
    }
    
    private void refreshCategories() {
        pCon.refreshCategories();
    }
        public void setContr(PrimaryController pCon) {
        this.pCon = pCon;
    }
    
}
