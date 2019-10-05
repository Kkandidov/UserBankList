package org.astashonok.userBankList.controller;

import org.astashonok.userBankList.model.Account;
import org.astashonok.userBankList.model.User;
import org.astashonok.userBankList.service.AccountService;
import org.astashonok.userBankList.service.AccountServiceImpl;
import org.astashonok.userBankList.service.UserService;
import org.astashonok.userBankList.service.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

public class UserAndAccountsController extends HttpServlet {

    private UserService userService = new UserServiceImpl();
    private AccountService accountService = new AccountServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.setContentType("text/html; charset=UTF-8");
        PrintWriter writer = resp.getWriter();
        List<Account> accounts = null;
        try {
            accounts = accountService.getAllAccounts();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        writer.println(accounts);
//        accounts.stream().forEach(writer::println);
   }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html; charset=UTF-8");
        PrintWriter writer = resp.getWriter();
        User user = null;
        int id = Integer.parseInt(req.getParameter("user_id"));
        try {
            user = userService.getById(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        writer.println(user);
    }
}
