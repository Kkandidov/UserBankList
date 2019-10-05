package org.astashonok.userBankList.service;

import org.astashonok.userBankList.model.Account;
import java.sql.SQLException;
import java.util.List;

public interface AccountService {
    void add(Account account) throws SQLException;
    void delete(Account account) throws SQLException;
    void edit(Account account) throws SQLException;
    List <Account> getAllAccounts() throws SQLException;
    int getSumAccounts() throws SQLException;
}
