package controller.viewDetails;

import com.jfoenix.controls.JFXButton;
import controller.login.LoginFormController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import model.StudentDetails;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ViewDetailsFormController implements Initializable {
    Stage studentRegistration=LoginFormController.getStageInstance();
    ViewDetailsService viewDetailsService=new ViewDetailsController();
    @FXML
    private JFXButton btnBack;

    @FXML
    private TableColumn<?, ?> course;

    @FXML
    private TableColumn<?, ?> gender;

    @FXML
    private TableView<StudentDetails> tbblViewRegDetails;

    @FXML
    private TableColumn<?, ?> tblEmail;

    @FXML
    private TableColumn<?, ?> tblId;

    @FXML
    private TableColumn<?, ?> tblName;

    @FXML
    void btnBackOnAction(ActionEvent event) {
        studentRegistration.setResizable(false);
        studentRegistration.show();
        Stage currentStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        currentStage.close();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        tblId.setCellValueFactory(new PropertyValueFactory<>("id"));
        tblName.setCellValueFactory(new PropertyValueFactory<>("name"));
        tblEmail.setCellValueFactory(new PropertyValueFactory<>("email"));
        gender.setCellValueFactory(new PropertyValueFactory<>("gender"));
        course.setCellValueFactory(new PropertyValueFactory<>("course"));

        tbblViewRegDetails.setItems(viewDetailsService.getAll());

    }
}
