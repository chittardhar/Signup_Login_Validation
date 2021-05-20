package com.example.signuplogin;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager2.widget.ViewPager2;

import android.app.TaskStackBuilder;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Adapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.tabs.TabLayout;

import org.jetbrains.annotations.NotNull;

public class MainActivity extends AppCompatActivity {

    public class MyFragmentAdapter extends FragmentPagerAdapter{
        Context myContext;
        int totalTab;
        public MyFragmentAdapter(@NonNull @NotNull Context context, FragmentManager fm, int totalTab) {
            super(fm, totalTab);
            myContext = context;
            this.totalTab = totalTab;
        }

        @NonNull
        @NotNull
        @Override
        public Fragment getItem(int position) {
            Signup signup;
            switch (position){
                case 0:
                    return new Signup();
                case 1:
                    return new Signin();
                default:
                    return null;
            }
        }

        @Override
        public int getCount() {
            return totalTab;
        }
    }

    EditText editTextEmail,editTextPassword;
    TabLayout tabLayout;
    ViewPager container;
    MyFragmentAdapter fragmentAdapter;
    Button buttonSubmit ;
    Context context;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_main);
        init();
    }

    void init(){
        context = MainActivity.this;
        tabLayout = findViewById(R.id.tab_layout);
        container = findViewById(R.id.page_container);
        buttonSubmit = findViewById(R.id.buttonSignIn);
        tabLayout.addTab(tabLayout.newTab().setText("Signup"));
        tabLayout.addTab(tabLayout.newTab().setText("Signin"));
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);
        fragmentAdapter = new MyFragmentAdapter(this,getSupportFragmentManager(),tabLayout.getTabCount());
        container.setAdapter(fragmentAdapter);
        container.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        tabLayout.getTabAt(0).select();
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                container.setCurrentItem(tab.getPosition());
            }
            @Override
            public void onTabUnselected(TabLayout.Tab tab) {}

            @Override
            public void onTabReselected(TabLayout.Tab tab) {}
        });
    }
}