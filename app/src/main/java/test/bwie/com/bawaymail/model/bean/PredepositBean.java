package test.bwie.com.bawaymail.model.bean;

import java.util.List;

/**
 * @类的用途：
 * @author: 李晓倩
 * @date: 2017/7/10
 */

public class PredepositBean {

    /**
     * state : true
     * msg :
     * data : {"pay_id":"8","pay_sn":"510553033311879007","buyer_id":"7","api_pay_state":"0",
     * "subject":"实物订单_510553033311879007","order_type":"real_order","order_list":[{"order_id":"8",
     * "order_sn":"9000000000000801","pay_sn":"510553033311879007","pay_sn1":null,"store_id":"1",
     * "store_name":"好商城V5","buyer_id":"7","buyer_name":"hehehe","buyer_email":"hehe@163.com","buyer_phone":"1111",
     * "add_time":"1499689311","payment_code":"online","payment_time":"0","finnshed_time":"0",
     * "goods_amount":"209500.00","order_amount":"209500.00","rcb_amount":"0.00","pd_amount":"0.00",
     * "shipping_fee":"0.00","evaluation_state":"0","evaluation_again_state":"0","order_state":"10",
     * "refund_state":"0","lock_state":"0","delete_state":"0","refund_amount":"0.00","delay_time":"0",
     * "order_from":"2","shipping_code":"","order_type":"1","api_pay_time":"0","chain_id":"0","chain_code":"0",
     * "rpt_amount":"0.00","trade_no":null}],"if_buyer_repay":null,"api_pay_amount":"209500.00"}
     */

    private boolean state;
    private String msg;
    private DataBean data;

    public boolean isState() {
        return state;
    }

    public void setState(boolean state) {
        this.state = state;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * pay_id : 8
         * pay_sn : 510553033311879007
         * buyer_id : 7
         * api_pay_state : 0
         * subject : 实物订单_510553033311879007
         * order_type : real_order
         * order_list : [{"order_id":"8","order_sn":"9000000000000801","pay_sn":"510553033311879007","pay_sn1":null,
         * "store_id":"1","store_name":"好商城V5","buyer_id":"7","buyer_name":"hehehe","buyer_email":"hehe@163.com",
         * "buyer_phone":"1111","add_time":"1499689311","payment_code":"online","payment_time":"0",
         * "finnshed_time":"0","goods_amount":"209500.00","order_amount":"209500.00","rcb_amount":"0.00",
         * "pd_amount":"0.00","shipping_fee":"0.00","evaluation_state":"0","evaluation_again_state":"0",
         * "order_state":"10","refund_state":"0","lock_state":"0","delete_state":"0","refund_amount":"0.00",
         * "delay_time":"0","order_from":"2","shipping_code":"","order_type":"1","api_pay_time":"0","chain_id":"0",
         * "chain_code":"0","rpt_amount":"0.00","trade_no":null}]
         * if_buyer_repay : null
         * api_pay_amount : 209500.00
         */

        private String pay_id;
        private String pay_sn;
        private String buyer_id;
        private String api_pay_state;
        private String subject;
        private String order_type;
        private Object if_buyer_repay;
        private String api_pay_amount;
        private List<OrderListBean> order_list;

        public String getPay_id() {
            return pay_id;
        }

        public void setPay_id(String pay_id) {
            this.pay_id = pay_id;
        }

        public String getPay_sn() {
            return pay_sn;
        }

        public void setPay_sn(String pay_sn) {
            this.pay_sn = pay_sn;
        }

        public String getBuyer_id() {
            return buyer_id;
        }

        public void setBuyer_id(String buyer_id) {
            this.buyer_id = buyer_id;
        }

        public String getApi_pay_state() {
            return api_pay_state;
        }

        public void setApi_pay_state(String api_pay_state) {
            this.api_pay_state = api_pay_state;
        }

        public String getSubject() {
            return subject;
        }

        public void setSubject(String subject) {
            this.subject = subject;
        }

        public String getOrder_type() {
            return order_type;
        }

        public void setOrder_type(String order_type) {
            this.order_type = order_type;
        }

        public Object getIf_buyer_repay() {
            return if_buyer_repay;
        }

        public void setIf_buyer_repay(Object if_buyer_repay) {
            this.if_buyer_repay = if_buyer_repay;
        }

        public String getApi_pay_amount() {
            return api_pay_amount;
        }

        public void setApi_pay_amount(String api_pay_amount) {
            this.api_pay_amount = api_pay_amount;
        }

        public List<OrderListBean> getOrder_list() {
            return order_list;
        }

        public void setOrder_list(List<OrderListBean> order_list) {
            this.order_list = order_list;
        }

        public static class OrderListBean {
            /**
             * order_id : 8
             * order_sn : 9000000000000801
             * pay_sn : 510553033311879007
             * pay_sn1 : null
             * store_id : 1
             * store_name : 好商城V5
             * buyer_id : 7
             * buyer_name : hehehe
             * buyer_email : hehe@163.com
             * buyer_phone : 1111
             * add_time : 1499689311
             * payment_code : online
             * payment_time : 0
             * finnshed_time : 0
             * goods_amount : 209500.00
             * order_amount : 209500.00
             * rcb_amount : 0.00
             * pd_amount : 0.00
             * shipping_fee : 0.00
             * evaluation_state : 0
             * evaluation_again_state : 0
             * order_state : 10
             * refund_state : 0
             * lock_state : 0
             * delete_state : 0
             * refund_amount : 0.00
             * delay_time : 0
             * order_from : 2
             * shipping_code :
             * order_type : 1
             * api_pay_time : 0
             * chain_id : 0
             * chain_code : 0
             * rpt_amount : 0.00
             * trade_no : null
             */

            private String order_id;
            private String order_sn;
            private String pay_sn;
            private Object pay_sn1;
            private String store_id;
            private String store_name;
            private String buyer_id;
            private String buyer_name;
            private String buyer_email;
            private String buyer_phone;
            private String add_time;
            private String payment_code;
            private String payment_time;
            private String finnshed_time;
            private String goods_amount;
            private String order_amount;
            private String rcb_amount;
            private String pd_amount;
            private String shipping_fee;
            private String evaluation_state;
            private String evaluation_again_state;
            private String order_state;
            private String refund_state;
            private String lock_state;
            private String delete_state;
            private String refund_amount;
            private String delay_time;
            private String order_from;
            private String shipping_code;
            private String order_type;
            private String api_pay_time;
            private String chain_id;
            private String chain_code;
            private String rpt_amount;
            private Object trade_no;

            public String getOrder_id() {
                return order_id;
            }

            public void setOrder_id(String order_id) {
                this.order_id = order_id;
            }

            public String getOrder_sn() {
                return order_sn;
            }

            public void setOrder_sn(String order_sn) {
                this.order_sn = order_sn;
            }

            public String getPay_sn() {
                return pay_sn;
            }

            public void setPay_sn(String pay_sn) {
                this.pay_sn = pay_sn;
            }

            public Object getPay_sn1() {
                return pay_sn1;
            }

            public void setPay_sn1(Object pay_sn1) {
                this.pay_sn1 = pay_sn1;
            }

            public String getStore_id() {
                return store_id;
            }

            public void setStore_id(String store_id) {
                this.store_id = store_id;
            }

            public String getStore_name() {
                return store_name;
            }

            public void setStore_name(String store_name) {
                this.store_name = store_name;
            }

            public String getBuyer_id() {
                return buyer_id;
            }

            public void setBuyer_id(String buyer_id) {
                this.buyer_id = buyer_id;
            }

            public String getBuyer_name() {
                return buyer_name;
            }

            public void setBuyer_name(String buyer_name) {
                this.buyer_name = buyer_name;
            }

            public String getBuyer_email() {
                return buyer_email;
            }

            public void setBuyer_email(String buyer_email) {
                this.buyer_email = buyer_email;
            }

            public String getBuyer_phone() {
                return buyer_phone;
            }

            public void setBuyer_phone(String buyer_phone) {
                this.buyer_phone = buyer_phone;
            }

            public String getAdd_time() {
                return add_time;
            }

            public void setAdd_time(String add_time) {
                this.add_time = add_time;
            }

            public String getPayment_code() {
                return payment_code;
            }

            public void setPayment_code(String payment_code) {
                this.payment_code = payment_code;
            }

            public String getPayment_time() {
                return payment_time;
            }

            public void setPayment_time(String payment_time) {
                this.payment_time = payment_time;
            }

            public String getFinnshed_time() {
                return finnshed_time;
            }

            public void setFinnshed_time(String finnshed_time) {
                this.finnshed_time = finnshed_time;
            }

            public String getGoods_amount() {
                return goods_amount;
            }

            public void setGoods_amount(String goods_amount) {
                this.goods_amount = goods_amount;
            }

            public String getOrder_amount() {
                return order_amount;
            }

            public void setOrder_amount(String order_amount) {
                this.order_amount = order_amount;
            }

            public String getRcb_amount() {
                return rcb_amount;
            }

            public void setRcb_amount(String rcb_amount) {
                this.rcb_amount = rcb_amount;
            }

            public String getPd_amount() {
                return pd_amount;
            }

            public void setPd_amount(String pd_amount) {
                this.pd_amount = pd_amount;
            }

            public String getShipping_fee() {
                return shipping_fee;
            }

            public void setShipping_fee(String shipping_fee) {
                this.shipping_fee = shipping_fee;
            }

            public String getEvaluation_state() {
                return evaluation_state;
            }

            public void setEvaluation_state(String evaluation_state) {
                this.evaluation_state = evaluation_state;
            }

            public String getEvaluation_again_state() {
                return evaluation_again_state;
            }

            public void setEvaluation_again_state(String evaluation_again_state) {
                this.evaluation_again_state = evaluation_again_state;
            }

            public String getOrder_state() {
                return order_state;
            }

            public void setOrder_state(String order_state) {
                this.order_state = order_state;
            }

            public String getRefund_state() {
                return refund_state;
            }

            public void setRefund_state(String refund_state) {
                this.refund_state = refund_state;
            }

            public String getLock_state() {
                return lock_state;
            }

            public void setLock_state(String lock_state) {
                this.lock_state = lock_state;
            }

            public String getDelete_state() {
                return delete_state;
            }

            public void setDelete_state(String delete_state) {
                this.delete_state = delete_state;
            }

            public String getRefund_amount() {
                return refund_amount;
            }

            public void setRefund_amount(String refund_amount) {
                this.refund_amount = refund_amount;
            }

            public String getDelay_time() {
                return delay_time;
            }

            public void setDelay_time(String delay_time) {
                this.delay_time = delay_time;
            }

            public String getOrder_from() {
                return order_from;
            }

            public void setOrder_from(String order_from) {
                this.order_from = order_from;
            }

            public String getShipping_code() {
                return shipping_code;
            }

            public void setShipping_code(String shipping_code) {
                this.shipping_code = shipping_code;
            }

            public String getOrder_type() {
                return order_type;
            }

            public void setOrder_type(String order_type) {
                this.order_type = order_type;
            }

            public String getApi_pay_time() {
                return api_pay_time;
            }

            public void setApi_pay_time(String api_pay_time) {
                this.api_pay_time = api_pay_time;
            }

            public String getChain_id() {
                return chain_id;
            }

            public void setChain_id(String chain_id) {
                this.chain_id = chain_id;
            }

            public String getChain_code() {
                return chain_code;
            }

            public void setChain_code(String chain_code) {
                this.chain_code = chain_code;
            }

            public String getRpt_amount() {
                return rpt_amount;
            }

            public void setRpt_amount(String rpt_amount) {
                this.rpt_amount = rpt_amount;
            }

            public Object getTrade_no() {
                return trade_no;
            }

            public void setTrade_no(Object trade_no) {
                this.trade_no = trade_no;
            }
        }
    }
}
