package org.astashonok.userBankList.service;

import org.astashonok.userBankList.dao.AccountDAO;
import org.astashonok.userBankList.dao.AccountDAOImpl;
import org.astashonok.userBankList.model.Account;

import java.sql.SQLException;
import java.util.List;

public class AccountServiceImpl implements AccountService {
    private AccountDAO accountDAO = new AccountDAOImpl();

    @Override
    public void add(Account account) throws SQLException {
        accountDAO.add(account);
    }

    @Override
    public void delete(Account account) throws SQLException {
        accountDAO.delete(account);
    }

    @Override
    public void edit(Account account) throws SQLException {
        accountDAO.edit(account);
    }

    @Override
    public List<Account> getAllAccounts() throws SQLException {
        return accountDAO.getAllAccounts();
    }

    @Override
    public int getSumAccounts() throws SQLException {
        return accountDAO.getSumAccounts();
    }
}
