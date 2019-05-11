package com.bawei.frag;

import android.content.Intent;
import android.net.Uri;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.bawei.Main2Activity;
import com.bawei.R;
import com.bawei.base.BaseFragment;
import com.bumptech.glide.Glide;

/*
 *@Auther:李伯康
 *@Date: 20190507
 *@Description:我的页面
 * */public class Frag02 extends BaseFragment {

    private ImageView img;
    private Button button01;
    private Button button02;

    //视图
    @Override
    public int bindLayout() {
        return R.layout.frag02;
    }
    //控件
    @Override
    public void bindView() {
        img = getView().findViewById(R.id.img);
        button01 = getView().findViewById(R.id.button01);
        button02 = getView().findViewById(R.id.button02);

    }
    //数据
    @Override
    public void bindData() {

    }
    //监听
    @Override
    public void bindEvent() {
        //图片点击事件
        img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_PICK);
                intent.setType("image/*");
                startActivityForResult(intent,0);
            }
        });
        //button01点击事件
        button01.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), Main2Activity.class);
                startActivity(intent);
            }
        });
        //button02点击事件
        button02.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Toast.makeText(getActivity(),"20190507",Toast.LENGTH_LONG).show();
            }
        });
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 0 && resultCode == -1){
            Uri data1 = data.getData();
            Glide.with(getActivity()).load(data1).into(img);
        }
    }
}
