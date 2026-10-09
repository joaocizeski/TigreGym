package com.example.back;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class AdminApplication extends Application {

    @Override
    public void start(Stage stage) throws IOException {

        FXMLLoader fxmlLoader = new FXMLLoader(
                AdminApplication.class.getResource("/com/example/back/hello-view.fxml")
        );

        Scene scene = new Scene(fxmlLoader.load(), 320, 240);

        stage.setTitle("Admin TigreGym!");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}