package com.zerovoid.shoppingcart.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.TextView;
import android.widget.Toast;

import com.zerovoid.shoppingcart.R;
import com.zerovoid.shoppingcart.activity.MainCartActivity;
import com.zerovoid.shoppingcart.model.CartItem;
import com.zerovoid.shoppingcart.view.FullListView;

import java.util.ArrayList;

/**
 * 1. 类的用途
 * 2. @author：liqingyi
 * 3. @date：2017/2/15 11:49
 */

public class RecyclerCartAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    Context context;
    ArrayList<CartItem> list;

    public RecyclerCartAdapter(Context context) {
        this.context = context;
        list = new ArrayList<>();
    }

    public void addData(ArrayList<CartItem> items){
        this.list.addAll(items);
        notifyDataSetChanged();
    }

    public void clearData(){
        this.list.clear();
        notifyDataSetChanged();
    }

    public void updateData(int pos){

    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new CartViewHolder(LayoutInflater.from(context).inflate(R.layout.item_cart_view, parent, false));
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        CartItemAdapter adapter = new CartItemAdapter(context);
        CartViewHolder viewHolder = (CartViewHolder) holder;
        CartItem item= list.get(position);
        viewHolder.textView.setText(item.product.name);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    class CartViewHolder extends RecyclerView.ViewHolder {
        TextView textView;
        public CartViewHolder(View itemView) {
            super(itemView);
            textView = (TextView) itemView.findViewById(R.id.textView);
        }

    }
}
