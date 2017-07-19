package test.bwie.com.bawaymail.view.activity;

import android.annotation.TargetApi;
import android.app.Activity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import test.bwie.com.bawaymail.R;
import test.bwie.com.bawaymail.model.utils.ActivityUtil;
import test.bwie.com.bawaymail.model.utils.Android;
import test.bwie.com.bawaymail.model.utils.ToastUtil;
import test.bwie.com.bawaymail.view.autoview.YoKeyWebView;

public class BrowserActivity extends AppCompatActivity {

    public static Activity mActivity;

    private String linkString;

    private ImageView leftImageView;
    private TextView titleTextView;
    private ImageView rightImageView;

    private YoKeyWebView mWebView;
    private ProgressBar mProgressBar;
    private ImageView backImageView;
    private ImageView nextImageView;
    private ImageView refreshImageView;
    private ImageView topImageView;
    private ImageView shareImageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_browser);
        initView();
        createEvent();
    }

    private void initView() {

        mActivity = this;

        linkString = mActivity.getIntent().getStringExtra("Link");
        if (!linkString.contains("http://")) {
            linkString = "http://" + linkString;
        }
        //实例化控件
        leftImageView = (ImageView) findViewById(R.id.leftImageView);
        titleTextView = (TextView) findViewById(R.id.titleTextView);
        rightImageView = (ImageView) findViewById(R.id.rightImageView);

        mWebView = (YoKeyWebView) findViewById(R.id.mainWebView);
        mProgressBar = (ProgressBar) findViewById(R.id.mainProgressBar);
        backImageView = (ImageView) findViewById(R.id.backImageView);
        nextImageView = (ImageView) findViewById(R.id.nextImageView);
        refreshImageView = (ImageView) findViewById(R.id.refreshImageView);
        topImageView = (ImageView) findViewById(R.id.topImageView);
        shareImageView = (ImageView) findViewById(R.id.shareImageView);

        //初始化赋值
        titleTextView.setText("加载中...");
        rightImageView.setVisibility(View.GONE);

        Android.setWebView(mWebView);
        mWebView.loadUrl(linkString);

    }

    private void createEvent() {

        leftImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ActivityUtil.finish(mActivity);
            }
        });

        titleTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        rightImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        backImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mWebView.goBack();
            }
        });

        nextImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mWebView.goForward();
            }
        });

        refreshImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mWebView.loadUrl(linkString);
            }
        });

        topImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            @TargetApi(19)
            public void onClick(View v) {
                try {
                    mWebView.setScrollY(0);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

        shareImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ToastUtil.show(mActivity, "暂不支持");
            }
        });

        mWebView.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                linkString = url;
                view.loadUrl(url);
                return super.shouldOverrideUrlLoading(view, url);
            }
        });

        mWebView.setWebChromeClient(new WebChromeClient() {
            @Override
            public void onProgressChanged(WebView view, int newProgress) {
                if (newProgress == 100) {
                    mProgressBar.setVisibility(View.GONE);
                } else {
                    if (mProgressBar.getVisibility() == View.GONE) {
                        mProgressBar.setVisibility(View.VISIBLE);
                    }
                    mProgressBar.setProgress(newProgress);
                }
                super.onProgressChanged(view, newProgress);
            }

            @Override
            public void onReceivedTitle(WebView view, String title) {
                titleTextView.setText(title);
                super.onReceivedTitle(view, title);
            }
        });

    }
}
