package com.example.ss.coffeeshop.Entities;

import org.greenrobot.greendao.DaoException;
import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.ToOne;

/**
 * Created by ss on 28.09.17.
 */

@Entity
public class User{

    @Id(autoincrement = true)
    private Long id;

    private String name;

    private String password;

    private Long roleId;

    @ToOne(joinProperty = "roleId")
    private Role role;

    /** Used to resolve relations */
    @Generated(hash = 2040040024)
    private transient DaoSession daoSession;

    /** Used for active entity operations. */
    @Generated(hash = 1507654846)
    private transient UserDao myDao;

    @Generated(hash = 312471022)
    private transient Long role__resolvedKey;

    @Generated(hash = 1693969134)
    public User(Long id, String name, String password, Long roleId) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.roleId = roleId;
    }

    @Generated(hash = 586692638)
    public User() {
    }

    public User(String name, String password){
        this.name = name;
        this.password = password;
    }

    public User(String name, String password, Long roleId){
        this.name = name;
        this.password = password;
        this.roleId = roleId;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Long getRoleId() {
        return this.roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    /** To-one relationship, resolved on first access. */
    @Generated(hash = 1948065557)
    public Role getRole() {
        Long __key = this.roleId;
        if (role__resolvedKey == null || !role__resolvedKey.equals(__key)) {
            final DaoSession daoSession = this.daoSession;
            if (daoSession == null) {
                throw new DaoException("Entity is detached from DAO context");
            }
            RoleDao targetDao = daoSession.getRoleDao();
            Role roleNew = targetDao.load(__key);
            synchronized (this) {
                role = roleNew;
                role__resolvedKey = __key;
            }
        }
        return role;
    }

    /** called by internal mechanisms, do not call yourself. */
    @Generated(hash = 736917490)
    public void setRole(Role role) {
        synchronized (this) {
            this.role = role;
            roleId = role == null ? null : role.getId();
            role__resolvedKey = roleId;
        }
    }

    /**
     * Convenient call for {@link org.greenrobot.greendao.AbstractDao#delete(Object)}.
     * Entity must attached to an entity context.
     */
    @Generated(hash = 128553479)
    public void delete() {
        if (myDao == null) {
            throw new DaoException("Entity is detached from DAO context");
        }
        myDao.delete(this);
    }

    /**
     * Convenient call for {@link org.greenrobot.greendao.AbstractDao#refresh(Object)}.
     * Entity must attached to an entity context.
     */
    @Generated(hash = 1942392019)
    public void refresh() {
        if (myDao == null) {
            throw new DaoException("Entity is detached from DAO context");
        }
        myDao.refresh(this);
    }

    /**
     * Convenient call for {@link org.greenrobot.greendao.AbstractDao#update(Object)}.
     * Entity must attached to an entity context.
     */
    @Generated(hash = 713229351)
    public void update() {
        if (myDao == null) {
            throw new DaoException("Entity is detached from DAO context");
        }
        myDao.update(this);
    }

    @Override
    public String toString(){
        String str = "User name: " + this.name + "\nPassword: " + this.password + "\n";
        return str;
    }


    /** called by internal mechanisms, do not call yourself. */
    @Generated(hash = 2059241980)
    public void __setDaoSession(DaoSession daoSession) {
        this.daoSession = daoSession;
        myDao = daoSession != null ? daoSession.getUserDao() : null;
    }


}
