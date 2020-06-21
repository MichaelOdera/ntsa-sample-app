package com.example.drawers.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;

import com.example.drawers.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class KplcActivity extends AppCompatActivity {
    @BindView(R.id.kplcWebView) WebView mKplcWebView;
    @BindView(R.id.progressBar) ProgressBar mProgressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kplc);
        ButterKnife.bind(this);

        mKplcWebView.setWebViewClient(new WebViewClient());
        mKplcWebView.loadUrl("https://kplc.co.ke/category/view/50/power-interruptions");
    }
    public class WebViewClient extends android.webkit.WebViewClient{
        @Override
        public void onPageStarted(WebView view, String url, Bitmap favicon) {
            super.onPageStarted(view, url, favicon);
        }
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            view.loadUrl(url);
            return true;
        }
        @Override
        public void onPageFinished(WebView view, String url) {
            super.onPageFinished(view, url);
            mProgressBar.setVisibility(View.GONE);
        }
    }
}
