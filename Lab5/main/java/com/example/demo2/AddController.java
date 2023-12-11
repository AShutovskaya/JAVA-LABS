package com.example.demo2;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import java.io.FileWriter;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class AddController implements Initializable {

    @FXML
    private Button BtnAdd;

    @FXML
    private Button BtnDelete;

    @FXML
    private HBox HBox4Btns;

    @FXML
    private Label LblAddText;
    @FXML
    private Button BtnAnoth;

    @FXML
    private ListView<String> listBoxMain;

    @FXML
    private Label TitleLbl;

    @FXML
    private VBox VBoxMain;

    @FXML
    private TextField txtAddItem;
    @FXML
    private Button BtnBirth;

    @FXML
    private Button BtnChrist;
    @FXML
    private Button BtnWed;
    @FXML
    private Button Btnmenu;

    final ObservableList<String> listItems = FXCollections.observableArrayList("Wishes:");

    @FXML
    private void addAction(ActionEvent action){
        listItems.add(txtAddItem.getText());

    }

    @FXML
    private void deleteAction(ActionEvent action){
        int selectedItem = listBoxMain.getSelectionModel().getSelectedIndex();
        listItems.remove(selectedItem);
    }

    @FXML
    public void initialize(URL url, ResourceBundle rb) {
        listBoxMain.setItems(listItems);

        BtnDelete.setDisable(true);
        BtnAdd.setDisable(true);
        txtAddItem.focusedProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue) {
                BtnAdd.setDisable(false);
            }
        });

        listBoxMain.focusedProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue) {
                BtnDelete.setDisable(false);
            }
        });

        BtnBirth.setOnAction(event -> {
            try (FileWriter writer = new FileWriter("Birthday.txt")) {
                for (String line : listBoxMain.getItems()) {
                    writer.write(line + "\n");
                }
                FXMLLoader fxmlLoader = new FXMLLoader(StartApplication.class.getResource("hello-view(start).fxml"));
                Stage stage =  (Stage) BtnBirth.getScene().getWindow();
                Scene thirdScene = null;
                thirdScene = new Scene(fxmlLoader.load(), 900, 700);
                stage.setScene(thirdScene);
                stage.show();

            }
            catch (IOException e) {
                e.printStackTrace();
            }
        });

        BtnChrist.setOnAction(event -> {
            try (FileWriter writer = new FileWriter("Christmas.txt")) {
                for (String line : listBoxMain.getItems()) {
                    writer.write(line + "\n");
                }
                FXMLLoader fxmlLoader = new FXMLLoader(StartApplication.class.getResource("hello-view(start).fxml"));
                Stage stage =  (Stage) BtnChrist.getScene().getWindow();
                Scene thirdScene = null;
                thirdScene = new Scene(fxmlLoader.load(), 900, 700);
                stage.setScene(thirdScene);
                stage.show();
            }
            catch (IOException e) {
                e.printStackTrace();
            }
        });

        BtnWed.setOnAction(event -> {
            try (FileWriter writer = new FileWriter("Wedding.txt")) {
                for (String line : listBoxMain.getItems()) {
                    writer.write(line + "\n");
                }
                FXMLLoader fxmlLoader = new FXMLLoader(StartApplication.class.getResource("hello-view(start).fxml"));
                Stage stage =  (Stage) BtnWed.getScene().getWindow();
                Scene thirdScene = null;
                thirdScene = new Scene(fxmlLoader.load(), 900, 700);
                stage.setScene(thirdScene);
                stage.show();
            }
            catch (IOException e) {
                e.printStackTrace();
            }
        });

        BtnAnoth.setOnAction(event -> {
            try (FileWriter writer = new FileWriter("Another.txt")) {
                for (String line : listBoxMain.getItems()) {
                    writer.write(line + "\n");
                }
                FXMLLoader fxmlLoader = new FXMLLoader(StartApplication.class.getResource("hello-view(start).fxml"));
                Stage stage =  (Stage) BtnAnoth.getScene().getWindow();
                Scene thirdScene = null;
                thirdScene = new Scene(fxmlLoader.load(), 900, 700);
                stage.setScene(thirdScene);
                stage.show();
            }
            catch (IOException e) {
                e.printStackTrace();
            }
        });
        Btnmenu.setOnAction(event -> {
            FXMLLoader fxmlLoader = new FXMLLoader(StartApplication.class.getResource("hello-view(start).fxml"));
            Stage secondStage = (Stage) Btnmenu.getScene().getWindow();
            Scene thirdScene = null;
            try {
                thirdScene = new Scene(fxmlLoader.load(), 900, 700);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            secondStage.setScene(thirdScene);

            secondStage.show();

        });


    }
}
