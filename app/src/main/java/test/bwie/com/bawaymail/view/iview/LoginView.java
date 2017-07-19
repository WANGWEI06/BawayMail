package test.bwie.com.bawaymail.view.iview;

/**
 * @ Description:
 * @ Date:2017/6/11
 * @ Author:刘刚
 */

public interface LoginView<T> extends IView {
    void getLoginViewSuc(T t);
    void  getLoginErr(String str,int code);
}
