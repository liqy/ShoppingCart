package com.zerovoid.shoppingcart.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.zerovoid.shoppingcart.R;

import java.util.ArrayList;

/**
 * 1. 类的用途
 * 2. @author：liqingyi
 * 3. @date：2017/2/14 11:44
 */

public class CartItemAdapter extends BaseAdapter{
    ArrayList<String> list;
    LayoutInflater inflater;

    public CartItemAdapter(Context context) {
        list = new ArrayList<>();
        list.add("第一");
        list.add("第二");
        list.add("第三");
        list.add("第四");
        list.add("第五");
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
            convertView = inflater.inflate(R.layout.item_cart_item_view, parent, false);
            holder = new ViewHolder(convertView);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        String item=getItem(position);
        holder.label.setText(position+","+item);
        return convertView;
    }

    class ViewHolder {
        TextView label;

        public ViewHolder(View convertView) {
            label = (TextView) convertView.findViewById(R.id.label);
        }
    }
}
