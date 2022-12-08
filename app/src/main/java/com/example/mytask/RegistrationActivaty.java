package com.example.mytask;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.mytask.database.AppDatabase;
import com.example.mytask.util.UserDao;
import com.example.mytask.util.UserEntity;

public class RegistrationActivaty extends AppCompatActivity {
    EditText emailId;
    EditText password;
    EditText username;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration_activaty);
    }

    public void onClick(View view) {
        emailId = (EditText) findViewById(R.id.txtEmailAddress);
        username = (EditText) findViewById(R.id.username);
        password = (EditText) findViewById(R.id.txtPassword);


//        creating the User Entity
        UserEntity userEntity = new UserEntity();
        userEntity.setEmail(emailId.getText().toString());
        userEntity.setUserName(username.getText().toString());
        userEntity.setPassword(password.getText().toString());
        if (validateInput(userEntity)){
            AppDatabase userDatabase = AppDatabase.getDatabase(getApplicationContext());
            final UserDao userDao = userDatabase.userDao();
            new Thread(new Runnable() {
                @Override
                public void run() {
                    userDao.registerUser(userEntity);
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            Toast.makeText(getApplicationContext(),"User Registered",Toast.LENGTH_LONG).show();
                        }
                    });

                }
            }).start();
        }else{
            Toast.makeText(RegistrationActivaty.this,"Fill out the form",Toast.LENGTH_LONG).show();
        }
    }
    private Boolean validateInput(UserEntity userEntity){
        if (userEntity.getUserName().isEmpty() || userEntity.getEmail().isEmpty() || userEntity.getPassword().isEmpty()){
            return false;
        }
        return true;
    }

    public void onLogin(View view) {
        Intent intent = new Intent(RegistrationActivaty.this,LoginActivaty.class);
        startActivity(intent);
    }
}