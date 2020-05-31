package com.example.drawers;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.webkit.WebView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class EcitizenActivity extends AppCompatActivity {

    @BindView(R.id.eCitizenWebView) WebView mCitizenWebView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ecitizen);
        ButterKnife.bind(this);

        mCitizenWebView.loadUrl("https://ntsa.ecitizen.go.ke/");
    }
}
