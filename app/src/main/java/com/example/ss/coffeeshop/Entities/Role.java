package com.example.ss.coffeeshop.Entities;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.annotation.Id;

/**
 * Created by ss on 28.09.17.
 */
@Entity
public class Role{
    @Id(autoincrement = true)
    private Long id;

    private String role;

    @Generated(hash = 52112506)
    public Role(Long id, String role) {
        this.id = id;
        this.role = role;
    }

    @Generated(hash = 844947497)
    public Role() {
    }

    public Role(String role) {
        this.role = role;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }


}
