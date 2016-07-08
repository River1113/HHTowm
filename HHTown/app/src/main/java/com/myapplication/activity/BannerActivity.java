package com.myapplication.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import android.widget.TextView;

import com.myapplication.R;

public class BannerActivity extends AppCompatActivity {
    private TextView title;
    private TextView textView;
    private WebView webView;
    private ImageView imageBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_banner);
        title = (TextView) findViewById(R.id.title_banner);
        textView = (TextView) findViewById(R.id.text_banner);
        webView = (WebView) findViewById(R.id.webView_banner);
        imageBack = (ImageView) findViewById(R.id.imageView_back_banner);
        Intent intent = getIntent();
        String url = intent.getStringExtra("url");
        String name = intent.getStringExtra("name");
        if (!url.equals("")) {
            title.setText(name);
            textView.setVisibility(View.INVISIBLE);
            webView.setWebViewClient(new WebViewClient());
            webView.loadUrl(url);
        }

        imageBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
}
