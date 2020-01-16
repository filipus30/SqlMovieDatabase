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
import sqlmoviedatabase.be.Category;
import sqlmoviedatabase.model.CategoryModel;

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
    
    private boolean edit;
    private Category categoryToEdit;
    private CategoryModel categoryModel;
    private PrimaryController pCon;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        edit = false;
        categoryModel = new CategoryModel();
    }
    

    @FXML
    private void handle_saveCategory(ActionEvent event) {
        if (!edit) {
            String name = txtField_Category.getText().trim();
            categoryModel.createCategory(name);
        } else {
            categoryModel.updateCategory(categoryToEdit, txtField_Category.getText());
        }

        updateCategories();

        Stage stage;
        stage = (Stage) btn_save.getScene().getWindow();
        stage.close();
    }

    @FXML
    private void handle_closeScene(ActionEvent event) {
        Stage stage = (Stage) btn_cancel.getScene().getWindow();
        stage.close();
        
    }
        public void editMode(Category selectedCategory) {
        edit = true;
        categoryToEdit = selectedCategory;

        //sets the existing info of the selected playlist.
        txtField_Category.setText(categoryToEdit.getName());
    }

        private void updateCategories() {
        pCon.refreshCategories();
    }
    
        public void setContr(PrimaryController pCon) {
        this.pCon = pCon;
    }
}
