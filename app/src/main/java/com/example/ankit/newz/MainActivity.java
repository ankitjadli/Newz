package com.example.ankit.newz;

import android.content.Intent;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {

    private android.support.v7.widget.Toolbar mToolbar;
    private ViewPager mViewPager;
    private SectionsPagerAdapter mSectionPagerAdapter;
    private TabLayout mtablayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mToolbar = (android.support.v7.widget.Toolbar) findViewById(R.id.mainpagetoolbar);
        mViewPager=(ViewPager)findViewById(R.id.main_tab_pager);
        mSectionPagerAdapter=new SectionsPagerAdapter(getSupportFragmentManager());
        mViewPager.setAdapter(mSectionPagerAdapter);
        setSupportActionBar(mToolbar);
        getSupportActionBar().setTitle(" ");
        mtablayout=(TabLayout)findViewById(R.id.main_tabs);
        mtablayout.setupWithViewPager(mViewPager);


    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);

        getMenuInflater().inflate(R.menu.mainmenu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        super.onOptionsItemSelected(item);

        if (item.getItemId()==R.id.mainlogoutbutton)
        {
            FirebaseAuth.getInstance().signOut();
            Intent loggegout = new Intent(MainActivity.this,startapp.class);
            startActivity(loggegout);
            finish();
        }
        if(item.getItemId()==R.id.aboutapp)
        {
            Intent about_device = new Intent(MainActivity.this,aboutus.class);
            startActivity(about_device);
        }

        return true;
    }
}
