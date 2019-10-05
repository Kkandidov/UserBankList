package org.astashonok.userBankList.dao;

import org.astashonok.userBankList.model.User;

import java.sql.SQLException;
import java.util.List;

public interface UserDAO {
    void add(User user) throws SQLException;
    void delete(User user) throws SQLException;
    void edit(User user) throws SQLException;
    User getById (int id) throws SQLException;
    List<User> getRichestOfUsers() throws SQLException;
}
