package org.astashonok.userBankList.dao;

import org.astashonok.userBankList.model.User;
import org.astashonok.userBankList.util.Util;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDAOImpl implements UserDAO {
    Util util = new Util();
//    private Connection connection = util.getConnection();

    @Override
    public void add(User user) throws SQLException {
        Connection connection = util.getConnection();
        PreparedStatement preparedStatement = null;
        String sql = "INSERT INTO user (user_id, name, surname) VALUES (?, ?, ?)";
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1,user.getUser_id());
            preparedStatement.setString(2,user.getName());
            preparedStatement.setString(3,user.getSurName());
            preparedStatement.executeUpdate();
        } catch (SQLException e){
            e.printStackTrace();
        } finally {
            if (preparedStatement != null) preparedStatement.close();
            if (connection != null) connection.close();
        }
    }

    @Override
    public void delete(User user) throws SQLException {
        Connection connection = util.getConnection();
        PreparedStatement preparedStatement = null;
        String sql = "DELETE FROM user WHERE user_id = ?";

        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1,user.getUser_id());
            preparedStatement.executeUpdate();
        } catch (SQLException e){
            e.printStackTrace();
        } finally {
            if (preparedStatement != null) preparedStatement.close();
            if (connection != null) connection.close();
        }
    }

    @Override
    public void edit(User user) throws SQLException {
        Connection connection = util.getConnection();
        PreparedStatement preparedStatement = null;
        String sql = "UPDATE user SET name = ?, surname = ? WHERE user_id = ?";
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(3,user.getUser_id());
            preparedStatement.setString(1,user.getName());
            preparedStatement.setString(2,user.getSurName());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (preparedStatement != null) preparedStatement.close();
            if (connection != null) connection.close();
        }
    }

    // Returning from the user's data table by its id
    @Override
    public User getById(int id) throws SQLException {
        Connection connection = util.getConnection();
        PreparedStatement preparedStatement = null;
        String sql = "SELECT * FROM user WHERE user_id=?";
        User user = new User();
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            resultSet.next();
            user.setUser_id(resultSet.getInt("user_id"));
            user.setName(resultSet.getString("name"));
            user.setSurName(resultSet.getString("surname"));
          } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (preparedStatement != null) preparedStatement.close();
            if (connection != null) connection.close();
        }
        return user;
    }

//    Returning the richest user
    @Override
    public List<User> getRichestOfUsers() throws SQLException {
        Connection connection = util.getConnection();
        List<User> users = new ArrayList<>();
        String sql = "SELECT user.user_id, name, surname FROM user, account WHERE user.user_id = account.user_id AND account.account=(SELECT MAX(account) FROM account)";
        Statement statement = null;
        try {
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()){
                User user = new User();
                user.setUser_id(resultSet.getInt("user_id"));
                user.setName(resultSet.getString("name"));
                user.setSurName(resultSet.getString("surname"));
                users.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (statement != null) statement.close();
            if (connection != null) connection.close();
        }
        return users;
    }
}
