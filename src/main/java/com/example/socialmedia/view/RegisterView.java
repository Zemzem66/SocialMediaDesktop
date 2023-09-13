package com.example.socialmedia.view;

import com.example.socialmedia.viewmodel.RegisterViewModel;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class RegisterView {

    @FXML
    private Button createUserButton;

    @FXML
    private Label output;

    @FXML
    private Button rCancelButton;

    @FXML
    private TextField rUsernameField;

    @FXML
    private TextField rEmailField;

    @FXML
    private PasswordField rPasswordField;

    @FXML
    private BorderPane createUserWindow;

    private final RegisterViewModel registerViewModel;

    public RegisterView(RegisterViewModel registerViewModel) {
        this.registerViewModel = registerViewModel;
    }

    @FXML
    void initialize()
    {
        createUserButton.setDisable(true);

        rUsernameField.textProperty().bindBidirectional(registerViewModel.userNamePropertyProperty());

        rEmailField.textProperty().bindBidirectional(registerViewModel.emailPropertyProperty());

        rPasswordField.textProperty().bindBidirectional(registerViewModel.passwordPropertyProperty());

        output.textProperty().bindBidirectional(registerViewModel.outputProperty());

        createUserButton.disableProperty().bind(rUsernameField.textProperty().isEmpty().or(rEmailField.textProperty().isEmpty().or(rPasswordField.textProperty().isEmpty())));

        rCancelButton.setOnAction(actionEvent -> { Stage stage = (Stage) rCancelButton.getScene().getWindow(); stage.close();});
    }

    @FXML
    private void createUser()
    {
        registerViewModel.createUser();
        output.setText(registerViewModel.getOutput());
        Scene scene = createUserWindow.getScene();
        Stage stage = (Stage) scene.getWindow();
        stage.close();
        output.setText("");
    }

}
