package test.bwie.com.bawaymail.view.iview;

/**
 * @ Description:
 * @ Date:2017/6/9
 * @ Author:刘刚
 */

public interface IHomeView<T> extends IView{
  void callbackStr(T t);
  void callbackErr(String err,int code);
}
