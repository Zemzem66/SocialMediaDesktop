package com.example.socialmedia.viewmodel;

import com.example.socialmedia.event.EventAggregator;
import com.example.socialmedia.log.ILogger;
import com.example.socialmedia.log.LoggerFactory;
import com.example.socialmedia.model.User;
import com.example.socialmedia.service.RegisterService;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class RegisterViewModel {
  //  private final BooleanProperty createUsers = new SimpleBooleanProperty(true);
    private final StringProperty userNameProperty = new SimpleStringProperty("");
    private final StringProperty emailProperty = new SimpleStringProperty("");

    private final StringProperty passwordProperty = new SimpleStringProperty("");

    private final StringProperty output =  new SimpleStringProperty("");

    private final EventAggregator eventAggregator;
    private final RegisterService registerService;
    private final ILogger logger = LoggerFactory.createLogger(RegisterViewModel.class);

    public RegisterViewModel(EventAggregator eventAggregator, RegisterService registerService) {
        this.eventAggregator = eventAggregator;
        this.registerService = registerService;
    }

    public String getOutput() {
        return output.get();
    }

    public StringProperty outputProperty() {
        return output;
    }

    public void setOutput(String output) {
        this.output.set(output);
    }

    public String getUserNameProperty() {
        return userNameProperty.get();
    }

    public StringProperty userNamePropertyProperty() {
        return userNameProperty;
    }
    public void setUserNameProperty(String userNameProperty) {
        this.userNameProperty.set(userNameProperty);
    }

    public String getEmailProperty() {
        return emailProperty.get();
    }

    public StringProperty emailPropertyProperty() {
        return emailProperty;
    }

    public void setEmailProperty(String emailProperty) {
        this.emailProperty.set(emailProperty);
    }

    public String getPasswordProperty() {
        return passwordProperty.get();
    }

    public StringProperty passwordPropertyProperty() {
        return passwordProperty;
    }

    public void setPasswordProperty(String passwordProperty) {
        this.passwordProperty.set(passwordProperty);
    }

    //    public void createsUser

    public boolean validInput()
    {
        String email = emailProperty.get().trim();
        String emailRegex = "^[A-Za-z0-9+_.-]+@([A-Za-z0-9.-]+)\\.[A-Za-z]{2,4}$";
        if (!email.matches(emailRegex)) {
            output.set("Invalid email format.");
            logger.info("Invalid email format.");
            return false;
        }
        return true;
    }



    public void createUser()
    {
        if(!validInput())
        {
            return;
        }
        String username = transformString(userNameProperty.get());
        String email = transformString(emailProperty.get());
        String password = transformString(passwordProperty.get());

        String information = "User: "+ username +
                " email: " +email +
                 " password :"+password+ " " ;


        User user = new User(username,email,password);
        registerService.save(user);
        output.set(information);
        userNameProperty.set("");
        emailProperty.set("");
        passwordProperty.set("");

    }

    private static String transformString(String input) {
        String lowercaseInput = input.toLowerCase();
        String firstLetterCapitalized = lowercaseInput.substring(0, 1).toUpperCase();
        String restOfTheString = lowercaseInput.substring(1);

        return firstLetterCapitalized + restOfTheString;
    }

}
