package com.example.ss.coffeeshop.Activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.ss.coffeeshop.App;
import com.example.ss.coffeeshop.Entities.DaoSession;
import com.example.ss.coffeeshop.Entities.User;
import com.example.ss.coffeeshop.R;
import com.example.ss.coffeeshop.Services.LoggerInFile;
import com.example.ss.coffeeshop.Services.RoleService;
import com.example.ss.coffeeshop.Services.UIServices.FormService;
import com.example.ss.coffeeshop.Services.UserService;

import java.util.List;

public class AddUserActivity extends AppCompatActivity {

    UserService userService;
    RoleService roleService;
    DaoSession daoSession;
    LoggerInFile loggerInFile;
    List<String> roles;
    String roleName;
    TextView errors;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_user);
        errors = (TextView) findViewById(R.id.errInSave);
        this.daoSession = ((App)getApplication()).getDaoSession();
        this.loggerInFile = ((App)getApplication()).getLoggerInFile();
        this.userService = new UserService(this.daoSession);
        this.roleService = new RoleService(this.daoSession);
        this.roles = this.roleService.getAllRoleTitles();
        Spinner spinner = (Spinner) findViewById(R.id.spinner);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, this.roles);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        AdapterView.OnItemSelectedListener itemSelectedListener= new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                roleName = (String)adapterView.getItemAtPosition(i);

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        };
        spinner.setOnItemSelectedListener(itemSelectedListener);
    }

    public void saveUser(View view){
        FormService formService = new FormService(this.loggerInFile, this);
        String name = ((TextView) findViewById(R.id.nameUser)).getText().toString();
        String password = ((TextView) findViewById(R.id.passUser)).getText().toString();
        String nameStatus = formService.getFromForm(name);
        String passStatus = formService.getFromForm(password);

        if((nameStatus == null) && (passStatus == null)){
            this.userService.addUser(new User(name, password, this.roleService.getRoleIDbyTitle(this.roleName)));
        }
        else{
            if(nameStatus != null){
                this.errors.setText(nameStatus);
            }
            else{
                this.errors.setText(passStatus);
            }
        }

    }


}
