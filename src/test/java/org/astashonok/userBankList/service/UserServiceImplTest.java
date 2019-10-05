package org.astashonok.userBankList.service;

import org.astashonok.userBankList.model.User;
import org.junit.Before;
import org.junit.Test;

import java.sql.SQLException;

import static org.junit.Assert.assertEquals;

public class UserServiceImplTest {
    UserService userService = new UserServiceImpl();
    User user = new User();

    @Before
    public void setUp(){
        user.setName("Павел");
        user.setSurName("Павлов");
        user.setUser_id(8);
     }

    @Test
    public void shouldCreateUserInstanceTest(){
        assertEquals("Павел", user.getName());
        assertEquals("Павлов", user.getSurName());
        assertEquals(8, user.getUser_id());
      }

    @Test
    public void shouldCreateGetByIdTest(){
        try {
            assertEquals(user, userService.getById(8));
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}