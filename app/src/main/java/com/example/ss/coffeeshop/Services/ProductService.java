package com.example.ss.coffeeshop.Services;

import com.example.ss.coffeeshop.Entities.DaoSession;
import com.example.ss.coffeeshop.Entities.Products.Product;
import com.example.ss.coffeeshop.Entities.Products.ProductDao;

import java.util.List;

/**
 * Created by ss on 04.10.17.
 */

public class ProductService {

    private DaoSession daoSession;
    private ProductDao productDao;

    public ProductService(DaoSession daoSession){
        this.daoSession = daoSession;
        this.productDao = daoSession.getProductDao();
    }

    public List<Product> getAllProducts(){
        return this.productDao.loadAll();
    }

    public List<Product> getProductsByCategory(Long categoryId){
        return this.productDao.queryBuilder().where(ProductDao.Properties.CategoryID.eq(categoryId)).list();
    }

    public Product getProductByName(String name){
        return this.productDao.queryBuilder().where(ProductDao.Properties.Name.eq(name)).unique();
    }

    public void addProduct(Product product){
        this.productDao.save(product);
    }

}
