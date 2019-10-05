package org.astashonok.userBankList.controller;

import org.astashonok.userBankList.model.Account;
import org.astashonok.userBankList.model.User;
import org.junit.Test;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;

public class UserAndAccountsControllerTest {
    final UserAndAccountsController controller = new UserAndAccountsController();
    final HttpServletRequest request = mock(HttpServletRequest.class);
    final HttpServletResponse response = mock(HttpServletResponse.class);
    final PrintWriter writer = mock(PrintWriter.class);


    @Test
    public void doGetTest() throws IOException {
        List<Account> accounts = new ArrayList<>();
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

        when(response.getWriter()).thenReturn(writer);
        controller.doGet(request,response);
        verify(response.getWriter()).println(accounts);
    }

    @Test
    public void doPostTest () throws IOException, ServletException {
        User user = new User();
        user.setName("Павел");
        user.setSurName("Павлов");
        user.setUser_id(8);

        when(request.getParameter("user_id")).thenReturn("8");
        when(response.getWriter()).thenReturn(writer);
        controller.doPost(request, response);
        verify(request).getParameter("user_id");
        verify(response.getWriter()).println(user);
    }

}