package test.bwie.com.bawaymail.model.bean;

import java.util.List;

/**
 * @ Description:
 * @ Date:2017/7/10
 * @ Author:刘刚
 */

public class OrderBean {

    @Override
    public String toString() {
        return "OrderBean{" +
                "code=" + code +
                ", datas=" + datas +
                '}';
    }

    /**
     * code : 200
     * datas : {"pay_info":{"pay_amount":"209500.00","member_available_pd":"0.00","member_available_rcb":"0.00",
     * "member_paypwd":false,"pay_sn":"470553023000020007","payed_amount":"0.00",
     * "payment_list":[{"payment_code":"predeposit","payment_name":"站内余额支付"}]}}
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
        @Override
        public String toString() {
            return "DatasBean{" +
                    "pay_info=" + pay_info +
                    '}';
        }

        /**
         * pay_info : {"pay_amount":"209500.00","member_available_pd":"0.00","member_available_rcb":"0.00",
         * "member_paypwd":false,"pay_sn":"470553023000020007","payed_amount":"0.00",
         * "payment_list":[{"payment_code":"predeposit","payment_name":"站内余额支付"}]}
         */

        private PayInfoBean pay_info;

        public PayInfoBean getPay_info() {
            return pay_info;
        }

        public void setPay_info(PayInfoBean pay_info) {
            this.pay_info = pay_info;
        }

        public static class PayInfoBean {
            @Override
            public String toString() {
                return "PayInfoBean{" +
                        "member_available_pd='" + member_available_pd + '\'' +
                        ", pay_amount='" + pay_amount + '\'' +
                        ", member_available_rcb='" + member_available_rcb + '\'' +
                        ", member_paypwd=" + member_paypwd +
                        ", pay_sn='" + pay_sn + '\'' +
                        ", payed_amount='" + payed_amount + '\'' +
                        ", payment_list=" + payment_list +
                        '}';
            }

            /**
             * pay_amount : 209500.00
             * member_available_pd : 0.00
             * member_available_rcb : 0.00
             * member_paypwd : false
             * pay_sn : 470553023000020007
             * payed_amount : 0.00
             * payment_list : [{"payment_code":"predeposit","payment_name":"站内余额支付"}]
             */

            private String pay_amount;
            private String member_available_pd;
            private String member_available_rcb;
            private boolean member_paypwd;
            private String pay_sn;
            private String payed_amount;
            private List<PaymentListBean> payment_list;

            public String getPay_amount() {
                return pay_amount;
            }

            public void setPay_amount(String pay_amount) {
                this.pay_amount = pay_amount;
            }

            public String getMember_available_pd() {
                return member_available_pd;
            }

            public void setMember_available_pd(String member_available_pd) {
                this.member_available_pd = member_available_pd;
            }

            public String getMember_available_rcb() {
                return member_available_rcb;
            }

            public void setMember_available_rcb(String member_available_rcb) {
                this.member_available_rcb = member_available_rcb;
            }

            public boolean isMember_paypwd() {
                return member_paypwd;
            }

            public void setMember_paypwd(boolean member_paypwd) {
                this.member_paypwd = member_paypwd;
            }

            public String getPay_sn() {
                return pay_sn;
            }

            public void setPay_sn(String pay_sn) {
                this.pay_sn = pay_sn;
            }

            public String getPayed_amount() {
                return payed_amount;
            }

            public void setPayed_amount(String payed_amount) {
                this.payed_amount = payed_amount;
            }

            public List<PaymentListBean> getPayment_list() {
                return payment_list;
            }

            public void setPayment_list(List<PaymentListBean> payment_list) {
                this.payment_list = payment_list;
            }

            public static class PaymentListBean {
                @Override
                public String toString() {
                    return "PaymentListBean{" +
                            "payment_code='" + payment_code + '\'' +
                            ", payment_name='" + payment_name + '\'' +
                            '}';
                }

                /**
                 * payment_code : predeposit
                 * payment_name : 站内余额支付
                 */

                private String payment_code;
                private String payment_name;

                public String getPayment_code() {
                    return payment_code;
                }

                public void setPayment_code(String payment_code) {
                    this.payment_code = payment_code;
                }

                public String getPayment_name() {
                    return payment_name;
                }

                public void setPayment_name(String payment_name) {
                    this.payment_name = payment_name;
                }
            }
        }
    }
}
