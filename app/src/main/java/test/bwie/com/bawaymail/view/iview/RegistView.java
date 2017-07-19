package test.bwie.com.bawaymail.view.iview;

/**
 * @ Description:
 * @ Date:2017/6/11
 * @ Author:刘刚
 */

public interface RegistView<T> extends IView {
    void getViewSuccess(T t);
    void getViewErr(String str,int code);
}
