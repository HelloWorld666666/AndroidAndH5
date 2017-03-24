package com.example.administrator.androidandh5;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.webkit.JavascriptInterface;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Js extends Activity {
    private EditText etNumber,etPassword;
    private WebView webView;
    private Button btnLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_js);

        etNumber = (EditText) findViewById(R.id.et_number);
        etPassword = (EditText) findViewById(R.id.et_password);
        btnLogin = (Button) findViewById(R.id.btn_login);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                login();
            }
        });
        initWebView();
    }

    //加载网页
    private void initWebView() {
        //初始化webview
        webView = new WebView(this);
        //获取webview设置
        WebSettings webSettins = webView.getSettings();
        //支持js
        webSettins.setJavaScriptEnabled(true);
        webView.addJavascriptInterface(new AndroidAndJsInterface(),"Android");
        //加载网页
//        webView.loadUrl("http://www.baidu.com");
        //加载本地
        webView.loadUrl("file:///android_asset/JavaAndJavaScriptCall.html");
        //显示webview
    }

    private void login() {
        //得到账号和密码
        String number = etNumber.getText().toString().trim();
        String password = etPassword.getText().toString().trim();
        //判断密码是否为空
        if(TextUtils.isEmpty(number)||TextUtils.isEmpty(password)){
            Toast.makeText(Js.this,"用户名和密码不能为空",Toast.LENGTH_SHORT).show();
        }else {
            login(number);
        }
    }

    private void login(String number) {
        webView.loadUrl("javascript:javaCallJs("+"’"+number+"'"+")");
        setContentView(webView);
    }

    class AndroidAndJsInterface{
        @JavascriptInterface
        public void showToast(){
            Toast.makeText(Js.this, "我被js调用", Toast.LENGTH_SHORT).show();
        }
    }
}
