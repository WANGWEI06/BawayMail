package test.bwie.com.bawaymail.view.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;

import test.bwie.com.bawaymail.R;
import test.bwie.com.bawaymail.model.bean.CartBean;
import test.bwie.com.bawaymail.presenter.CartPresenter;
import test.bwie.com.bawaymail.view.activity.MainActivity;

/**
 * Created by Administrator on 2016/10/14.
 */

public class ShopCartAdapter extends RecyclerView.Adapter<ShopCartAdapter.MyViewHolder> {
    private Context context;
    private CartPresenter mPresenter;
    private List<CartBean> data;
    private View headerView;
    private OnDeleteClickListener mOnDeleteClickListener;
    private OnEditClickListener mOnEditClickListener;
    private OnResfreshListener mOnResfreshListener;
    private ShopCartAdapter mShopCartAdapter;
    public ShopCartAdapter(Context context, List<CartBean> data){
        this.context = context;
        this.data = data;
    }

    @Override
    public ShopCartAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view;
        view = LayoutInflater.from(context).inflate(R.layout.item_shopcart, parent, false);
        return new ShopCartAdapter.MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ShopCartAdapter.MyViewHolder holder, final int position) {
        mPresenter.getImageFromServer(context,data.get(position).getGoods_image_url(),holder.ivShopCartClothPic);
        if (position > 0) {
            if (data.get(position).getStore_id() == data.get(position - 1).getStore_id()) {
                holder.llShopCartHeader.setVisibility(View.GONE);
            } else {
                holder.llShopCartHeader.setVisibility(View.VISIBLE);
            }
        }else {
            holder.llShopCartHeader.setVisibility(View.VISIBLE);
        }

        holder.tvShopCartClothName.setText(data.get(position).getGoods_name());
        holder.tvShopCartShopName.setText(data.get(position).getStore_name());
        holder.tvShopCartClothPrice.setText("¥" + data.get(position).getGoods_price());
        holder.etShopCartClothNum.setText(data.get(position).getGoods_num() + "");

        if(mOnResfreshListener != null){
            boolean isSelect = false;
            for(int i = 0;i < data.size(); i++){
                if(!data.get(i).isSelect()){
                    isSelect = false;
                    break;
                }else{
                    isSelect = true;
                }
            }
            mOnResfreshListener.onResfresh(isSelect);
        }

        holder.ivShopCartClothMinus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(Integer.valueOf(data.get(position).getGoods_num()) > 1) {
                    int count = Integer.valueOf(data.get(position).getGoods_num()) - 1;
                    if (mOnEditClickListener != null) {
                        mOnEditClickListener.onEditClick(position, Integer.valueOf(data.get(position).getCart_id()), count);
                    }
                    data.get(position).setGoods_num(count+"");
                    notifyDataSetChanged();
                }
            }
        });

        holder.ivShopCartClothAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int count = Integer.valueOf(data.get(position).getGoods_num()) + 1;
                if(mOnEditClickListener != null){
                    mOnEditClickListener.onEditClick(position,Integer.valueOf(data.get(position).getCart_id()),count);
                }
                data.get(position).setGoods_num(count+"");
                notifyDataSetChanged();
            }
        });

        if(data.get(position).isSelect()){
            holder.ivShopCartClothSel.setImageDrawable(context.getResources().getDrawable(R.drawable.shopcart_selected));
        }else {
            holder.ivShopCartClothSel.setImageDrawable(context.getResources().getDrawable(R.drawable.shopcart_unselected));
        }

        if(data.get(position).isShopSelect()){
            holder.ivShopCartShopSel.setImageDrawable(context.getResources().getDrawable(R.drawable.shopcart_selected));
        }else {
            holder.ivShopCartShopSel.setImageDrawable(context.getResources().getDrawable(R.drawable.shopcart_unselected));
        }

        holder.ivShopCartClothDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDialog(v,position);
            }
        });

        holder.ivShopCartClothSel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                data.get(position).setSelect(!data.get(position).isSelect());
                //通过循环找出不同商铺的第一个商品的位置
                for(int i = 0;i < data.size(); i++){
                    if(data.get(i).getIsFirst() == 1) {
                        //遍历去找出同一家商铺的所有商品的勾选情况
                        for(int j = 0;j < data.size();j++){
                            //如果是同一家商铺的商品，并且其中一个商品是未选中，那么商铺的全选勾选取消
                            if(data.get(j).getStore_id() == data.get(i).getStore_id() && !data.get(j).isSelect()){
                                data.get(i).setShopSelect(false);
                                break;
                            }else{
                                //如果是同一家商铺的商品，并且所有商品是选中，那么商铺的选中全选勾选
                                data.get(i).setShopSelect(true);
                            }
                        }
                    }
                }
                notifyDataSetChanged();
            }
        });

        holder.ivShopCartShopSel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(data.get(position).getIsFirst() == 1) {
                    data.get(position).setShopSelect(!data.get(position).isShopSelect());
                    for(int i = 0;i < data.size();i++){
                        if(data.get(i).getStore_id() == data.get(position).getStore_id()){
                            data.get(i).setSelect(data.get(position).isShopSelect());
                        }
                    }
                    notifyDataSetChanged();
                }
            }
        });

    }

    private void showDialog(final View view, final int position){
        //调用删除某个规格商品的接口
        if(mOnDeleteClickListener != null){
            mOnDeleteClickListener.onDeleteClick(view,position,Integer.valueOf(data.get(position).getCart_id()));
        }
        data.remove(position);
        //重新排序，标记所有商品不同商铺第一个的商品位置
//        MainActivity.isSelectFirst(data);
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        int count = (data == null ? 0 : data.size());
        if(headerView != null){
            count++;
        }
        return count;
    }


    class MyViewHolder extends RecyclerView.ViewHolder
    {
        private ImageView ivShopCartShopSel;
        private TextView tvShopCartShopName;
        private TextView tvShopCartClothName;
        private TextView tvShopCartClothPrice;
        private TextView etShopCartClothNum;
        private TextView tvShopCartClothColor;
        private TextView tvShopCartClothSize;
        private ImageView ivShopCartClothSel;
        private ImageView ivShopCartClothMinus;
        private ImageView ivShopCartClothAdd;
        private ImageView ivShopCartClothDelete;
        private ImageView ivShopCartClothPic;
        private LinearLayout llShopCartHeader;

        public MyViewHolder(View view)
        {
            super(view);
            llShopCartHeader = (LinearLayout) view.findViewById(R.id.ll_shopcart_header);
            ivShopCartShopSel = (ImageView) view.findViewById(R.id.iv_item_shopcart_shopselect);
            tvShopCartShopName = (TextView) view.findViewById(R.id.tv_item_shopcart_shopname);
            tvShopCartClothName = (TextView) view.findViewById(R.id.tv_item_shopcart_clothname);
            tvShopCartClothPrice = (TextView) view.findViewById(R.id.tv_item_shopcart_cloth_price);
            etShopCartClothNum = (TextView) view.findViewById(R.id.et_item_shopcart_cloth_num);
            tvShopCartClothColor = (TextView) view.findViewById(R.id.tv_item_shopcart_cloth_color);
            tvShopCartClothSize = (TextView) view.findViewById(R.id.tv_item_shopcart_cloth_size);
            ivShopCartClothSel = (ImageView) view.findViewById(R.id.tv_item_shopcart_clothselect);
            ivShopCartClothMinus = (ImageView) view.findViewById(R.id.iv_item_shopcart_cloth_minus);
            ivShopCartClothAdd = (ImageView) view.findViewById(R.id.iv_item_shopcart_cloth_add);
            ivShopCartClothPic = (ImageView) view.findViewById(R.id.iv_item_shopcart_cloth_pic);
            ivShopCartClothDelete = (ImageView) view.findViewById(R.id.iv_item_shopcart_cloth_delete);
        }
    }


    public View getHeaderView(){
        return headerView;
    }

    private ShopCartAdapter.OnItemClickListener mOnItemClickListener;
    public interface OnItemClickListener{
        void onItemClick(View view, int position);
    }

    public void setOnItemClickListener(ShopCartAdapter.OnItemClickListener mOnItemClickListener){
        this.mOnItemClickListener = mOnItemClickListener;
    }

    public interface OnDeleteClickListener{
        void onDeleteClick(View view, int position, int cartid);
    }

    public void setOnDeleteClickListener(OnDeleteClickListener mOnDeleteClickListener){
        this.mOnDeleteClickListener = mOnDeleteClickListener;
    }

    public interface OnEditClickListener{
        void onEditClick(int position, int cartid, int count);
    }

    public void setOnEditClickListener(OnEditClickListener mOnEditClickListener){
        this.mOnEditClickListener = mOnEditClickListener;
    }

    public interface OnResfreshListener{
        void onResfresh(boolean isSelect);
    }

    public void setResfreshListener(OnResfreshListener mOnResfreshListener){
        this.mOnResfreshListener = mOnResfreshListener;
    }


}
