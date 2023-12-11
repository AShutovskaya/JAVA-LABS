package com.example.demo2;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import javafx.scene.image.ImageView;

public class StartController {
    @FXML
    private ImageView c1;

    @FXML
    private ImageView c2;

    @FXML
    private ImageView c3;

    @FXML
    private ImageView c4;

    @FXML
    private ImageView c5;


    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button startaddbtn;

    @FXML
    private Button startopenbtn;

    @FXML
    void initialize() {
        startaddbtn.setOnAction(event->{
            FXMLLoader fxmlLoader = new FXMLLoader(StartApplication.class.getResource("Add.fxml"));
            Stage secondStage = (Stage) startaddbtn.getScene().getWindow();
            secondStage.setTitle("Add list");
            Scene secondScene = null;
            try {
                secondScene = new Scene(fxmlLoader.load(), 900, 700);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            secondStage.setScene(secondScene);

            secondStage.show();

        });
        startopenbtn.setOnAction(event->{
            FXMLLoader fxmlLoader = new FXMLLoader(StartApplication.class.getResource("Open-view.fxml"));
            Stage secondStage = (Stage) startopenbtn.getScene().getWindow();
            secondStage.setTitle("List");
            Scene secondScene = null;
            try {
                secondScene = new Scene(fxmlLoader.load(), 900, 700);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            secondStage.setScene(secondScene);

            secondStage.show();

        });
        Image image1 = new Image(getClass().getResourceAsStream("ee439ad17a6b7b8beeae492666c27345.jpg"));
        c1.setImage(image1);
        Image image2 = new Image(getClass().getResourceAsStream("38cccd5f318b39f0ccedefead2033294.jpg"));
        c2.setImage(image2);
        Image image3 = new Image(getClass().getResourceAsStream("0932541fd2e4a08e2c230ef1c024d37d.jpg"));
        c3.setImage(image3);
        Image image4 = new Image(getClass().getResourceAsStream("3a8f493746b70d1d079cc5a7b5ff4718.jpg"));
        c4.setImage(image4);
        Image image5 = new Image(getClass().getResourceAsStream("8656685988f3c86c6e54d9fda922e0e3.jpg"));
        c5.setImage(image5);
    }

}
