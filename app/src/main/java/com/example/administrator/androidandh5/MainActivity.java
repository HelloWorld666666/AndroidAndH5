package com.example.administrator.androidandh5;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn = (Button) findViewById(R.id.btn_java_and_js);
        btn.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if(view == btn){
            Intent intent = new Intent(MainActivity.this,Js.class);
            startActivity(intent);
        }
    }
}
