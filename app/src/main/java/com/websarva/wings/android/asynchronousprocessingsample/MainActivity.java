package com.websarva.wings.android.asynchronousprocessingsample;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.webkit.WebView;
import android.widget.TextView;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MainActivity extends AppCompatActivity {
    private SlowProcessClass spc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView textView = findViewById(R.id.result_1);

        spc = new SlowProcessClass(this);

        final Handler handler = new Handler();
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        executorService.execute(new Runnable() {
            @Override
            public void run() {
                String result = spc.ViewText();

                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        textView.setText(result);
                    }
                });
            }
        });

        WebView webView = findViewById(R.id.webview);

        webView.getSettings().setAllowFileAccess(false);
        webView.getSettings().setAllowFileAccessFromFileURLs(false);
        webView.getSettings().setAllowUniversalAccessFromFileURLs(false);
        webView.getSettings().setAllowContentAccess(false);

        webView.loadUrl("https://www.google.com/?hl=ja");
    }
}