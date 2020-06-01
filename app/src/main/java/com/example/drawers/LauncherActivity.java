package com.example.drawers;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class LauncherActivity extends AppCompatActivity implements View.OnClickListener{

    @BindView(R.id.launcherButton)
    Button mLauncherButton;
    @BindView(R.id.kplcTextView)
    TextView mTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_launcher);

        ButterKnife.bind(this);

        mLauncherButton.setOnClickListener(this);
        mTextView.setOnClickListener(this);


    }

    @Override
    public void onClick(View view) {
        if(view == mLauncherButton) {
            Intent launcherIntent = new Intent(LauncherActivity.this, MainActivity.class);
            startActivity(launcherIntent);
        }
        if(view == mTextView) {
            Intent kplcIntent = new Intent(LauncherActivity.this, KplcActivity.class);
            startActivity(kplcIntent);
        }

    }
}
