package com.niu.myapp.actcomwifrag.activity;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;



public abstract class BaseActivity extends FragmentActivity {

    /**
     * 为fragment设置functions，具体实现子类来做
     * @param fragmentId
     */
    public void setFunctionsForFragment(int fragmentId){}


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();

    }

    @Override
    protected void onResume() {
        super.onResume();

    }

    @Override
    protected void onStop() {
        super.onStop();
    }




}
