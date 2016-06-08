package com.example.cgx_pc.day18_viewpage;

import android.app.Fragment;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.common.api.GoogleApiClient;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ViewPager vp;
    private ArrayList<View> views;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        //加载布局添加到list中
        vp = (ViewPager) findViewById(R.id.vp);
        View view1 = getLayoutInflater().inflate(R.layout.viewpage1, null);
        View view2 = getLayoutInflater().inflate(R.layout.viewpage2, null);
        View view3 = getLayoutInflater().inflate(R.layout.viewpage3, null);
        View view4 = getLayoutInflater().inflate(R.layout.viewpage5, null);
        //为最后一页的button设置监听跳转
        Button btn = (Button) view4.findViewById(R.id.button);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ContentActivity.class);
                startActivity(intent);
                finish();
            }
        });

//        btn.setCompoundDrawablesWithIntrinsicBounds();设置上下左右图片
//        Resources res = this.getResources();
//        Drawable myImage = res.getDrawable(R.mipmap.skin_tab_icon_contact_selected);
//        btn.setCompoundDrawablesWithIntrinsicBounds(null, myImage, null, null);



        views = new ArrayList<>();
        views.add(view1);
        views.add(view2);
        views.add(view3);
        views.add(view4);

        vp.setAdapter(new PagerAdapter() {
            //重写必须的四个方法

            @Override
            public int getCount() {
                return views.size();
            }

            @Override
            public void destroyItem(ViewGroup container, int position, Object object) {
                ((ViewPager) container).removeView(views.get(position));
            }

            @Override
            public boolean isViewFromObject(View view, Object object) {
                return view == object;
            }

            @Override
            public Object instantiateItem(ViewGroup container, int position) {
                ((ViewPager) container).addView(views.get(position));

                return views.get(position);
            }
        });
    }




}
