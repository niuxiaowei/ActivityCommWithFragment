package com.niu.myapp.actcomwifrag.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.widget.Toast;

import com.niu.myapp.actcomwifrag.R;
import com.niu.myapp.actcomwifrag.fragment.BaseFragment;
import com.niu.myapp.actcomwifrag.fragment.MainFragment;
import com.niu.myapp.actcomwifrag.util.Functions;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by niuxiaowei on 2016/1/25.
 */
public class MainActivity extends BaseActivity {

    @Override
    public void setFunctionsForFragment(int fragmentId) {
        super.setFunctionsForFragment(fragmentId);
        switch (fragmentId) {
            case R.id.fragment_main:
                FragmentManager fm = getSupportFragmentManager();
                BaseFragment fragment = (BaseFragment) fm.findFragmentById(fragmentId);
                fragment.setFunctions(new Functions().addFunction(new Functions.FunctionNoParamAndResult(MainFragment.FUNCTION_NO_PARAM_NO_RESULT) {
                    @Override
                    public void function() {
                        Toast.makeText(MainActivity.this, "成功调用无参无返回值方法", Toast.LENGTH_LONG).show();
                    }
                }).addFunction(new Functions.FunctionWithResult<String>(MainFragment.FUNCTION_NO_PARAM_HAS_RESULT) {
                    @Override
                    public String function() {
                        Toast.makeText(MainActivity.this, "成功调用无参有返回值方法", Toast.LENGTH_LONG).show();
                        return "恭喜你，调我成功！";
                    }
                }).addFunction(new Functions.FunctionWithParam<Integer>(MainFragment.FUNCTION_HAS_PARAM_NO_RESULT) {
                    @Override
                    public void function(Integer o) {
                        Toast.makeText(MainActivity.this, "成功调用有参无返回值方法 参数值=" + o, Toast.LENGTH_LONG).show();
                    }
                }).addFunction(new Functions.FunctionWithParamAndResult<List, Integer>(MainFragment.EVENT_HAS_PARAM_HAS_RESULT) {

                    @Override
                    public List function(Integer data) {
                        Toast.makeText(MainActivity.this, "成功调用有参有返回值方法 参数值=" + data, Toast.LENGTH_LONG).show();
                        List<String> result = new ArrayList<String>();
                        result.add("1");
                        result.add("2");
                        result.add("3");
                        return result;
                    }
                }).addFunction(new Functions.FunctionWithParam<Functions.FunctionParams>(MainFragment.FUNCTION_HAS_MORE_PARAM) {

                    @Override
                    public void function(Functions.FunctionParams functionParams) {
                        if (functionParams != null) {

                            Toast.makeText(MainActivity.this, "成功调用多个参数的方法 参数值=" + functionParams.getString()+" 参数1="+functionParams.getString()+" 参数2="+functionParams.getInt(), Toast.LENGTH_LONG).show();
                        }
                    }
                }).addFunction(new Functions.FunctionWithParam<Bundle>(MainFragment.FUNCTION_HAS_MORE_PARAM_Bundle) {

                    @Override
                    public void function(Bundle bundle) {
                        if(bundle != null){
                            Toast.makeText(MainActivity.this, "成功调用多个参数的方法 参数值=" + bundle.getString("p")+" 参数1="+bundle.getString("p1")+" 参数2="+bundle.getInt("p2"), Toast.LENGTH_LONG).show();

                        }
                    }
                }));
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_layout);
    }
}
