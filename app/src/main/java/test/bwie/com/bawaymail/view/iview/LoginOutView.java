package test.bwie.com.bawaymail.view.iview;

/**
 * @类的用途：
 * @author: 刘刚
 * @date: 2017/6/10
 */

public interface LoginOutView<T> extends IView{
    void getDataSuccess(T t);
    void getDataError(String strMsg, int errCode);
}
