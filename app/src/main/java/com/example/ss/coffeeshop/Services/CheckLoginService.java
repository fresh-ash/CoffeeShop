package com.example.ss.coffeeshop.Services;

import android.content.Context;
import android.content.res.Resources;

import com.example.ss.coffeeshop.Entities.User;
import com.example.ss.coffeeshop.Interfaces.ICheckInputStrategy;
import com.example.ss.coffeeshop.R;

/**
 * Created by ss on 28.09.17.
 */

public class CheckLoginService implements ICheckInputStrategy {

    private UserService service;
    private Resources res;
    private User user;

    public CheckLoginService(UserService service, Context context){
        this.service = service;
        this.res = context.getResources();

    }

    @Override
    public String check(User user) {
        String status = this.isUser(user);

        if((status == null)&&(this.user.getPassword().equals(user.getPassword()))){
            return null;
        }
        else if (status != null){
            return status;
        }
        else {
            return this.res.getString(R.string.badPassword);
        }
    }

    private String isUser(User user){
        this.user = this.service.getUserByName(user.getName());
        if(this.user==null){
            return this.res.getString(R.string.notUser, user.getName());
        }
        return null;
    }
// Подумать!!! И много!!
    public User getLoginUser(User user){
        if (this.check(user) == null){
            return this.user;
        }
        return null;
    }
}
