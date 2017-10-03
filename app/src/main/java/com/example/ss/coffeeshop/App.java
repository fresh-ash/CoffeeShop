package com.example.ss.coffeeshop;

import android.app.Application;

import com.example.ss.coffeeshop.Entities.DaoMaster;
import com.example.ss.coffeeshop.Entities.DaoSession;
import com.example.ss.coffeeshop.Services.LoggerInFile;

/**
 * Created by ss on 01.10.17.
 */

public class App extends Application {

    private DaoSession daoSession;
    private LoggerInFile loggerInFile;

    @Override
    public void onCreate(){
        super.onCreate();
        this.daoSession = new DaoMaster(new DaoMaster.DevOpenHelper(this,"coffee.db").getWritableDb()).newSession();
        this.loggerInFile = new LoggerInFile("log.txt",this);
    }

    public DaoSession getDaoSession(){
        return this.daoSession;
    }

    public LoggerInFile getLoggerInFile(){
        return this.loggerInFile;
    }
}
