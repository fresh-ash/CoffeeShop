package com.example.ss.coffeeshop.Services;

import com.example.ss.coffeeshop.Entities.DaoSession;
import com.example.ss.coffeeshop.Entities.User;
import com.example.ss.coffeeshop.Entities.UserDao;

import java.util.List;

/**
 * Created by ss on 29.09.17.
 */

public class UserService {

    private DaoSession session;

    public UserService(DaoSession session){
        this.session = session;
    }

    public User getUserByName(String name){
        User user = this.session.getUserDao().queryBuilder().where(UserDao.Properties.Name.eq(name)).unique();
        return user;
    }

    public List<User> getAllUsers(){
        List<User> allUsers = this.session.getUserDao().loadAll();
        return allUsers;
    }

    public void addUser(User user){
        this.session.getUserDao().save(user);
    }
}
