package com.example.ss.coffeeshop.Activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.example.ss.coffeeshop.App;
import com.example.ss.coffeeshop.R;
import com.example.ss.coffeeshop.Services.LoggerInFile;

public class LogActivity extends AppCompatActivity {
    LoggerInFile loggerInFile;
    TextView allLog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log);
        this.loggerInFile = ((App) getApplication()).getLoggerInFile();
        this.allLog = (TextView) findViewById(R.id.allLog);
        allLog.setText(loggerInFile.readLogFile());
    }
}
