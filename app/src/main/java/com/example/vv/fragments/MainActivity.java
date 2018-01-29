package com.example.vv.fragments;

import android.content.res.Configuration;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity{
    TitleFragment titles=new TitleFragment();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if(getResources().getConfiguration().orientation== Configuration.ORIENTATION_LANDSCAPE){
            getSupportFragmentManager().beginTransaction().add(R.id.left,titles).add(R.id.right1,new WebFragment()).commit();
        }else getSupportFragmentManager().beginTransaction().add(R.id.main,titles).commit();
    }
    void show(String url){
        WebFragment web=new WebFragment();
        Bundle bundle=new Bundle();
        bundle.putString("url",url);
        web.setArguments(bundle);
        if(getResources().getConfiguration().orientation== Configuration.ORIENTATION_LANDSCAPE){
            getSupportFragmentManager().beginTransaction().replace(R.id.right1,web).commit();
        }else{
            getSupportFragmentManager().beginTransaction().replace(R.id.main,web).commit();
        }
    }
}


