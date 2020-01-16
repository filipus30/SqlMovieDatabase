/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sqlmoviedatabase.gui.controller;

import java.io.File;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.util.Duration;
import sqlmoviedatabase.be.Movie;
import sqlmoviedatabase.model.CategoryModel;
import sqlmoviedatabase.model.GenreModel;
import sqlmoviedatabase.model.MovieModel;

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
    private Button btn_deleteGenre;
    @FXML
    private Button btn_choosefile;
    @FXML
    private Button btn_save;
    @FXML
    private Button btn_createGenre;
    @FXML
    private Button btn_createVisible;
    @FXML
    private TextField txt_createGenre;
    @FXML
    private ChoiceBox<String> choiceBox_genre;
    
    private boolean edit;
    private Movie movieToEdit;
    private MovieModel movieModel;
    private GenreModel genreModel;
    private CategoryModel categoryModel;
    private PrimaryController pCon;
    private MovieSceneController conMovie;
    @FXML
    private ChoiceBox<?> choiceBox_category;
    @FXML
    private Button btn_createVisible1;
    @FXML
    private Button btn_deleteCategory;
    @FXML
    private TextField txt_createCategory;
    @FXML
    private Button btn_createCategory;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        
    }
    @FXML
    private void handle_createVisible(ActionEvent event) {
        txt_createGenre.setVisible(true);
        btn_createGenre.setVisible(true);
    }

    @FXML
    private void handle_deleteGenre(ActionEvent event) {
        String name = (String) choiceBox_genre.getSelectionModel().getSelectedItem();
        genreModel.deleteGenre(name);
        choiceBox_genre.getItems().remove(name);
    }

    @FXML
    private void handle_openFileChooser(ActionEvent event) {
        FileChooser fileChooser = new FileChooser();
        fileChooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("mp4 Files", "*.mp4"),
                new FileChooser.ExtensionFilter("mpeg4 Files", "*.mpeg4")
        );

        File movieFile = fileChooser.showOpenDialog(null);
        if (movieFile != null) {
            String moviePATH = movieFile.getAbsolutePath();
            txtField_filePath.setText(moviePATH);
            Media media = new Media(movieFile.toURI().toString());
            MediaPlayer mediaPlayer = new MediaPlayer(media);
            mediaPlayer.setOnReady(new Runnable() {

                @Override
                public void run() {
                    int time, hours, mins, secs;
                    Duration timeDuration = media.getDuration();
                    time = (int) (timeDuration.toSeconds());// it will cut .898956
                    //String stringTime = String.format("%02d:%02d:%02d", hours, mins, secs);
                    
                    txtField_time.setText(movieModel.sec_To_Format(time));
                }
            });
        }
    }
    
    
    @FXML
    private void handle_saveMovie(ActionEvent event) {
        if (!edit) {
            movieModel.createMovie(txtField_title.getText().trim(),
             movieModel.format_To_Sec(txtField_time.getText()),
             choiceBox_genre.getSelectionModel().getSelectedItem(),
              txtField_filePath.getText());
        } else {
            movieModel.updateMovie(movieToEdit,
            txtField_title.getText().trim(),
            choiceBox_genre.getSelectionModel().getSelectedItem(),
            movieModel.format_To_Sec(txtField_time.getText()),
            txtField_filePath.getText());
        }



        Stage stage;
        stage = (Stage) btn_save.getScene().getWindow();
        stage.close();
    }
    
        public void editMode(Movie selectedMovie) {
        edit = true;
        movieToEdit = selectedMovie;

        //sets the existing info of the selected song.
        txtField_title.setText(movieToEdit.getTitle());
        txtField_time.setText(movieToEdit.getDuration());
        txtField_filePath.setText(movieToEdit.getFileLocation());
        choiceBox_genre.setValue(movieToEdit.getCategory());
    }

    @FXML
    private void handle_closeScene(ActionEvent event) {
        Stage stage = (Stage) btn_cancel.getScene().getWindow();
        stage.close();
    }
    
    @FXML
    private void handle_createGenre(ActionEvent event) {

        String name = txt_createGenre.getText().trim();
        genreModel.createGenre(name);
        choiceBox_genre.getItems().add(name);
        txt_createGenre.setVisible(false); //makes the button invisible.
        btn_createGenre.setVisible(false); //makes the button invisible.
    }
    
        
    public void setContr(PrimaryController pCon) {
        this.pCon = pCon;
    }

    @FXML
    private void handle_createVisible1(ActionEvent event) {
        txt_createCategory.setVisible(true);
        btn_createCategory.setVisible(true);
    }

    @FXML
    private void handle_deleteCategory(ActionEvent event) {
        String name = (String) choiceBox_category.getSelectionModel().getSelectedItem();
        categoryModel.deleteCategory(name);
        choiceBox_category.getItems().remove(name);
    }

    @FXML
    private void handle_createCategory(ActionEvent event) {
        String name = txt_createCategory.getText().trim();
        categoryModel.createCategory(name);
        //choiceBox_category.getItems().add(name);
        txt_createCategory.setVisible(false); //makes the button invisible.
        btn_createCategory.setVisible(false); //makes the button invisible.
    }


}
