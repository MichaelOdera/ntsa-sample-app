package com.example.drawers;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;

import java.util.Objects;

import butterknife.BindView;
import butterknife.ButterKnife;

import static android.content.Intent.EXTRA_TEXT;

public class MainActivity extends AppCompatActivity {

    private ActionBarDrawerToggle mToggle;

    @BindView(R.id.activity_main) DrawerLayout mDrawerLayout;
    @BindView(R.id.nv) NavigationView mNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        mToggle = new ActionBarDrawerToggle(this, mDrawerLayout, R.string.Open, R.string.Close);

        mDrawerLayout.addDrawerListener(mToggle);
        mToggle.syncState();

        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);

        mNavigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int id = item.getItemId();
                switch(id)
                {
                    case R.id.share:
                        Toast.makeText(MainActivity.this, "Share",Toast.LENGTH_SHORT).show();
                        Intent sendIntent = new Intent();
                        sendIntent.setAction(Intent.ACTION_SEND);
                        sendIntent.putExtra(EXTRA_TEXT,
                                "Hey check out ntsa at: https://play.google.com/store/apps/details?id=ntsa.sebastian.com.ntsaenforcementmodule.application&hl=en" + BuildConfig.APPLICATION_ID);
                        sendIntent.setType("text/plain");
                        startActivity(sendIntent);
                        break;

                    case R.id.rate:
                        Toast.makeText(MainActivity.this, "Rate", Toast.LENGTH_SHORT).show();
                        String url = "https://play.google.com/store/apps/details?id=ntsa.sebastian.com.ntsaenforcementmodule.application&hl=en";
                        Intent intent = new Intent(Intent.ACTION_VIEW);
                        intent.setData(Uri.parse(url));
                        startActivity(intent);
                        break;

                    default:
                        return true;
                }
                return true;
            }
        });

    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if(mToggle.onOptionsItemSelected(item))
            return true;

        return super.onOptionsItemSelected(item);
    }
}
