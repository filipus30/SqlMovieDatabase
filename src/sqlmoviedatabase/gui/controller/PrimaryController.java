/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sqlmoviedatabase.gui.controller;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;

import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;
import sqlmoviedatabase.be.Movie;
import sqlmoviedatabase.bll.LogicManager;
import sqlmoviedatabase.dal.MovieDAO;
import sqlmoviedatabase.model.MovieModel;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import sqlmoviedatabase.be.Category;
import sqlmoviedatabase.be.Movie;
import sqlmoviedatabase.bll.LogicManager;
import sqlmoviedatabase.dal.MovieDAO;
import sqlmoviedatabase.model.CategoryModel;



/**
 * FXML Controller class
 *
 * @author Abdi
 */
public class PrimaryController implements Initializable {

    @FXML
    private Button btn_add;
    @FXML
    private Button btn_addCategory;
    @FXML
    private Button btn_deleteCategory;
    @FXML
    private TableColumn<?, ?> col_movieGenres;
    @FXML
    private TableColumn<?, ?> col_length;
    @FXML
    private TextField searchbar;
    @FXML
    private ComboBox<Category> categories;
    @FXML
    private ComboBox<Integer> filter;
    @FXML
    private TableColumn<Movie,String> col_lastViewed;
    @FXML
    private TableView<Movie> tbv_Library;
    @FXML
    private Button btn_edit;
    @FXML
    private Button btn_remove;
    @FXML
    private TableColumn<Movie,String> col_movieTitle;
    @FXML
    private TableColumn<Movie,String> col_IMDbRating;

    @FXML
    private TableColumn<Movie,String> col_userRating;
    @FXML
    private Button btn_editCategory;
    
    private Movie movie;
    private Category category;
    private MovieModel movieModel;
    private CategoryModel categoryModel;   
    LogicManager lm = new LogicManager();
    private MediaPlayer mediaPlayer;
    
    @FXML
    private Button btn_play;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        settingTableViews();
        filter.setItems(FXCollections.observableArrayList(
        1, 2, 3, 4, 5, 6, 7, 8, 9, 10));
        
    }
     private void settingTableViews() {
      movieModel = new MovieModel();
      categoryModel = new CategoryModel();
      
     ObservableList<Movie> movielist = FXCollections.observableArrayList(lm.getAllMovies());
     

     ObservableList<Category> categorylist = FXCollections.observableArrayList(lm.getAllCategories());

     col_movieTitle.setCellValueFactory(new PropertyValueFactory ("Title"));
     col_IMDbRating.setCellValueFactory(new PropertyValueFactory ("Imdb_Rating"));
     col_userRating.setCellValueFactory(new PropertyValueFactory ("Personal_Rating"));
     col_lastViewed.setCellValueFactory(new PropertyValueFactory ("LastView"));

     col_length.setCellValueFactory(new PropertyValueFactory<>("stringTime"));
     tbv_Library.setItems(movieModel.getmovielist());


     col_movieGenres.setCellValueFactory(new PropertyValueFactory ("Category"));

     tbv_Library.setItems(movielist);
     categories.setItems(categorylist);


    }    


    @FXML
    private void handle_addMovie(ActionEvent event) throws IOException {
        Parent root1;
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/sqlmoviedatabase/gui/MovieScene.fxml"));
        root1 = (Parent) fxmlLoader.load();
        fxmlLoader.<MovieSceneController>getController().setContr(this);

        Stage movieStage = new Stage();
        Scene movieScene = new Scene(root1);

        //categoryStage.initStyle(StageStyle.UNDECORATED);
        movieStage.setScene(movieScene);
        movieStage.show();
    }
    
    @FXML
    private void handle_getMovie(MouseEvent event) {
       movie = tbv_Library.getSelectionModel().getSelectedItem();

    }

    @FXML
    private void handle_editMovie(ActionEvent event) throws IOException {
        Movie selectedMovie = tbv_Library.getSelectionModel().getSelectedItem();

        Parent root;
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/sqlmoviedatabase/gui/MovieScene.fxml"));
        root = (Parent) fxmlLoader.load();
        MovieSceneController controller = (MovieSceneController) fxmlLoader.getController();
        controller.setContr(this);
        controller.editMode(selectedMovie);
        Stage movieStage = new Stage();
        Scene movieScene = new Scene(root);

        //movieStage.initStyle(StageStyle.UNDECORATED);
        movieStage.setScene(movieScene);
        movieStage.show();
    }
    @FXML
    private void handle_removeMovie(ActionEvent event) throws IOException {
        Movie selectedMovie = tbv_Library.getSelectionModel().getSelectedItem();
        
        Parent root;
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/sqlmoviedatabase/gui/DeleteMovieScene.fxml"));
        root = (Parent) fxmlLoader.load();
        DeleteMovieSceneController controller = (DeleteMovieSceneController) fxmlLoader.getController();
        controller.setContr(this);

        Stage movieStage = new Stage();
        Scene movieScene = new Scene(root);

        //MovieStage.initStyle(StageStyle.UNDECORATED);
        movieStage.setScene(movieScene);
        movieStage.show();
    }
    
    
    public void refreshLibrary() {
         tbv_Library.getItems().clear();
         tbv_Library.setItems(movieModel.getmovielist());
    }
    @FXML
    private void handle_editCategory(ActionEvent event) throws IOException {
        Category selectedCategory = categories.getSelectionModel().getSelectedItem();

        Parent root;
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/sqlmoviedatabase/gui/CategoryScene.fxml"));
        root = (Parent) fxmlLoader.load();
        CategorySceneController controller = (CategorySceneController) fxmlLoader.getController();
        controller.setContr(this);
        controller.editMode(selectedCategory);
        Stage categoryStage = new Stage();
        Scene categoryScene = new Scene(root);

        //movieStage.initStyle(StageStyle.UNDECORATED);
        categoryStage.setScene(categoryScene);
        categoryStage.show();
    }
    
    @FXML
    private void handle_addCategory(ActionEvent event) throws IOException {
        
        Parent root1;
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/sqlmoviedatabase/gui/CategoryScene.fxml"));
        root1 = (Parent) fxmlLoader.load();
        fxmlLoader.<CategorySceneController>getController().setContr(this);

        Stage categoryStage = new Stage();
        Scene categoryScene = new Scene(root1);

        //categoryStage.initStyle(StageStyle.UNDECORATED);
        categoryStage.setScene(categoryScene);
        categoryStage.show();
    }

    @FXML
    private void handle_deleteCategory(ActionEvent event) throws IOException {

        Parent root;
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/sqlmoviedatabase/gui/DeleteCategoryScene.fxml"));
        root = (Parent) fxmlLoader.load();
        DeleteCategorySceneController controller = (DeleteCategorySceneController) fxmlLoader.getController();
        controller.setContr(this);

        Stage categoryStage = new Stage();
        Scene categoryScene = new Scene(root);

        //MovieStage.initStyle(StageStyle.UNDECORATED);
        categoryStage.setScene(categoryScene);
        categoryStage.show();
    }
        
        public void refreshCategories() {
        categories.getItems().clear();
        categories.setItems(categoryModel.getcategorylist());
    }

    
    @FXML
    private void handle_Search(ActionEvent event) {
       List<Movie> movielist = FXCollections.observableArrayList(lm.getAllMovies());
       
       tbv_Library.setItems((ObservableList<Movie>) lm.search(movielist,searchbar.getText(),categories.getSelectionModel().getSelectedItem().getCatname()));
    }
    
    @FXML
    private void handle_Categories(ActionEvent event) {
        List<Movie> movielist = FXCollections.observableArrayList(lm.getAllMovies());
       tbv_Library.setItems((ObservableList<Movie>) lm.searchcat(movielist,categories.getSelectionModel().getSelectedItem().getCatname()));
    }

    @FXML
    private void handle_playMovie(ActionEvent event) throws IOException {
        
        Desktop.getDesktop().open(new File("C:\\Users\\PC\\Pictures\\beat.mp4"));
   }

    @FXML
    private void handle_Filter(ActionEvent event) {
    }


}