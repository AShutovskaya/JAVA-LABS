package com.example.demo2;

import java.io.*;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.scene.control.Button;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.io.IOException;

public class OpenController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextArea TextArea;
    @FXML
    private Button WedOpen;
    @FXML
    private Button AnothOpen;

    @FXML
    private Button BirthOpen;
    @FXML
    private Button BtnMenu;

    @FXML
    private Button ChristmasOpen;

    @FXML
    void initialize() {
        BirthOpen.setOnAction(event -> {
            try (BufferedReader reader = new BufferedReader(new FileReader("Birthday.txt"))) {
                StringBuilder text = new StringBuilder();
                String line;
                while ((line = reader.readLine()) != null) {
                    text.append(line).append(System.lineSeparator());
                }
                TextArea.setText(text.toString());
                TextArea.setFont(Font.font("Freestyle Script", 35));
                TextArea.setStyle("-fx-text-fill: maroon;");


            } catch (IOException e) {
                e.printStackTrace();
            }
        });

        ChristmasOpen.setOnAction(event -> {
            try (BufferedReader reader = new BufferedReader(new FileReader("Christmas.txt"))) {
                StringBuilder text = new StringBuilder();
                String line;
                while ((line = reader.readLine()) != null) {
                    text.append(line).append(System.lineSeparator());
                }
                TextArea.setText(text.toString());
                TextArea.setFont(Font.font("Freestyle Script", 35));
                TextArea.setStyle("-fx-text-fill: maroon;");


            } catch (IOException e) {
                e.printStackTrace();
            }
        });

        WedOpen.setOnAction(event -> {
            try (BufferedReader reader = new BufferedReader(new FileReader("Wedding.txt"))) {
                StringBuilder text = new StringBuilder();
                String line;
                while ((line = reader.readLine()) != null) {
                    text.append(line).append(System.lineSeparator());
                }
                TextArea.setText(text.toString());
                TextArea.setFont(Font.font("Freestyle Script", 35));
                TextArea.setStyle("-fx-text-fill: maroon;");


            } catch (IOException e) {
                e.printStackTrace();
            }
        });

        AnothOpen.setOnAction(event -> {
            try (BufferedReader reader = new BufferedReader(new FileReader("Another.txt"))) {
                StringBuilder text = new StringBuilder();
                String line;
                while ((line = reader.readLine()) != null) {
                    text.append(line).append(System.lineSeparator());
                }
                TextArea.setText(text.toString());
                TextArea.setFont(Font.font("Freestyle Script", 35));
                TextArea.setStyle("-fx-text-fill: maroon;");


            } catch (IOException e) {
                e.printStackTrace();
            }
        });

        BtnMenu.setOnAction(event -> {
            FXMLLoader fxmlLoader = new FXMLLoader(StartApplication.class.getResource("hello-view(start).fxml"));
            Stage secondStage = (Stage) BtnMenu.getScene().getWindow();
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
    }
}