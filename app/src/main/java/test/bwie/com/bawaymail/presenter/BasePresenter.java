package test.bwie.com.bawaymail.presenter;

import android.content.Context;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

import test.bwie.com.bawaymail.R;
import test.bwie.com.bawaymail.view.iview.IView;

/**
 * @ Description:
 * @ Date:2017/6/9
 * @ Author:刘刚
 */

public class BasePresenter<T extends IView>  {
    private  T IView;

    public  T getIView(){
        return IView;
    }

    public void attachView(T IView) {
        this.IView = IView;
    }

    public void getImageFromServer(Context context, String uri, ImageView imageView){
        Glide.with(context).load(uri).placeholder(R.mipmap.ic_nav_cart_press).into(imageView);
    }
}
