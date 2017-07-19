package test.bwie.com.bawaymail.view.iview;

/**
 * @ Description:
 * @ Date:2017/6/16
 * @ Author:刘刚
 */

public interface ShopItemView<T> extends IView {
    void  getShopItemView(T t);
    void  getShopItemViewErr(String str,int code);
}
