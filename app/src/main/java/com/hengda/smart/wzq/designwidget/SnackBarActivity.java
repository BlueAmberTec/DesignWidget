package com.hengda.smart.wzq.designwidget;

import android.os.Bundle;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class SnackBarActivity extends AppCompatActivity {

    @BindView(R.id.btn_normal)
    Button btnNormal;
    @BindView(R.id.btn_notify)
    Button btnNotify;
    @BindView(R.id.btn_tvcolor)
    Button btnTvcolor;
    @BindView(R.id.btn_click)
    Button btnClick;
    @BindView(R.id.btn_icon)
    Button btnIcon;
    @BindView(R.id.container)
    CoordinatorLayout container;
    //snackBar控件
    Snackbar snackbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_snackbar);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.btn_normal, R.id.btn_notify, R.id.btn_tvcolor, R.id.btn_click, R.id.btn_icon})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_normal:
                showNormalSnackBar();
                break;
            case R.id.btn_notify:
                showNotifiySnackBar();
                break;
            case R.id.btn_tvcolor:
                showMySnackBar();
                break;
            case R.id.btn_click:
                showClickSnackBar();
                break;
            case R.id.btn_icon:
                showIConSnackBar();
                break;
        }
    }

    /**
     * 最基本的用法的Toast的很相似
     * Snackbar.make(container, "最基本的SnackBar", Snackbar.LENGTH_SHORT).show();
     * Toast.makeText(context, "it is Toast", Toast.LENGTH_SHORT).show();
     * 二者都有三个参数，区别就在于第一个参数，其中Toast传入的是Context，而Snackbar传入的是View
     */

    public void showNormalSnackBar(){
        //最基本的用法的Toast的很相似
          Snackbar.make(container, "最基本的SnackBar", Snackbar.LENGTH_SHORT).show();
    }

    public void showNotifiySnackBar() {
        snackbar = Snackbar.make(container, "我是带有显示隐藏监听的SnackBar", Snackbar.LENGTH_SHORT);
        snackbar.setCallback(new Snackbar.Callback() {
            @Override
            public void onDismissed(Snackbar snackbar, int event) {
                super.onDismissed(snackbar, event);
                Toast.makeText(SnackBarActivity.this, "SnackBar隐藏", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onShown(Snackbar snackbar) {
                super.onShown(snackbar);
                Toast.makeText(SnackBarActivity.this, "SnackBar显示", Toast.LENGTH_SHORT).show();
            }
        });
        snackbar.show();
    }

    /**
     *  带自定义背景和字体的snackBar
     */
    public void showMySnackBar(){
        snackbar = Snackbar.make(container, "我是自定背景色和字体颜色的SnackBar", Snackbar.LENGTH_SHORT);
        //设置背景色
        snackbar.getView().setBackgroundColor(getResources().getColor(R.color.cheng1));
        ( (TextView)snackbar.getView().findViewById(R.id.snackbar_text)).setTextColor(getResources().getColor(R.color.bluelight1));
        snackbar.show();
    }


    /**
     *  带点击事件的snackBar
     */
    public void showClickSnackBar(){
        snackbar = Snackbar.make(container, "我是带有点击事件的SnackBar", Snackbar.LENGTH_SHORT);
        //设置背景色
        snackbar.getView().setBackgroundColor(getResources().getColor(R.color.cheng1));
        ((TextView)snackbar.getView().findViewById(R.id.snackbar_text)).setTextColor(getResources().getColor(R.color.graylight2));
        snackbar.setAction("显示HAHA", new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(SnackBarActivity.this,"HAHA",Toast.LENGTH_SHORT).show();
            }
        });
        snackbar.setActionTextColor(getResources().getColor(R.color.white));
        snackbar.show();
    }

    /**
     *  带有ICON的SnackBar
     */
    public void showIConSnackBar(){
        snackbar = Snackbar.make(container, "我是带有ICON的SnackBar", Snackbar.LENGTH_SHORT);
        //设置背景色
        snackbar.getView().setBackgroundColor(getResources().getColor(R.color.cheng1));
        ( (TextView)snackbar.getView().findViewById(R.id.snackbar_text)).setTextColor(getResources().getColor(R.color.graylight2));
        snackbar.setActionTextColor(getResources().getColor(R.color.white));
        snackbar.setAction("显示HAHA", new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(SnackBarActivity.this,"HAHA",Toast.LENGTH_SHORT).show();
            }
        });
        ImageView icon=new ImageView(SnackBarActivity.this);
        icon.setImageResource(R.mipmap.icon_position_o);
        //icon插入布局
        Snackbar.SnackbarLayout snackbarLayout = (Snackbar.SnackbarLayout)snackbar.getView();
        snackbarLayout.setGravity(Gravity.CENTER_VERTICAL);
        snackbarLayout.addView(icon,0);
        snackbar.show();
    }
}
