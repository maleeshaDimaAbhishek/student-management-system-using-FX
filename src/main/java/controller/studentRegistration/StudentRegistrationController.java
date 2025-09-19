package controller.studentRegistration;

import db.DatabaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class StudentRegistrationController implements StudentRegistrationService{
    Connection connection= DatabaseConnection.getInstance().getConnection();
    @Override
    public boolean registration(String name, String email, String gender, String course) {
        String SQL = "INSERT INTO student_registration(full_name,email,gender,course) VALUES(?,?,?,?);";
        try {
            PreparedStatement preparedStatement=connection.prepareStatement(SQL);
            preparedStatement.setObject(1,name);
            preparedStatement.setObject(2,email);
            preparedStatement.setObject(3,gender);
            preparedStatement.setObject(4,course);
            int rowCount=preparedStatement.executeUpdate();

            if(rowCount>0){
                return true;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return false;
    }
}
