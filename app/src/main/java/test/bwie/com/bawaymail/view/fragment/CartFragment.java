package test.bwie.com.bawaymail.view.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.google.gson.Gson;

import java.util.List;

import test.bwie.com.bawaymail.R;
import test.bwie.com.bawaymail.model.bean.AddCartBean;
import test.bwie.com.bawaymail.model.bean.BuyNowBean;
import test.bwie.com.bawaymail.model.bean.CartDataBean;
import test.bwie.com.bawaymail.model.bean.ClassBean;
import test.bwie.com.bawaymail.model.bean.DelCartBean;
import test.bwie.com.bawaymail.model.bean.GoodsDetailBean;
import test.bwie.com.bawaymail.model.bean.OrderBean;
import test.bwie.com.bawaymail.model.bean.PayDataBean;
import test.bwie.com.bawaymail.model.bean.PayMentInfo;
import test.bwie.com.bawaymail.model.bean.PredepositBean;
import test.bwie.com.bawaymail.model.bean.ShopDetailBean;
import test.bwie.com.bawaymail.model.bean.ShopItemBean;
import test.bwie.com.bawaymail.model.bean.TypeBean;
import test.bwie.com.bawaymail.model.utils.Constant;
import test.bwie.com.bawaymail.model.utils.ToastUtil;
import test.bwie.com.bawaymail.presenter.CartPresenter;
import test.bwie.com.bawaymail.presenter.TypePresenter;
import test.bwie.com.bawaymail.view.activity.BuySetupActivity;
import test.bwie.com.bawaymail.view.adapter.CartAdapter;
import test.bwie.com.bawaymail.view.iview.CartView;
import test.bwie.com.bawaymail.view.iview.TypeView;


public class CartFragment extends Fragment implements View.OnClickListener, CartView<ClassBean>,TypeView {

    private TextView titleTextView;
    private TextView cart_unlogin;
    private RecyclerView cart_rlv;
    private SwipeRefreshLayout cart_swipe;
    private CartPresenter mPresenter;
    private Handler mHandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what) {
                case 1:
                    cart_swipe.setRefreshing(false);
                    break;
                default:
                    break;
            }
        }
    };
    public static CartAdapter mCartAdapter;
    private String mUserKeyString;
    public static TextView calcTextView;
    public static TextView buyTextView;
    public static CartDataBean mCartDataBean;
    private View mView;
    private TextView cart_empty;
    private TypePresenter mTypePresenter;
    private List<CartDataBean.DatasBean.CartListBean.GoodsBean> mGoodsBeanList;
    private String mCartId;
    private String mStoreId;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mView = inflater.inflate(R.layout.fragment_cart, null);
        initView(mView);
        return mView;
    }


    @Override
    public void onResume() {
        super.onResume();
        initControl();
    }

    private void initControl() {
        mPresenter = new CartPresenter();
        mPresenter.attachView(this);
        mTypePresenter = new TypePresenter();
        mTypePresenter.attachView(this);
        mCartAdapter = new CartAdapter(getActivity());
        mCartAdapter.setHomePresenter(mPresenter);
        cart_rlv.setAdapter(mCartAdapter);

        mUserKeyString = Constant.mSharedPreferences.getString("userKeyString", "");
        boolean user_login = Constant.mSharedPreferences.getBoolean("User_Login", false);
        if (user_login) {
            mPresenter.getCartListDataFromF(mUserKeyString);
            cart_unlogin.setVisibility(View.GONE);
            cart_swipe.setVisibility(View.VISIBLE);
            calcTextView.setVisibility(View.VISIBLE);
            buyTextView.setVisibility(View.VISIBLE);

        } else {
            cart_unlogin.setVisibility(View.VISIBLE);
            cart_swipe.setVisibility(View.GONE);
            cart_empty.setVisibility(View.GONE);
            buyTextView.setVisibility(View.GONE);
            calcTextView.setVisibility(View.GONE);
        }

    }

    private void initView(View view) {
        titleTextView = (TextView) view.findViewById(R.id.titleTextView);
        cart_unlogin = (TextView) view.findViewById(R.id.cart_unlogin);

        cart_rlv = (RecyclerView) view.findViewById(R.id.cart_rlv);
        cart_rlv.setOnClickListener(this);
        cart_swipe = (SwipeRefreshLayout) view.findViewById(R.id.cart_swipe);
        cart_swipe.setOnClickListener(this);
        calcTextView = (TextView) view.findViewById(R.id.calcTextView);
        calcTextView.setOnClickListener(this);
        buyTextView = (TextView) view.findViewById(R.id.buyTextView);
        buyTextView.setOnClickListener(this);

        cart_rlv.addItemDecoration(new DividerItemDecoration(
                getActivity(), DividerItemDecoration.VERTICAL));
        cart_rlv.setLayoutManager(new LinearLayoutManager(getActivity()));

        cart_swipe.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                mPresenter.getCartListDataFromF(mUserKeyString);
                mHandler.sendEmptyMessageDelayed(1, 3000);
            }
        });

        cart_empty = (TextView) mView.findViewById(R.id.cart_empty);
        cart_empty.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
       switch (v.getId()){
           case R.id.buyTextView:
//               String mCart_id = mGoodsBeanList.get(0).getGoods_id() + "|" + mGoodsBeanList.get(0).getGoods_num();

               String cart_id = "";
               String store_id = "";
               for (int i = 0; i < mGoodsBeanList.size(); i++) {
                   String temp = mGoodsBeanList.get(i).getCart_id() + "|" + mGoodsBeanList.get(i).getGoods_num() + ",";
                   cart_id += temp;
                   temp = mGoodsBeanList.get(i).getStore_id() + "|";
                   store_id += temp;
               }
               mStoreId = store_id.substring(0, store_id.lastIndexOf("|"));
               mCartId = cart_id.substring(0, cart_id.lastIndexOf(","));
               mTypePresenter.getGoodsBuyNowFromF(BuyNowBean.class,mUserKeyString, mCartId,"1");
               break;
       }
    }

    @Override
    public void getCartListData(CartDataBean str) {
        mCartDataBean = str;
        if (str.getDatas().getCart_list().size() != 0) {
            mGoodsBeanList= str.getDatas().getCart_list().get(0).getGoods();
            mCartAdapter.setData(mGoodsBeanList);
            mCartAdapter.notifyDataSetChanged();
            cart_rlv.setVisibility(View.VISIBLE);
            cart_empty.setVisibility(View.GONE);
            String total = "共 <font color='#FF5001'>" + str.getDatas().getCart_count() + "</font> 件商品，";
            total += "共 <font color='#FF5001'>" + str.getDatas().getSum() + "</font> 元";
            calcTextView.setText(Html.fromHtml(total));
        } else {
            mCartAdapter.setData(null);
            mCartAdapter.notifyDataSetChanged();
            cart_rlv.setVisibility(View.GONE);
            cart_empty.setVisibility(View.VISIBLE);
        }
    }

    @Override
    public void getCartDelData(DelCartBean str) {
        ToastUtil.show(getActivity(), "删除成功");
        mPresenter.getCartListDataFromF(mUserKeyString);
    }


    @Override
    public void getDataSuc(TypeBean t) {

    }

    @Override
    public void getDataErr(String str, int code) {

    }

    @Override
    public void getShopDetailSuc(ShopDetailBean t) {

    }

    @Override
    public void getShopSuc(ShopDetailBean t) {

    }

    @Override
    public void getItemData(ShopItemBean t) {

    }

    @Override
    public void getGoodsDetail(GoodsDetailBean t) {

    }

    @Override
    public void getGoodsItduData(String str) {

    }

    @Override
    public void getGoodsBuyNowData(BuyNowBean str) {
        Intent intent = new Intent(getActivity(),BuySetupActivity.class);
        Gson gson=new Gson();
        String json = gson.toJson(str);
//        Log.i("21222", json);
        intent.putExtra("BuyNowBean", json);
        intent.putExtra("cart_id", mCartId);
        intent.putExtra("ifcart", "1");
        //mStoreId = str.getDatas().getStore_cart_list().get_$1().getGoods_list().get(0).getStore_id();
        intent.putExtra("store_id", mStoreId);
        getActivity().startActivity(intent);
    }

    @Override
    public void getGoodsAddCartData(AddCartBean str) {

    }

    @Override
    public void getGoodsPreIdData(PayDataBean str) {

    }

    @Override
    public void getOrderData(OrderBean str) {

    }

    @Override
    public void getPayList(PayMentInfo st) {

    }

    @Override
    public void getPredeposit(PredepositBean st) {

    }
}
