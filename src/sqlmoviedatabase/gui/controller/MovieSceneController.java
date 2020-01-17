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
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.Region;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.util.Duration;
import sqlmoviedatabase.be.Category;
import sqlmoviedatabase.be.Movie;
import sqlmoviedatabase.bll.LogicManager;
import sqlmoviedatabase.dal.MovieDAO;
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
    private Button btn_choosefile;
    @FXML
    private Button btn_save;
    private ChoiceBox<String> choiceBox_genre;
    
    private boolean edit;
    private Movie movieToEdit;
    private MovieModel movieModel;
    private GenreModel genreModel;
    private CategoryModel categoryModel;
    private PrimaryController pCon;
    private MovieSceneController conMovie;
    
     
    @FXML
    private ChoiceBox<Category> choiceBox_category;
    @FXML
    private ComboBox<Integer> choiceBox_imdbrating;
    @FXML
    private ComboBox<Integer> choiceBox_myrating;
    private LogicManager lm = new LogicManager();
    private int id = lm.getNewMovId();
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
         ObservableList<Category> categorylist = FXCollections.observableArrayList(lm.getAllCategories());
        choiceBox_category.setItems(categorylist);
        choiceBox_myrating.setItems(FXCollections.observableArrayList( 1, 2, 3, 4, 5, 6, 7, 8, 9, 10));
        choiceBox_imdbrating.setItems(FXCollections.observableArrayList( 1, 2, 3, 4, 5, 6, 7, 8, 9, 10));
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
       
        if(lm.checkMovieTitle(lm.getAllMovies(),txtField_title.getText()) == false)
        {lm.createMovie(id,txtField_title.getText(),choiceBox_myrating.getValue(),choiceBox_imdbrating.getValue(),"never",txtField_filePath.getText(),choiceBox_category.getSelectionModel().getSelectedItem().getCatname(),txtField_time.getText());}
        else
        {
            
            Alert alert = new Alert(Alert.AlertType.INFORMATION, "Movie With Given Title Already Exist !", ButtonType.OK);
        alert.getDialogPane().setMinHeight(Region.USE_PREF_SIZE);
        alert.show();
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
    
    
   
     
    public void setContr(PrimaryController pCon) {
        this.pCon = pCon;
    }

    
   


   


}
