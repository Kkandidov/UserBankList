package org.astashonok.userBankList.dao;

import org.astashonok.userBankList.model.Account;

import java.sql.SQLException;
import java.util.List;

public interface AccountDAO {
    void add(Account account) throws SQLException;
    void delete(Account account) throws SQLException;
    void edit(Account account) throws SQLException;
    List <Account> getAllAccounts() throws SQLException;
    int getSumAccounts() throws SQLException;
}
