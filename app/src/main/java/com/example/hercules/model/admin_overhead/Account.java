package com.example.hercules.model.admin_overhead;

import android.os.Build;

import androidx.annotation.RequiresApi;

import java.time.LocalDate;

public class Account {
    private final String id;
    private String pw;
    private String name;
    private final LocalDate birthDay;

    public Account(String id, String pw, String name, LocalDate birthDay) {
        this.id = id;
        this.pw = pw;
        this.name = name;
        this.birthDay = birthDay;
    }

    public Account(String id, String pw, String name, String birthDayString) {
        LocalDate birthday;
        birthday = LocalDate.parse(birthDayString);
        this.id = id;
        this.pw = pw;
        this.name = name;
        this.birthDay = birthday;
    }

    public String getName() {
        return name;
    }

    public java.lang.String getUserID() {
        return id;
    }

    public String getUserPW() {
        return pw;
    }

    public LocalDate getBirthDay() {
        return birthDay;
    }

    public void setPw(String newPw) {
        this.pw = newPw;
    }

    public void setName(String name) {
        this.name = name;
    }
}
