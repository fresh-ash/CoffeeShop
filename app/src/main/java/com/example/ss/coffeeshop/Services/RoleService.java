package com.example.ss.coffeeshop.Services;

import com.example.ss.coffeeshop.Entities.DaoSession;
import com.example.ss.coffeeshop.Entities.Role;
import com.example.ss.coffeeshop.Entities.RoleDao;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ss on 02.10.17.
 */

public class RoleService {

    private DaoSession daoSession;
    private RoleDao roleDao;

    public RoleService(DaoSession session){
        this.daoSession = session;
        this.roleDao = daoSession.getRoleDao();
    }

    public List<Role> getAllRoles(){
        List<Role> list = roleDao.loadAll();
        return list;
    }

    public List<String> getAllRoleTitles(){
        List<String> list  = new ArrayList<>();
        List<Role> roleList = this.getAllRoles();
        for (Role role: roleList) {
            list.add(role.getRole());
        }
        return list;
    }

    public Long getRoleIDbyTitle(String name){
        Long id = this.roleDao.queryBuilder().where(RoleDao.Properties.Role.eq(name)).unique().getId();
        return id;
    }

    public void addRole(String name){
        this.roleDao.save(new Role(name));
    }
}
