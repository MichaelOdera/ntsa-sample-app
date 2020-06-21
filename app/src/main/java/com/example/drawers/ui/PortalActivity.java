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

public class PortalActivity extends AppCompatActivity {
    @BindView(R.id.portalWebView) WebView mPortalWebView;
    @BindView(R.id.progressBar) ProgressBar mProgressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_portal);
        ButterKnife.bind(this);
        mPortalWebView.setWebViewClient(new WebViewClient());
        mPortalWebView.loadUrl("https://tims.ntsa.go.ke/login_csp.jsp");
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
