package org.astashonok.userBankList.service;

import org.astashonok.userBankList.model.Account;
import org.junit.Before;
import org.junit.Test;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class AccountServiceImplTest {
    AccountService accountService = new AccountServiceImpl();
    List<Account> accounts = new ArrayList<>();

    @Before
    public void setUp(){
        for (int i=0; i < 10; i++) accounts.add(new Account());
        accounts.get(0).setAccount_id(10);
        accounts.get(0).setAccount(4000);
        accounts.get(0).setUser_id(0);

        accounts.get(1).setAccount_id(11);
        accounts.get(1).setAccount(2000);
        accounts.get(1).setUser_id(1);

        accounts.get(2).setAccount_id(12);
        accounts.get(2).setAccount(3000);
        accounts.get(2).setUser_id(2);

        accounts.get(3).setAccount_id(13);
        accounts.get(3).setAccount(5000);
        accounts.get(3).setUser_id(3);

        accounts.get(4).setAccount_id(14);
        accounts.get(4).setAccount(1000);
        accounts.get(4).setUser_id(4);

        accounts.get(5).setAccount_id(15);
        accounts.get(5).setAccount(9000);
        accounts.get(5).setUser_id(5);

        accounts.get(6).setAccount_id(16);
        accounts.get(6).setAccount(6000);
        accounts.get(6).setUser_id(6);

        accounts.get(7).setAccount_id(17);
        accounts.get(7).setAccount(8000);
        accounts.get(7).setUser_id(7);

        accounts.get(8).setAccount_id(18);
        accounts.get(8).setAccount(7000);
        accounts.get(8).setUser_id(8);

        accounts.get(9).setAccount_id(19);
        accounts.get(9).setAccount(9000);
        accounts.get(9).setUser_id(9);
    }

    @Test
    public void shouldCreateGetAllAccountsTest(){
        try {
            assertEquals(accounts, accountService.getAllAccounts());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}