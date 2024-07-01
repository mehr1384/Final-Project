module org.example.final_project {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.mail;
    requires java.sql;
    requires commons.math3;


    opens org.example.final_project to javafx.fxml;
    exports org.example.final_project;
}