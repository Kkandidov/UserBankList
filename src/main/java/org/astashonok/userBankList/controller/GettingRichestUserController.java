package org.astashonok.userBankList.controller;

import org.astashonok.userBankList.model.User;
import org.astashonok.userBankList.service.UserService;
import org.astashonok.userBankList.service.UserServiceImpl;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

public class GettingRichestUserController extends HttpServlet {
    private UserService userService = new UserServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.setContentType("text/html; charset=UTF-8");
        PrintWriter writer = resp.getWriter();
        List<User> users = null;
        try {
            users = userService.getRichestOfUsers();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        writer.println(users);
//        users.stream().forEach(writer::println);
    }
}
