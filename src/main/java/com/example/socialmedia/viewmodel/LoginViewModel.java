package com.example.socialmedia.viewmodel;

import com.example.socialmedia.FXMLDependencyInjector;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Locale;

public class LoginViewModel {
    public void openNewRegisterDialog() {
            try {
                Parent root = FXMLDependencyInjector.load("register-view.fxml", Locale.ENGLISH);
                Scene scene = new Scene(root, 620, 340);
                Stage stage = new Stage();
                /*
                String iconPath = configManager.getIconPath();
                Image icon = new Image(new FileInputStream(iconPath));
                stage.getIcons().add(icon);
                 */
                stage.setTitle("Create New Tour");
                stage.setScene(scene);
                stage.show();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
    }
}