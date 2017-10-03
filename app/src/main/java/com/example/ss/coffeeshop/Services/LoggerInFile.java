package com.example.ss.coffeeshop.Services;

import android.content.Context;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Calendar;

/**
 * Created by ss on 29.09.17.
 */

public class LoggerInFile {

    private String nameFile;
    private FileOutputStream outputStream;
    private InputStream inputStream;
    private Context context;

    public LoggerInFile(String nameFile, Context context){
        this.nameFile = nameFile;
        this.context = context;
    }

    public void writeLogToFile(String comment){
        if (!(new File(this.nameFile).exists())){
            File log = new File(this.context.getFilesDir(), nameFile);
        }

        Calendar date = Calendar.getInstance();
        try{
            this.outputStream = this.context.openFileOutput(nameFile, Context.MODE_PRIVATE | Context.MODE_APPEND);
            this.outputStream.write((comment + date.getTime() +"\n").getBytes());
            this.outputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String readLogFile(){
        String file = "";
        try {
            this.inputStream = this.context.openFileInput(this.nameFile);
            InputStreamReader streamReader = new InputStreamReader(inputStream);
            BufferedReader reader = new BufferedReader(streamReader);
            String line;
            while ((line=reader.readLine())!=null){
                file+=line + "\n";
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return file;
    }
}
