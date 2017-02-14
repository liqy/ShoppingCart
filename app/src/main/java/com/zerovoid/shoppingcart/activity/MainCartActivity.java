package com.zerovoid.shoppingcart.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import com.zerovoid.shoppingcart.R;
import com.zerovoid.shoppingcart.adapter.CartAdapter;

public class MainCartActivity extends AppCompatActivity {

    ListView cartList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_cart);
        initView();
    }

    private void initView() {
        cartList=(ListView)findViewById(R.id.cartList);
        cartList.setAdapter(new CartAdapter(this));
    }


}
