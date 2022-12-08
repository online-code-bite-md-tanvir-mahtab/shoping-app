package com.example.mytask.util;


import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "user")
public class UserEntity {

//    creating the id columns
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    private int id;

//    creating the name column
    @ColumnInfo(name = "username")
    private String userName;

    //    creating the email columns
    @ColumnInfo(name = "Email")
    private String Email;

//    creating the password columns
    @ColumnInfo(name = "Password")
    private String Password;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }
}
