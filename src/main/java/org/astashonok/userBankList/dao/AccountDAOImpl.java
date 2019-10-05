package org.astashonok.userBankList.dao;

import org.astashonok.userBankList.model.Account;
import org.astashonok.userBankList.util.Util;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AccountDAOImpl implements AccountDAO {
    Util util = new Util();
//    private Connection connection = util.getConnection();

    @Override
    public void add(Account account) throws SQLException {
        Connection connection = util.getConnection();
        PreparedStatement preparedStatement = null;
        String sql = "INSERT INTO account (account_id, account, user_id) VALUES (?, ?, ?)";

        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, account.getAccount_id());
            preparedStatement.setInt(2, account.getAccount());
            preparedStatement.setInt(3, account.getUser_id());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (preparedStatement != null) preparedStatement.close();
            if (connection != null) connection.close();
        }
    }

    @Override
    public void delete(Account account) throws SQLException {
        Connection connection = util.getConnection();
        PreparedStatement preparedStatement = null;
        String sql = "DELETE FROM account WHERE account_id = ?";
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1,account.getAccount_id());
            preparedStatement.executeUpdate();
        } catch (SQLException e){
            e.printStackTrace();
        } finally {
            if (preparedStatement != null) preparedStatement.close();
            if (connection != null) connection.close();
        }
    }

    @Override
    public void edit(Account account) throws SQLException {
        Connection connection = util.getConnection();
        PreparedStatement preparedStatement = null;
        String sql = "UPDATE account SET account = ?, user_id = ? WHERE account_id = ?";
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(3, account.getAccount_id());
            preparedStatement.setInt(1, account.getAccount());
            preparedStatement.setInt(2, account.getUser_id());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (preparedStatement != null) preparedStatement.close();
            if (connection != null) connection.close();
        }
    }

//    Returning all accounts
    @Override
    public List<Account> getAllAccounts() throws SQLException {
        Connection connection = util.getConnection();
        List<Account> accounts = new ArrayList<>();
        String sql = "SELECT * FROM account";
        Statement statement = null;
        try {
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()){
                Account account = new Account();
                account.setAccount_id(resultSet.getInt("account_id"));
                account.setAccount(resultSet.getInt("account"));
                account.setUser_id(resultSet.getInt("user_id"));
                accounts.add(account);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (statement != null) statement.close();
            if (connection != null) connection.close();
        }
        return accounts;
    }
// Returning the sum of all the accounts in the bank
    @Override
    public int getSumAccounts() throws SQLException {
        Connection connection = util.getConnection();
        String sql = "SELECT SUM(account) from account";
        Statement statement = null;
        int sum = 0;
        try {
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            resultSet.next();
            sum = resultSet.getInt("SUM(account)");
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (statement != null) statement.close();
            if (connection != null) connection.close();
        }
        return sum;
    }
}
