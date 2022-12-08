package com.example.mytask.util;


import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

@Dao
public interface UserDao {

    @Insert
    void registerUser(UserEntity userEntity);

    @Query("SELECT * FROM user WHERE Email=(:email) and Password=(:pass)")
    UserEntity login(String email,String pass);
}
