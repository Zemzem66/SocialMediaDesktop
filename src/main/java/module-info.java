module com.example.socialmedia {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.socialmedia to javafx.fxml;
    exports com.example.socialmedia;
}