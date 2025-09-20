package controller.studentRegistration;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXRadioButton;
import com.jfoenix.controls.JFXTextField;
import controller.login.LoginFormController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.ToggleGroup;
import javafx.stage.Stage;

import javax.swing.*;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class StudentRegistrationFormController implements Initializable {

    @FXML
    private JFXButton btnReset;

    @FXML
    private JFXButton btnSubmit;

    @FXML
    private JFXButton btnViewDetails;

    @FXML
    private JFXComboBox<String> cmbx;

    @FXML
    private JFXRadioButton rdbtnFemale;

    @FXML
    private JFXRadioButton rdbtnMale;

    @FXML
    private JFXTextField txtEmail;

    @FXML
    private JFXTextField txtFullName;

    @FXML
    private JFXTextField txtId;
    @FXML
    private ToggleGroup genderGroup;
    Stage viewDetails=new Stage();
    StudentRegistrationService studentRegistrationService=new StudentRegistrationController();
    @FXML
    void btnResetOnAction(ActionEvent event) {
        clearFields();
    }

    @FXML
    void btnSubmitOnAction(ActionEvent event) {
        if (txtEmail.getText()==""||txtFullName.getText()==""){
            JOptionPane.showMessageDialog(null,
                    "Please Fill All the fields",
                    "Empty Field",
                    JOptionPane.ERROR_MESSAGE);
        }else{
            JFXRadioButton selectedRadioButton = (JFXRadioButton) genderGroup.getSelectedToggle();
            String gender="";
            if (selectedRadioButton != null) {
                gender = selectedRadioButton.getText();
            }
            boolean result =studentRegistrationService.registration(txtFullName.getText(),txtEmail.getText(),gender,cmbx.getValue());
            if(result){
                JOptionPane.showMessageDialog(null, "Registration Successful!", "Success", JOptionPane.INFORMATION_MESSAGE);
            }
        }

        clearFields();

    }
    @FXML
    void btnViewDetailsOnActionOnAction(ActionEvent event) {
        try {
            viewDetails.setScene(new Scene(FXMLLoader.load(getClass().getResource("/view/viewDetails.fxml"))));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        viewDetails.setResizable(false);
        viewDetails.show();
        Stage studentDetail=LoginFormController.getStageInstance();
        studentDetail.close();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        genderGroup = new ToggleGroup();
        rdbtnFemale.setToggleGroup(genderGroup);
        rdbtnMale.setToggleGroup(genderGroup);
        cmbx.getItems().addAll("Software Engineering", "Data Science", "AI and Machine Learning", "Cyber Security");
    }
    private void clearFields(){
        txtFullName.setText("");
        txtEmail.setText("");
        genderGroup.selectToggle(null);
        cmbx.setValue(null);
    }
}
