module com.example.socialmedia {
    requires javafx.controls;
    requires javafx.fxml;
    requires org.hibernate.orm.core;
    requires com.fasterxml.jackson.annotation;
    requires jakarta.persistence;
    requires org.apache.logging.log4j;

    requires java.naming;
    requires javafx.graphics;

    requires java.net.http;
    requires com.fasterxml.jackson.databind;
    requires com.fasterxml.jackson.dataformat.csv;
    requires java.desktop;



    opens com.example.socialmedia to javafx.fxml , javafx.graphics;
    opens com.example.socialmedia.view to javafx.fxml;

    exports com.example.socialmedia;
    exports com.example.socialmedia.view;
    opens com.example.socialmedia.repository to org.hibernate.orm.core;
    exports com.example.socialmedia.viewmodel;
    opens com.example.socialmedia.model to org.hibernate.orm.core, com.fasterxml.jackson.databind, com.fasterxml.jackson.dataformat.csv, javafx.base;
    opens com.example.socialmedia.data to org.hibernate.orm.core;

}