package test.bwie.com.bawaymail.view.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Html;
import android.view.View;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import test.bwie.com.bawaymail.R;
import test.bwie.com.bawaymail.model.bean.AddCartBean;
import test.bwie.com.bawaymail.model.bean.BuyNowBean;
import test.bwie.com.bawaymail.model.bean.ClassBean;
import test.bwie.com.bawaymail.model.bean.GoodsDetailBean;
import test.bwie.com.bawaymail.model.bean.OrderBean;
import test.bwie.com.bawaymail.model.bean.PayDataBean;
import test.bwie.com.bawaymail.model.bean.PayMentInfo;
import test.bwie.com.bawaymail.model.bean.PredepositBean;
import test.bwie.com.bawaymail.model.bean.ShopDetailBean;
import test.bwie.com.bawaymail.model.bean.ShopItemBean;
import test.bwie.com.bawaymail.model.bean.TypeBean;
import test.bwie.com.bawaymail.model.utils.ActivityUtil;
import test.bwie.com.bawaymail.model.utils.Constant;
import test.bwie.com.bawaymail.model.utils.DialogUtil;
import test.bwie.com.bawaymail.model.utils.ToastUtil;
import test.bwie.com.bawaymail.presenter.TypePresenter;
import test.bwie.com.bawaymail.view.iview.TypeView;

public class PayDataActivity extends AppCompatActivity implements TypeView<ClassBean> {
    public static Activity mActivity;
    private ImageView leftImageView;
    private TextView titleTextView;
    private ImageView rightImageView;
    private TextView orderIdTextView;
    private TextView calcTextView;
    private TextView payListTextView;
    private RadioButton aliPayTextView;
    private RadioButton wxPayTextView;
    private RadioButton predepositView;
    private RadioGroup listRadioGroup;
    private TextView payTextView;
    private RelativeLayout mainRelativeLayout;
    private String mPay_sn;
    private String mMMUserKeyString;
    private TypePresenter mPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pay_data);
        mActivity=this;
        initView();
    }

    @Override
    protected void onResume() {
        super.onResume();
        initControl();
    }

    private void initControl() {
        mPresenter=new TypePresenter();
        mPresenter.attachView(this);
        Intent intent = getIntent();
        mPay_sn = intent.getStringExtra("pay_sn");
        //初始化参数
        titleTextView.setText("订单支付");
        aliPayTextView.setVisibility(View.GONE);
        wxPayTextView.setVisibility(View.GONE);
        predepositView.setVisibility(View.GONE);
        orderIdTextView.setText("编号:");
        orderIdTextView.append(mPay_sn);

        Map<String,Object> ajaxParams=new HashMap<>();
        ajaxParams.put("key", mMMUserKeyString);
        ajaxParams.put("pay_sn", mPay_sn);
        mPresenter.getOrderDataFromF(ajaxParams);
    }
    private void getPayList() {
        DialogUtil.progress(mActivity, "正在获取支持的支付方式");
        Map<String,Object>map=new HashMap<>();
        map.put("key",mMMUserKeyString);
        mPresenter.getPayInfoDataFromF(map);
    }
    private void initView() {
        mMMUserKeyString = Constant.mSharedPreferences.getString("userKeyString", "");
        leftImageView = (ImageView) findViewById(R.id.leftImageView);
        titleTextView = (TextView) findViewById(R.id.titleTextView);
        rightImageView = (ImageView) findViewById(R.id.rightImageView);
        orderIdTextView = (TextView) findViewById(R.id.orderIdTextView);
        calcTextView = (TextView) findViewById(R.id.calcTextView);
        payListTextView = (TextView) findViewById(R.id.payListTextView);
        aliPayTextView = (RadioButton) findViewById(R.id.aliPayTextView);
        wxPayTextView = (RadioButton) findViewById(R.id.wxPayTextView);
        predepositView = (RadioButton) findViewById(R.id.predepositView);
        listRadioGroup = (RadioGroup) findViewById(R.id.listRadioGroup);
        payTextView = (TextView) findViewById(R.id.payTextView);
        mainRelativeLayout = (RelativeLayout) findViewById(R.id.mainRelativeLayout);

        leftImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ActivityUtil.finish(mActivity);
            }
        });
        payTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Map<String,Object> map=new HashMap<String, Object>();
                map.put("key",mMMUserKeyString);
               map.put("pay_sn", mPay_sn);
                map.put("payment_code", "predeposit");
                mPresenter.getPayByPredeposit(map);

            }


        });
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

    }

    @Override
    public void getGoodsAddCartData(AddCartBean str) {

    }

    @Override
    public void getGoodsPreIdData(PayDataBean str) {

    }

    @Override
    public void getOrderData(OrderBean str) {
        OrderBean.DatasBean datas = str.getDatas();
        String payed_amount = datas.getPay_info().getPay_amount();
        String calc = "共 <font color='#FF5001'>" + payed_amount + "</font> 元";
        calcTextView.setText(Html.fromHtml(calc));
        ToastUtil.show(PayDataActivity.this,"获取订单信息成功");
        getPayList();
    }

    @Override
    public void getPayList(PayMentInfo st) {
        DialogUtil.cancel();
        List<String> payment_list = st.getDatas().getPayment_list();
        if (payment_list.contains("alipay")) {
            aliPayTextView.setChecked(true);
            aliPayTextView.setVisibility(View.VISIBLE);
        }
        if (payment_list.contains("wx")) {
            wxPayTextView.setVisibility(View.VISIBLE);
            if (aliPayTextView.getVisibility() == View.GONE) {
                wxPayTextView.setChecked(true);
            }
        }
        if (payment_list.contains("predeposit")) {
            predepositView.setVisibility(View.VISIBLE);
            if (aliPayTextView.getVisibility() == View.GONE) {
                predepositView.setChecked(true);
            }
        }


    }

    @Override
    public void getPredeposit(PredepositBean st) {
                String link = Constant.LINK_MOBILE_PAY + "&key=" + mMMUserKeyString + "&pay_sn=" + mPay_sn+ "&password=&rcb_pay=0&pd_pay=0&payment_code=predeposit";
                Intent intent = new Intent(mActivity, BrowserActivity.class);
                intent.putExtra("Link", link);
                ActivityUtil.start(mActivity, intent);
                ActivityUtil.finish(mActivity);
    }
}
