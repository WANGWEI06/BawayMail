package test.bwie.com.bawaymail.view.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import test.bwie.com.bawaymail.R;
import test.bwie.com.bawaymail.model.bean.CartDataBean;
import test.bwie.com.bawaymail.model.bean.DelCartBean;
import test.bwie.com.bawaymail.presenter.CartPresenter;
import test.bwie.com.bawaymail.presenter.TypePresenter;
import test.bwie.com.bawaymail.view.adapter.ShopCartAdapter;
import test.bwie.com.bawaymail.view.iview.CartView;

import static test.bwie.com.bawaymail.view.fragment.CartFragment.mCartAdapter;

public class CartActivity extends AppCompatActivity implements CartView {

    private RecyclerView rlv_shopcart;
    private TextView tv_shopcart_addselect;
    private TextView tv_shopcart_totalprice;
    private TextView tv_shopcart_totalnum;
    private TextView tv_shopcart_submit;
    private LinearLayout ll_pay;
    private View emtryview;
    private RelativeLayout rl_shopcart_have;
    private ShopCartAdapter mShopCartAdapter;
    private TypePresenter mTypePresenter;
    private List<CartDataBean.DatasBean.CartListBean.GoodsBean> mGoodsBeanList;
    public static CartDataBean mCartDataBean;
    private CartPresenter mPresenter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);
        initView();
        initData();
    }

    private void initData() {
        mPresenter = new CartPresenter();
        mPresenter.attachView(this);
        rlv_shopcart.setLayoutManager(new LinearLayoutManager(this));
//        mShopCartAdapter = new ShopCartAdapter(this,mAllOrderList);
    }

    private void initView() {
        rlv_shopcart = (RecyclerView) findViewById(R.id.rlv_shopcart);
        tv_shopcart_addselect = (TextView) findViewById(R.id.tv_shopcart_addselect);
        tv_shopcart_totalprice = (TextView) findViewById(R.id.tv_shopcart_totalprice);
        tv_shopcart_totalnum = (TextView) findViewById(R.id.tv_shopcart_totalnum);
        tv_shopcart_submit = (TextView) findViewById(R.id.tv_shopcart_submit);
        ll_pay = (LinearLayout) findViewById(R.id.ll_pay);
        emtryview = (View) findViewById(R.id.emtryview);
        rl_shopcart_have = (RelativeLayout) findViewById(R.id.rl_shopcart_have);


    }

    @Override
    public void getCartListData(CartDataBean str) {
        mCartDataBean = str;
        if (str.getDatas().getCart_list().size() != 0) {
            mGoodsBeanList = str.getDatas().getCart_list().get(0).getGoods();
            mCartAdapter.setData(mGoodsBeanList);
            mCartAdapter.notifyDataSetChanged();
        }
    }

    @Override
    public void getCartDelData(DelCartBean str) {

    }
}
