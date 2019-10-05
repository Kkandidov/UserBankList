package org.astashonok.userBankList.controller;

import org.astashonok.userBankList.service.AccountService;
import org.astashonok.userBankList.service.AccountServiceImpl;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

public class GettingSumAccountsController extends HttpServlet {
    private AccountService accountService = new AccountServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.setContentType("text/html; charset=UTF-8");
        PrintWriter writer = resp.getWriter();
        int sum = 0;
        try {
            sum = accountService.getSumAccounts();
        } catch (SQLException e) {
            e.printStackTrace();
        }
       writer.write(String.valueOf(sum));
    }
}
