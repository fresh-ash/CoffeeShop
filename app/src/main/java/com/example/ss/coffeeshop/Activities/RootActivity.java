package com.example.ss.coffeeshop.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.example.ss.coffeeshop.R;

public class RootActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_root);

    }

    public void showLog(View view){
        Intent intent = new Intent(this, LogActivity.class);
        startActivity(intent);
    }

    public void deleteLog(View view){
        this.deleteFile("log.txt");
    }

    public void addUser(View view){
        Intent intent = new Intent(this, AddUserActivity.class);
        startActivity(intent);

    }

    public void addBoss(View view){

    }
}
