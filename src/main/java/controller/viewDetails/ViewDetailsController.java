package controller.viewDetails;

import db.DatabaseConnection;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.StudentDetails;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ViewDetailsController implements ViewDetailsService{
    Connection connection= DatabaseConnection.getInstance().getConnection();
    public ObservableList<StudentDetails> studentDetailsList= FXCollections.observableArrayList();
    @Override
    public ObservableList<StudentDetails> getAll() {
        String sql="SELECT * from student_registration";
        try {
            PreparedStatement preparedStatement=connection.prepareStatement(sql);
            ResultSet resultSet=preparedStatement.executeQuery();
            while (resultSet.next()){
                studentDetailsList.add(new StudentDetails(
                        resultSet.getInt("id"),
                        resultSet.getString("full_name"),
                        resultSet.getString("email"),
                        resultSet.getString("gender"),
                        resultSet.getString("course")
                ));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return studentDetailsList;
    }
}
