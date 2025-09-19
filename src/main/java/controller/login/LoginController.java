package controller.login;

import db.DatabaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginController implements loginFormService{
    Connection connection;
    {
        connection=DatabaseConnection.getInstance().getConnection();
    }
    @Override
    public boolean studentlogin(String userName, String password) {
        String sql = "SELECT * FROM login_data WHERE userName = ? AND password = ?";
        try {
            PreparedStatement preparedStatement= connection.prepareStatement(sql);
            preparedStatement.setObject(1,userName);
            preparedStatement.setObject(2,password);
            ResultSet resultSet=preparedStatement.executeQuery();
            if(resultSet.next()){
                return true;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return false;
    }
}
