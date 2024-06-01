module org.example.final_project {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.mail;
    requires java.sql;


    opens org.example.final_project to javafx.fxml;
    exports org.example.final_project;
}