package com.example.mytask;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProviders;

import android.app.ActivityManager;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.mytask.database.AppDatabase;
import com.example.mytask.util.UserDao;
import com.example.mytask.util.UserEntity;


public class LoginActivaty extends AppCompatActivity{
    EditText emailId;
    EditText pass;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_activaty);
    }


    public void onClick(View view) {
        emailId = (EditText) findViewById(R.id.logi_email_id);
        pass = (EditText) findViewById(R.id.login_email_password);
        String user_email = emailId.getText().toString();
        String user_pass = pass.getText().toString();
        if (user_email.isEmpty() || user_pass.isEmpty()){
            Toast.makeText(getApplicationContext(),"Please fill out the form",Toast.LENGTH_SHORT).show();
        }else{
            AppDatabase userDatabase = AppDatabase.getDatabase(getApplicationContext());
            UserDao userDao = userDatabase.userDao();
            new Thread(new Runnable() {
                @Override
                public void run() {
                    UserEntity userEntity = userDao.login(user_email,user_pass);
                    if (userEntity == null){
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                Toast.makeText(getApplicationContext(),"Invalide info",Toast.LENGTH_SHORT).show();
                            }
                        });
                    }else{
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                Toast.makeText(getApplicationContext(),"Welcome",Toast.LENGTH_SHORT).show();
                            }
                        });
                        startActivity(new Intent(LoginActivaty.this,MainActivity.class));
                    }
                }
            }).start();
        }
    }
}