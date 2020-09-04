package com.example.smssender;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private EditText num;
    private EditText txt;
    private Button btn;
    private MainActivity instance;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        num = (EditText)findViewById(R.id.num);
        txt = (EditText)findViewById(R.id.text);
        btn = (Button)findViewById(R.id.btnSend);
        instance = this;

        btn.setOnClickListener(new Button.OnClickListener(){
            public void onClick(View v){
                if (ContextCompat.checkSelfPermission(instance, Manifest.permission.SEND_SMS) == PackageManager.PERMISSION_GRANTED) {
                    SmsManager.getDefault().sendTextMessage(num.getText().toString(), null,
                            txt.getText().toString(), null, null);
                }
            }
        });
    }
}