package com.zerovoid.shoppingcart.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;

import com.zerovoid.shoppingcart.R;
import com.zerovoid.shoppingcart.view.FullListView;

import java.util.ArrayList;

/**
 * 1. 类的用途
 * 2. @author：liqingyi
 * 3. @date：2017/2/14 11:35
 */

public class CartAdapter extends BaseAdapter {

    ArrayList<String> list;
    LayoutInflater inflater;
    Context context;

    public CartAdapter(Context context) {
        list = new ArrayList<>();
        list.add("第一");
        this.context=context;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return list == null ? 0 : list.size();
    }

    @Override
    public String getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if (convertView == null) {
            convertView = inflater.inflate(R.layout.item_cart_view, parent, false);
            holder = new ViewHolder(convertView);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        CartItemAdapter adapter=new CartItemAdapter(context);
        holder.listView.setAdapter(adapter);
        return convertView;
    }

    class ViewHolder {
        FullListView listView;
        public ViewHolder(View convertView) {
//            listView = (FullListView) convertView.findViewById(R.id.listView);
        }
    }
}
