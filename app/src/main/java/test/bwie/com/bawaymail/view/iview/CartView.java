package test.bwie.com.bawaymail.view.iview;


import test.bwie.com.bawaymail.model.bean.CartDataBean;
import test.bwie.com.bawaymail.model.bean.DelCartBean;

/**
 * @类的用途：
 * @author: 刘刚
 * @date: 2017/6/9
 */

public interface CartView<T> extends IView{

    void getCartListData(CartDataBean str);

    void getCartDelData(DelCartBean str);



}
