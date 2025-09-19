package controller.login;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.stage.Stage;

import javax.swing.*;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class LoginFormController implements Initializable {
    Stage studentRegistration=new Stage();
    @FXML
    private JFXButton btnLogin;

    @FXML
    private JFXPasswordField txtPassword;

    @FXML
    private JFXTextField txtUserName;
    loginFormService loginFormService=new LoginController();

    @FXML
    void btnLoginOnAction(ActionEvent event) {
        boolean result=loginFormService.studentlogin(txtUserName.getText(),txtPassword.getText());
        clearTextArea();
        if(result==true){
            try {
                studentRegistration.setScene(new Scene(FXMLLoader.load(getClass().getResource("/view/studentRegistrationForm.fxml"))));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }else {
            JOptionPane.showMessageDialog(null,
                    "Invalid User Name Or Password",
                    "Login Fail",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        txtUserName.setOnKeyPressed(event -> {
            if (event.getCode() == KeyCode.ENTER) {
                btnLoginOnAction(null);  // Trigger the login action
            }
        });
        txtPassword.setOnKeyPressed(event -> {
            if (event.getCode() == KeyCode.ENTER) {
                btnLoginOnAction(null);  // Trigger the login action
            }
        });
        btnLogin.setOnAction(event -> btnLoginOnAction(event));
    }
    private void clearTextArea(){
        txtUserName.setText("");
        txtPassword.setText("");
    }
}
