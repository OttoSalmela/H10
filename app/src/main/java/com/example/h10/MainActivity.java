package com.example.h10;

import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.ListIterator;

public class MainActivity extends AppCompatActivity {

    EditText url;
    WebView web;
    ArrayList<String> history = new ArrayList<String>();
    ListIterator litr = history.listIterator();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        web = findViewById(R.id.webView);
        web.setWebViewClient(new WebViewClient());
        web.getSettings().setJavaScriptEnabled(true);
        web.loadUrl("https://www.google.fi");
    }

    public void goToSite(View v) {
        url = findViewById(R.id.editTextTextURL);
        if (url.getText().toString().equals("index.html")){
            web.loadUrl("file:///android_asset/index.html");
        }
        else {
            web.loadUrl("https://" + url.getText().toString());
        }
    }

    public void reload(View v){
        web.reload();
    }

    public void shoutOut(View v){
        web.evaluateJavascript("javascript:shoutOut()", null);
    }

    public void initialize(View v){
        web.evaluateJavascript("javascript:initialize()", null);
    }

    public void edellinen(View v) {
        if (web.canGoBack()) {
            web.goBack();
        }
    }

    public void seuraava(View v) {
        if (web.canGoForward(){
            web.goForward();
        }
    }
}