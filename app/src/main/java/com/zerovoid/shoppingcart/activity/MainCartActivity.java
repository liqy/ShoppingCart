package com.zerovoid.shoppingcart.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ListView;

import com.google.gson.Gson;
import com.zerovoid.shoppingcart.R;
import com.zerovoid.shoppingcart.adapter.CartAdapter;
import com.zerovoid.shoppingcart.model.ShopParams;

import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.http.body.RequestBody;
import org.xutils.x;

public class MainCartActivity extends AppCompatActivity {

    public static final String TAG = "MainCartActivity";

    ListView cartList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_cart);
        initView();
        addShopCart();
        getShopCart();
    }

    private void initView() {
        cartList = (ListView) findViewById(R.id.cartList);
        cartList.setAdapter(new CartAdapter(this));
    }

    /**
     * 获取购物车数据
     */
    public void getShopCart() {
        RequestParams params = new RequestParams("http://eleteamapi.ygcr8.com/v1/cart");

        //key value 形式提交
         params.addBodyParameter("_terminal-type", "ios");
         params.addBodyParameter("access_token", "bPEM1RCBME1FXIYsO2eAN40SrRDqh_Am");
         params.addBodyParameter("app_cart_cookie_id", "8994117fa9b10b3023f53e9c388cb15c");
         params.addBodyParameter("user_id", "121");

        x.http().post(params, new Callback.CommonCallback<String>() {
            @Override
            public void onCancelled(CancelledException cex) {

            }

            @Override
            public void onSuccess(String result) {
                Log.d(TAG, result);
            }

            @Override
            public void onError(Throwable ex, boolean isOnCallback) {

            }

            @Override
            public void onFinished() {

            }
        });
    }

    /**
     * 加入购物车
     */
    void addShopCart(){
        RequestParams params = new RequestParams("http://eleteamapi.ygcr8.com/v1/cart/add");

        //key value 形式提交
        params.addBodyParameter("_terminal-type", "ios");
        params.addBodyParameter("access_token", "bPEM1RCBME1FXIYsO2eAN40SrRDqh_Am");
        params.addBodyParameter("app_cart_cookie_id", "8994117fa9b10b3023f53e9c388cb15c");
        params.addBodyParameter("user_id", "121");

        params.addBodyParameter("count", "2");
        params.addBodyParameter("product_id", "37");

        x.http().post(params, new Callback.CommonCallback<String>() {
            @Override
            public void onCancelled(CancelledException cex) {

            }

            @Override
            public void onSuccess(String result) {
                Log.d(TAG, result);
            }

            @Override
            public void onError(Throwable ex, boolean isOnCallback) {

            }

            @Override
            public void onFinished() {

            }
        });
    }


}
