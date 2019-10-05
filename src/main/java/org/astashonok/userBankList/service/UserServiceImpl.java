package org.astashonok.userBankList.service;

import org.astashonok.userBankList.dao.UserDAO;
import org.astashonok.userBankList.dao.UserDAOImpl;
import org.astashonok.userBankList.model.User;

import java.sql.SQLException;
import java.util.List;


public class UserServiceImpl implements UserService {
    private UserDAO userDAO = new UserDAOImpl();

    @Override
    public void add(User user) throws SQLException {
        userDAO.add(user);
    }

    @Override
    public void delete(User user) throws SQLException {
        userDAO.delete(user);
    }

    @Override
    public void edit(User user) throws SQLException {
        userDAO.edit(user);
    }

    @Override
    public User getById(int id) throws SQLException {
        return userDAO.getById(id);
    }

    @Override
    public List<User> getRichestOfUsers() throws SQLException {
        return userDAO.getRichestOfUsers();
    }
}
