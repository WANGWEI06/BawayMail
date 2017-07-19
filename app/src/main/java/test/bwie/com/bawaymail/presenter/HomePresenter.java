package test.bwie.com.bawaymail.presenter;

import test.bwie.com.bawaymail.model.home.HomeBean;
import test.bwie.com.bawaymail.model.utils.HttpUtils;
import test.bwie.com.bawaymail.model.utils.UrLUtils;
import test.bwie.com.bawaymail.view.iview.IHomeView;

/**
 * @ Description:
 * @ Date:2017/6/9
 * @ Author: 今天我！ 寒夜里看雪飘过  怀着冷透了心窝飘远方 风雨里追赶雾里分不清影踪
 * 天空海阔你与我 可会变  (谁会在变 、) 原谅我这一生不羁放纵爱自由那会怕有一天会跌倒 OH！
 */

public class HomePresenter extends  BasePresenter<IHomeView> {
  public  <T> void getDataFromF(Class<T>t){
      HttpUtils.getRetrofitData(UrLUtils.homeuri,new HttpUtils.CallBackDataF<HomeBean>(){

          @Override
          public void callBackF(HomeBean homeBean) {
              getIView().callbackStr(homeBean);
          }
      });
  }
}
