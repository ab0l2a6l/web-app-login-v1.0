package repository;

import common.JDBC;
import domain.Users;
import exeption.InvalidUsernameOrPassword;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UsersDB implements AutoCloseable{
    private Connection connection;
    private PreparedStatement preparedStatement;

    public UsersDB()throws Exception{
        connection = JDBC.getConnection();
    }

    public Users selectOneUserByUsernameOrPassword(String username , String password)throws Exception{
        preparedStatement = connection.prepareStatement("select * from users where lower(username) = lower(?) and password = ?");
        preparedStatement.setString(1, username);
        preparedStatement.setString(2 , password);
        ResultSet set = preparedStatement.executeQuery();
        if (set.next()){
            return new Users().setRoleName(set.getString("role_name")).setUsername(username).setPassword(password);
        }
        throw new InvalidUsernameOrPassword();
    }

    @Override
    public void close() throws Exception {
        connection.close();
        preparedStatement.close();
    }
}
