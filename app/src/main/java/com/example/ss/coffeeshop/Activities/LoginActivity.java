package com.example.ss.coffeeshop.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.example.ss.coffeeshop.App;
import com.example.ss.coffeeshop.Entities.DaoSession;
import com.example.ss.coffeeshop.Entities.User;
import com.example.ss.coffeeshop.R;
import com.example.ss.coffeeshop.Services.CheckLoginService;
import com.example.ss.coffeeshop.Services.LoggerInFile;
import com.example.ss.coffeeshop.Services.UIServices.FormService;
import com.example.ss.coffeeshop.Services.UserService;

public class LoginActivity extends AppCompatActivity {

    DaoSession daoSession;
    LoggerInFile log;
    TextView errorText;
    CheckLoginService checkLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        this.errorText = (TextView) findViewById(R.id.errMessage);
        this.daoSession = ((App) getApplication()).getDaoSession();
        this.log = ((App) getApplication()).getLoggerInFile();
        this.checkLogin = new CheckLoginService(new UserService(this.daoSession), this);
    }

    public void login(View view){
        FormService formService = new FormService(this.log, this);
        String name = ((EditText) findViewById(R.id.editText)).getText().toString();
        String password = ((EditText) findViewById(R.id.editText2)).getText().toString();
     //Проыерка на стороне клиента
        String nameStatus = formService.getFromForm(name);
        String passStatus = formService.getFromForm(password);

        if ((nameStatus == null)&&(passStatus == null)){
            User user = new User(name,password);

            //Проверка на стороне сервера
            String status = this.checkLogin.check(user);
            if (status == null){
                user = this.checkLogin.getLoginUser(user);
                String userRole = user.getRole().getRole();
                if (userRole.equals("admin")){
                    Intent intent = new Intent(this, RootActivity.class);
                    intent.putExtra("user_id", user.getId());
                    startActivity(intent);
                }
                else if(userRole.equals("seller")){
                    Intent intent = new Intent(this, SellerActivity.class);
                    intent.putExtra("user_id", user.getId());
                    startActivity(intent);
                }
            }
            else {
                this.log.writeLogToFile(status);
                this.errorText.setText(status);
            }
        }
        else{
            if(nameStatus!=null){
                this.errorText.setText(nameStatus);
            }
            else {
                this.errorText.setText(passStatus);
            }
        }

    }
}
