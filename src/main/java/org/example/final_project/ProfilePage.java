package org.example.final_project;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.util.regex.Pattern;

public class ProfilePage {

    @FXML
    private Button btnEdit;

    @FXML
    private Button btnHistory;

    @FXML
    private Button btnPicture;
    @FXML
    private Button btnHomePage;
    @FXML
    private Button btnWallet;
    @FXML
    private ImageView pictureView;
    @FXML
    private Label lblEmail;

    @FXML
    private Label lblName;

    @FXML
    private Label lblUsername;
    @FXML
    private Label lblPhone;

    @FXML
    private TextField textEmail;

    @FXML
    private TextField textFirstName;

    @FXML
    private TextField textLastName;

    @FXML
    private TextField textPassword;

    @FXML
    private TextField textPhone;

    @FXML
    public void initialize() {
        UserProfile userProfile = UserProfile.getInstance();
        textEmail.setText(userProfile.getEmail());
        lblEmail.setText(userProfile.getEmail());
        textFirstName.setText(userProfile.getFirstName());
        textLastName.setText(userProfile.getLastName());
        lblName.setText(userProfile.getFirstName() + " " + userProfile.getLastName());
        textPassword.setText(userProfile.getPassword());
        textPhone.setText(userProfile.getPhone());
        lblPhone.setText(userProfile.getPhone());
        lblUsername.setText(userProfile.getUsername());
        textEmail.setEditable(false);
        textPassword.setEditable(false);
        textPhone.setEditable(false);
        textFirstName.setEditable(false);
        textLastName.setEditable(false);
        btnPicture.setOnAction(event -> Picture(event));
    }
    @FXML
    void HomePage(ActionEvent event) throws IOException {
        Stage stage = (Stage) btnHomePage.getScene().getWindow();
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("HomePage.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Home Page");
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void EditProfile(ActionEvent event) throws IOException {
        textEmail.setEditable(true);
        textFirstName.setEditable(true);
        textPassword.setEditable(true);
        textPhone.setEditable(true);
        textLastName.setEditable(true);
        if (TextFieldEmail(event) && TextFieldFirstName(event) && TextFieldLastName(event) &&
                TextFieldPassword(event) && TextFieldPhone(event)) {
            UserProfile userProfile = UserProfile.getInstance();
            textEmail.setEditable(textEmail.getText().equals(userProfile.getEmail()));
            textLastName.setEditable(textLastName.getText().equals(userProfile.getLastName()));
            textFirstName.setEditable(textFirstName.getText().equals(userProfile.getFirstName()));
            textPhone.setEditable(textPhone.getText().equals(userProfile.getPhone()));
            textPassword.setEditable(textPassword.getText().equals(userProfile.getPassword()));

            userProfile.setEmail(textEmail.getText());
            userProfile.setFirstName(textFirstName.getText());
            userProfile.setLastName(textLastName.getText());
            userProfile.setPassword(textPassword.getText());
            userProfile.setPhone(textPhone.getText());
            lblName.setText(userProfile.getFirstName() + " " + userProfile.getLastName());
            lblEmail.setText(userProfile.getEmail());
            lblPhone.setText(userProfile.getPhone());
        }
    }
    @FXML
    void History(ActionEvent event) throws IOException {


    }

    @FXML
    void Picture(ActionEvent event) {
        FileChooser fileChooser = new FileChooser();
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("Image Files", "*.png", "*.jpg", "*.jpeg"));
        File selectedFile = fileChooser.showOpenDialog(btnPicture.getScene().getWindow());

        if (selectedFile != null) {
            Image image = new Image(selectedFile.toURI().toString());
            pictureView.setImage(image);
        }
    }


    @FXML
    boolean TextFieldEmail(ActionEvent event) {
        String regex = "^[a-zA-Z0-9]+@[a-zA-Z0-9]+\\.com$";
        if (Pattern.matches(regex, textEmail.getText())) {
          //  lblErrorEmail.setText("");
            return true;
        }else{
         //   lblErrorEmail.setText("Email is incorrect.");
            return false;}
    }

    @FXML
    boolean TextFieldFirstName(ActionEvent event) {
        String regex = "^[a-zA-Z]{1,18}$";
        if(Pattern.matches(regex, textFirstName.getText())){
           // lblErrorFirstName.setText("");
            return true;
        }else {
           // lblErrorFirstName.setText("First name is incorrect.");
            return false;
        }
    }
    @FXML
    boolean TextFieldLastName(ActionEvent event) {
        String regex = "^[a-zA-Z]{1,18}$";
        if ((Pattern.matches(regex, textLastName.getText()))) {
          //  lblErrorLastName.setText("");
            return true;
        }else {
          //  lblErrorLastName.setText("Last name is incorrect.");
            return false;
        }
    }

    @FXML
    boolean TextFieldPassword(ActionEvent event) {
        String regex = "^[a-zA-Z0-9]{8,12}$";
        if (Pattern.matches(regex, textPassword.getText())){
           // lblErrorPassword.setText("");
            return true;
        }else{
         //   lblErrorPassword.setText("Password is incorrect.");
            return false;
        }
    }

    @FXML
    boolean TextFieldPhone(ActionEvent event) {
        String regex = "^09[0-9]{9}$";
        if (Pattern.matches(regex, textPhone.getText())){
            //lblErrorPhoneNumber.setText("");
            return true;
        }else{
          //  lblErrorPhoneNumber.setText("Phone number is incorrect.");
            return false;
        }
    }
    @FXML
    void Wallet(ActionEvent event) throws IOException {
        Stage stage = (Stage) btnWallet.getScene().getWindow();
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("WalletPage.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Wallet Page");
        stage.setScene(scene);
        stage.show();
    }

    public Button getBtnEdit() {
        return btnEdit;
    }

    public void setBtnEdit(Button btnEdit) {
        this.btnEdit = btnEdit;
    }

    public Button getBtnHistory() {
        return btnHistory;
    }

    public void setBtnHistory(Button btnHistory) {
        this.btnHistory = btnHistory;
    }

    public Button getBtnPicture() {
        return btnPicture;
    }

    public void setBtnPicture(Button btnPicture) {
        this.btnPicture = btnPicture;
    }

    public Button getBtnWallet() {
        return btnWallet;
    }

    public void setBtnWallet(Button btnWallet) {
        this.btnWallet = btnWallet;
    }

    public Label getLblEmail() {
        return lblEmail;
    }

    public void setLblEmail(Label lblEmail) {
        this.lblEmail = lblEmail;
    }

    public Label getLblName() {
        return lblName;
    }

    public void setLblName(Label lblName) {
        this.lblName = lblName;
    }

    public Label getLblUsername() {
        return lblUsername;
    }

    public void setLblUsername(Label lblUsername) {
        this.lblUsername = lblUsername;
    }

    public TextField getTextEmail() {
        return textEmail;
    }

    public void setTextEmail(TextField textEmail) {
        this.textEmail = textEmail;
    }

    public TextField getTextFirstName() {
        return textFirstName;
    }

    public void setTextFirstName(TextField textFirstName) {
        this.textFirstName = textFirstName;
    }

    public TextField getTextLastName() {
        return textLastName;
    }

    public void setTextLastName(TextField textLastName) {
        this.textLastName = textLastName;
    }

    public TextField getTextPassword() {
        return textPassword;
    }

    public void setTextPassword(TextField textPassword) {
        this.textPassword = textPassword;
    }

    public TextField getTextPhone() {
        return textPhone;
    }

    public void setTextPhone(TextField textPhone) {
        this.textPhone = textPhone;
    }
}
