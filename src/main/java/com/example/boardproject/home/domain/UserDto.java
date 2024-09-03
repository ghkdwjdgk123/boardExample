package com.example.boardproject.home.domain;

import org.springframework.format.annotation.DateTimeFormat;

import java.sql.Timestamp;
import java.util.Date;

public class UserDto {
    private String name;
    private String id;
    private String password;
    @DateTimeFormat(pattern = "yyyy-mm-dd")
    private Date birthDay;

    private Timestamp lastLogin;

    private Timestamp created;
    private String cr_id = "admin";
    private Timestamp updated;
    private String ur_id = "admin";

    public UserDto(){

    }
    public String getUr_id() {
        return ur_id;
    }

    public void setUr_id(String ur_id) {
        this.ur_id = ur_id;
    }

    public Timestamp getUpdated() {
        return updated;
    }

    public void setUpdated(Timestamp updated) {
        this.updated = updated;
    }

    public String getCr_id() {
        return cr_id;
    }

    public void setCr_id(String cr_id) {
        this.cr_id = cr_id;
    }

    public Timestamp getCreated() {
        return created;
    }

    public void setCreated(Timestamp created) {
        this.created = created;
    }

    public Timestamp getLastLogin() {
        return lastLogin;
    }

    public void setLastLogin(Timestamp lastLogin) {
        this.lastLogin = lastLogin;
    }

    public Date getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(Date birthDay) {
        this.birthDay = birthDay;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "UserDto{" +
                "name='" + name + '\'' +
                ", id='" + id + '\'' +
                ", password='" + password + '\'' +
                ", birthDay=" + birthDay +
                ", lastLogin=" + lastLogin +
                ", created=" + created +
                ", cr_id='" + cr_id + '\'' +
                ", updated=" + updated +
                ", ur_id='" + ur_id + '\'' +
                '}';
    }
}
