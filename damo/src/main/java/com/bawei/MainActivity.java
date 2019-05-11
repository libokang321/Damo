package com.bawei;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

import com.bawei.base.BaseActivity;

public class MainActivity extends BaseActivity {

    private Button button_dl;
    private Button button_zc;
    private EditText user;
    private EditText password;
    private CheckBox checkBox;

    @Override
    public int bindLayout() {
        return R.layout.activity_main;
    }

    @Override
    public void bindView() {
        button_dl = findViewById(R.id.button_dl);
        button_zc = findViewById(R.id.button_zc);
        user = findViewById(R.id.edit1);
        password = findViewById(R.id.edit2);
        checkBox = findViewById(R.id.checkbox);
    }

    @Override
    public void bindData() {

    }

    @Override
    public void bindEvent() {

    }
}
