package com.example.ss.coffeeshop.Services.UIServices;

import android.content.Context;

import com.example.ss.coffeeshop.R;
import com.example.ss.coffeeshop.Services.LoggerInFile;

/**
 * Created by ss on 03.10.17.
 */

public class FormService {

    private LoggerInFile loggerInFile;
    private Context context;

    public FormService(LoggerInFile loggerInFile, Context context){
        this.loggerInFile = loggerInFile;
        this.context = context;
    }

    public boolean isStringOk(String str){
        str = str.trim();
        return str.matches("^[a-zA-Z0-9]+$");
    }

    public String getFromForm(String str) {

        if (this.isStringOk(str)) {
            return null;
        }
        else if(str.isEmpty()){
            str = context.getString(R.string.empty);
            loggerInFile.writeLogToFile(str);
            return str;
        }
        else {
            str = context.getString(R.string.badSymbol);
            loggerInFile.writeLogToFile(str);
            return str;
        }
    }

}
