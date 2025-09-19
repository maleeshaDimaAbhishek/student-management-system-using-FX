package controller.studentRegistration;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXRadioButton;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ToggleGroup;

import javax.swing.*;
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
    StudentRegistrationService studentRegistrationService=new StudentRegistrationController();
    @FXML
    void btnResetOnAction(ActionEvent event) {
        clearFields();
    }

    @FXML
    void btnSubmitOnAction(ActionEvent event) {
        JFXRadioButton selectedRadioButton = (JFXRadioButton) genderGroup.getSelectedToggle();
        String gender="";
        if (selectedRadioButton != null) {
            gender = selectedRadioButton.getText();
        }
        boolean result =studentRegistrationService.registration(txtFullName.getText(),txtEmail.getText(),gender,cmbx.getValue());
        if(result){
            JOptionPane.showMessageDialog(null, "Registration Successful!", "Success", JOptionPane.INFORMATION_MESSAGE);
        }
        clearFields();

    }
    @FXML
    void btnViewDetailsOnActionOnAction(ActionEvent event) {

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
