package com.example.codelab6;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class HelloApplication extends Application {

    @Override
    public void start(Stage primaryStage) {
        GridPane loginForm = new GridPane();
        loginForm.setAlignment(Pos.CENTER);
        loginForm.setHgap(10);
        loginForm.setVgap(10);

        Label titleLabel = new Label("Halaman Login");
        titleLabel.setFont(Font.font("Algerian", FontWeight.BOLD, 24));
        loginForm.add(titleLabel, 0, 0, 2, 1);

        Label usernameLabel = new Label("User Name:");
        loginForm.add(usernameLabel, 0, 1);
        TextField usernameField = new TextField();
        loginForm.add(usernameField, 1, 1);

        Label passwordLabel = new Label("Password:");
        loginForm.add(passwordLabel, 0, 2);
        PasswordField passwordField = new PasswordField();
        loginForm.add(passwordField, 1, 2);

        Button loginButton = new Button("Sign in");
        HBox hbBtn = new HBox(10);
        hbBtn.setAlignment(Pos.BOTTOM_RIGHT);
        hbBtn.getChildren().add(loginButton);
        loginForm.add(hbBtn, 1, 4);

        Label errorMessage = new Label("");
        errorMessage.setTextFill(Color.RED);
        loginForm.add(errorMessage, 1, 3);
        loginButton.setOnAction(event -> {
            String username = usernameField.getText();
            String password = passwordField.getText();

                if (username.equals("erwin") && password.equals("370")) {
                    Stage mainStage = new Stage();
                    VBox mainPage = new VBox(10);
                    Label welcomeLabel = new Label("Wokeh masok");
                    Button backButton = new Button("Kembali");
                    backButton.setOnAction(e -> mainStage.close());
                    mainPage.getChildren().addAll(welcomeLabel, backButton);
                    Scene mainScene = new Scene(mainPage, 300, 150);
                    mainStage.setScene(mainScene);
                    mainStage.show();

                    primaryStage.close();
                } else {
                    errorMessage.setText("Password Atau Username Salah");
                }
            });

            Scene scene = new Scene(loginForm, 300, 250);
            primaryStage.setTitle("Login Application");
            primaryStage.setScene(scene);
            primaryStage.show();
        }

        public static void main(String[] args) {
            launch(args);
        }
    }