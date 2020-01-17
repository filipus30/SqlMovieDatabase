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
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;

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
import javafx.scene.layout.Region;
import sqlmoviedatabase.be.Category;
import sqlmoviedatabase.be.Movie;
import sqlmoviedatabase.bll.LogicManager;
import sqlmoviedatabase.dal.MovieDAO;
import sqlmoviedatabase.model.MainModel;



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
    private Button btn_remove;
    @FXML
    private TableColumn<Movie,String> col_movieTitle;
    @FXML
    private TableColumn<Movie,String> col_IMDbRating;

    @FXML
    private TableColumn<Movie,String> col_userRating;
    @FXML
    private Button btn_editCategory;
  
    LogicManager lm = new LogicManager();
    private MovieModel movieModel;
    private Movie movie;
    @FXML
    private Button btn_play;
    private MainModel model;
    private boolean searching = false;
    private boolean catselected = false;
    private boolean ratselected = false;
    private boolean textselected = false;
    private MediaPlayer mediaPlayer;
    @FXML
    private Button button_search;
    @FXML
    private Button ratebutton;
    @FXML
    private ComboBox<Integer> ratebox;
    public PrimaryController()
    {
         model = MainModel.GetInstance(); 
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        settingTableViews();
        filter.setItems(FXCollections.observableArrayList(
        1, 2, 3, 4, 5, 6, 7, 8, 9, 10));
        ratebox.setItems(FXCollections.observableArrayList(
        1, 2, 3, 4, 5, 6, 7, 8, 9, 10));
        Alert alert = new Alert(AlertType.INFORMATION, "Remember to delete movies if they are rated 6 and below and if has not been opened in more 2 years", ButtonType.OK);
        alert.getDialogPane().setMinHeight(Region.USE_PREF_SIZE);
        alert.show();
        
    }
     private void settingTableViews() {
      movieModel = new MovieModel();
      
     ObservableList<Movie> movielist = FXCollections.observableArrayList(lm.getAllMovies());
     

     ObservableList<Category> categorylist = FXCollections.observableArrayList(lm.getAllCategories());

     col_movieTitle.setCellValueFactory(new PropertyValueFactory ("Title"));
     col_IMDbRating.setCellValueFactory(new PropertyValueFactory ("Imdb_Rating"));
     col_userRating.setCellValueFactory(new PropertyValueFactory ("Personal_Rating"));
     col_lastViewed.setCellValueFactory(new PropertyValueFactory ("LastView"));

     col_length.setCellValueFactory(new PropertyValueFactory<>("Duration"));
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

        Stage songStage = new Stage();
        Scene songScene = new Scene(root1);

        //songStage.initStyle(StageStyle.UNDECORATED);
        songStage.setScene(songScene);
        songStage.show();
    }

    private void handle_editMovie(ActionEvent event) throws IOException {
        Movie selectedMovie = tbv_Library.getSelectionModel().getSelectedItem();

        Parent root;
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/sqlmoviedatabase/gui/MovieScene.fxml"));
        root = (Parent) fxmlLoader.load();
        MovieSceneController controller = (MovieSceneController) fxmlLoader.getController();
        controller.setContr(this);

        Stage movieStage = new Stage();
        Scene movieScene = new Scene(root);

        //movieStage.initStyle(StageStyle.UNDECORATED);
        movieStage.setScene(movieScene);
        movieStage.show();
    }
    @FXML
    private void handle_removeMovie(ActionEvent event) throws IOException {
       lm.deleteMovie(tbv_Library.getSelectionModel().getSelectedItem());
    }
    @FXML
    private void handle_editCategory(ActionEvent event) throws IOException {
         model.setEditingTrue();
         model.setCategory(categories.getSelectionModel().getSelectedItem());
        Parent root;
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/sqlmoviedatabase/gui/CategoryScene.fxml"));
        root = (Parent) fxmlLoader.load();
        CategorySceneController controller = (CategorySceneController) fxmlLoader.getController();
        controller.setContr(this);

        Stage movieStage = new Stage();
        Scene movieScene = new Scene(root);

        //movieStage.initStyle(StageStyle.UNDECORATED);
        movieStage.setScene(movieScene);
        movieStage.show();
    }
    
    @FXML
    private void handle_addCategory(ActionEvent event) throws IOException {
        
        Parent root1;
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/sqlmoviedatabase/gui/CategoryScene.fxml"));
        root1 = (Parent) fxmlLoader.load();
        fxmlLoader.<CategorySceneController>getController().setContr(this);

        Stage songStage = new Stage();
        Scene songScene = new Scene(root1);

        //songStage.initStyle(StageStyle.UNDECORATED);
        songStage.setScene(songScene);
        songStage.show();
    }

    @FXML
    private void handle_deleteCategory(ActionEvent event) throws IOException {
        model.setCategory(categories.getSelectionModel().getSelectedItem());
        Parent root;
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/sqlmoviedatabase/gui/DeleteCategoryScene.fxml"));
        root = (Parent) fxmlLoader.load();
        DeleteCategorySceneController controller = (DeleteCategorySceneController) fxmlLoader.getController();
        controller.setContr(this);

        Stage movieStage = new Stage();
        Scene movieScene = new Scene(root);

        //MovieStage.initStyle(StageStyle.UNDECORATED);
        movieStage.setScene(movieScene);
        movieStage.show();
    }
        

  

    @FXML
    private void handle_playMovie(ActionEvent event) throws IOException {
        
        Desktop.getDesktop().open(new File(tbv_Library.getSelectionModel().getSelectedItem().getFileLocation()));
   }

   

    @FXML
    private void handle_search(ActionEvent event) {
       ObservableList<Movie> movielist = FXCollections.observableArrayList(lm.getAllMovies());
        if (searching==false)
        { button_search.setText("reset");
        if(textselected == false && catselected ==false && ratselected == false)
                System.out.println("bad");
        tbv_Library.setItems(movielist);
       if(catselected)
       model.setMovieList(lm.searchcat(lm.getAllMovies(),categories.getSelectionModel().getSelectedItem().getCatname()));
       if(ratselected)
       model.setMovieList(lm.searchrat(model.getMovieList(),filter.getValue()));
       if(textselected)
       model.setMovieList(lm.search(model.getMovieList(),searchbar.getText()));   
       tbv_Library.setItems((ObservableList<Movie>) model.getMovieList()); 
       searching = true; 
        searchbar.setDisable(true);}
        else
        {
            //reset
            searchbar.clear();
            filter.setValue(null);
            categories.setValue(null);
            searching = false;
            textselected =false;
            catselected = false;
            ratselected = false;
            button_search.setText("Search!");
            searching = false;
            model.setMovieList(lm.getAllMovies());
            searchbar.setDisable(false);
            tbv_Library.setItems(movielist);
        }
    }

    @FXML
    private void handle_textsearch(ActionEvent event) {
        textselected = true;
    }

    @FXML
    private void handle_filter(ActionEvent event) {
        ratselected = true;
    }

    @FXML
    private void handle_categories(ActionEvent event) {
        catselected = true;
    }

    @FXML
    private void handle_textsearch(KeyEvent event) {
    
        textselected = true;}

    @FXML
    private void rate(ActionEvent event) {
    lm.UpdateMovie(tbv_Library.getSelectionModel().getSelectedItem(),tbv_Library.getSelectionModel().getSelectedItem().getTitle(),ratebox.getValue(),tbv_Library.getSelectionModel().getSelectedItem().getImdb_Rating(),tbv_Library.getSelectionModel().getSelectedItem().getLastView(),tbv_Library.getSelectionModel().getSelectedItem().getFileLocation(),tbv_Library.getSelectionModel().getSelectedItem().getDuration(),tbv_Library.getSelectionModel().getSelectedItem().getCategory());
    }
    }

  
