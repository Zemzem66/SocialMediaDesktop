package com.example.socialmedia.view;

import com.example.socialmedia.viewmodel.LoginViewModel;
import javafx.fxml.FXML;

public class LoginView {

    private final LoginViewModel loginViewModel;

    public LoginView(LoginViewModel loginViewModel) {
        this.loginViewModel = loginViewModel;
    }

    @FXML
    void initialize() {

    }
    @FXML
    public void openRegisterDialog() {
        loginViewModel.openNewRegisterDialog();
    }

}
