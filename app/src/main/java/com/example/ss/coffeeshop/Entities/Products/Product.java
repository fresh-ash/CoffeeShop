package com.example.ss.coffeeshop.Entities.Products;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;

/**
 * Created by ss on 03.10.17.
 */
@Entity
public class Product {

    @Id(autoincrement = true)
    private Long id;
    private String name;

    public Product(String name){
        this.name = name;
    }

    @Generated(hash = 1475182087)
    public Product(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    @Generated(hash = 1890278724)
    public Product() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }





}
