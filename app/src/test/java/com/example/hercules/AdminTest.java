package com.example.hercules;


import static org.junit.jupiter.api.Assertions.assertEquals;

import com.example.hercules.model.User;
import com.example.hercules.model.admin_overhead.Admin;

import org.junit.Test;

import java.util.List;


public class AdminTest {

    String id = "user0001";
    String pw = "pew";
    String name = "JJ";
    String birthdayText = "1998-03-12";
    Admin admin;
    String goalString = Admin.GoalTypes.CARDIO.toString();
//    @BeforeAll
//    public void runBefore() {
//        admin = new Admin();
//    }


    @Test
    public void constructorTest() {
        Admin admin = new Admin();
        assertEquals(0, admin.getUserList().size());
    }

    @Test
    public void createUserTest() {
        Admin admin = new Admin();

        User user = admin.createUser(id, pw, name, birthdayText, goalString);
        List<User> users = admin.getUserList();
        assertEquals(1, users.size());
    }

    @Test
    public void userLoginTest() {
        Admin admin = new Admin();
        User user = admin.createUser(id, pw, name, birthdayText, goalString);
        assertEquals(pw, user.getPW());
    }

    @Test
    public void setGoalTest() {
        Admin admin = new Admin();
        User user = admin.createUser(id, pw, name, birthdayText, goalString);
        assertEquals(Admin.GoalTypes.valueOf(goalString).toString(), user.getGoal().getName());
    }


}


