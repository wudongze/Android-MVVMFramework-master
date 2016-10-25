package com.bigkoo.mvvmframeworkdemo.activity;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.bigkoo.mvvmframeworkdemo.R;
import com.bigkoo.mvvmframeworkdemo.databinding.ActivityMain2Binding;
import com.bigkoo.mvvmframeworkdemo.manager.ImageLoaderManager;
import com.bigkoo.mvvmframeworkdemo.network.HttpServiceGenerator;

public class MainActivity extends AppCompatActivity {
    public boolean flag = false;
    private ActivityMain2Binding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main2);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main2);
        binding.setMyTest(this);
        binding.setFlag(flag);
        //懒得写application类，你们别像我这么懒哦
        HttpServiceGenerator.context = getApplicationContext();
        ImageLoaderManager.getInstance().init(getApplicationContext());
    }

    public void onClick(View v) {
        Intent intent = new Intent();
        switch (v.getId()) {
            case R.id.btTicket:
                intent.setClass(this, TicketListActivity.class);
                break;
        }
        startActivity(intent);
    }

    public void test(View view) {
        startActivity(new Intent(this, TicketListActivity.class));
    }
    public void goneBtn(View view){
        flag = false;
    }
    public void getBtn(View view){
        flag = true;
    }
}
