package com.example.socialmedia;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Locale;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        Parent root = FXMLDependencyInjector.load("main-view.fxml", Locale.ENGLISH);
        Scene scene = new Scene(root, 920, 640);
        //IConfigManager configManager = new ConfigManager();
        //String iconPath = configManager.getIconPath();
        //Image icon = new Image(new FileInputStream(iconPath));
        //stage.getIcons().add(icon);
        stage.setTitle("AsocialMedia");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}