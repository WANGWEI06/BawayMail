package test.bwie.com.bawaymail.model.bean;

import java.util.List;

/**
 * @类的用途：
 * @author: 刘刚
 * @date: 2017/7/10
 */

public class PayMentInfo {

    /**
     * code : 200
     * datas : {"payment_list":["predeposit"]}
     */

    private int code;
    private DatasBean datas;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public DatasBean getDatas() {
        return datas;
    }

    public void setDatas(DatasBean datas) {
        this.datas = datas;
    }

    public static class DatasBean {
        private List<String> payment_list;

        public List<String> getPayment_list() {
            return payment_list;
        }

        public void setPayment_list(List<String> payment_list) {
            this.payment_list = payment_list;
        }
    }
}
