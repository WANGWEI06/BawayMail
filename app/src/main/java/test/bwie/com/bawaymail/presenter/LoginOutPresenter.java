package test.bwie.com.bawaymail.presenter;


import test.bwie.com.bawaymail.model.bean.LoginOutBean;
import test.bwie.com.bawaymail.model.utils.Constant;
import test.bwie.com.bawaymail.model.utils.HttpUtils;
import test.bwie.com.bawaymail.view.iview.LoginOutView;

/**
 * @类的用途：
 * @author: 刘刚
 * @date: 2017/6/10
 */

public class LoginOutPresenter extends BasePresenter<LoginOutView> {

    public  <T> void  getDataFromF(){
        HttpUtils.getLoginOutData(new HttpUtils.CallBackDataF<LoginOutBean>() {
            @Override
            public void callBackF(LoginOutBean homeBean) {

                if(homeBean.getCode()==200){

                    Constant.mSharedPreferencesEditor.putBoolean("User_Login", false);
                    Constant.mSharedPreferencesEditor.putString("User_Username", "");
                    Constant.mSharedPreferencesEditor.putString("User_Password", "");
                    Constant.mSharedPreferencesEditor.putString("userKeyString", "");
                    Constant.mSharedPreferencesEditor.apply();
                    getIView().getDataSuccess(homeBean);
                }else{
                    getIView().getDataError("退出失败",0);
                }

            }
        });
    }

}
