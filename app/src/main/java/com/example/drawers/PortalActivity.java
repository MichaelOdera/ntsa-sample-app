package com.example.drawers;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.webkit.WebView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class PortalActivity extends AppCompatActivity {
    @BindView(R.id.portalWebView)
    WebView mPortalWebView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_portal);
        ButterKnife.bind(this);

        mPortalWebView.loadUrl("https://tims.ntsa.go.ke/login_csp.jsp");
    }
}
