package com.zerovoid.shoppingcart.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.util.Log;

import com.google.gson.Gson;
import com.jcodecraeer.xrecyclerview.XRecyclerView;
import com.zerovoid.shoppingcart.R;
import com.zerovoid.shoppingcart.adapter.RecyclerCartAdapter;
import com.zerovoid.shoppingcart.model.ResponseRoot;

import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.x;

public class MainCartActivity extends AppCompatActivity implements XRecyclerView.LoadingListener {

    public static final String TAG = "MainCartActivity";
    XRecyclerView cartList;
    RecyclerCartAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_cart);
        initView();
        addShopCart();
        getShopCart(true);
    }

    private void initView() {
        cartList = (XRecyclerView) findViewById(R.id.cartList);
        cartList.setLayoutManager(new LinearLayoutManager(this));
        adapter = new RecyclerCartAdapter(this);
        cartList.setAdapter(adapter);
        cartList.setLoadingListener(this);
    }


    /**
     * 获取购物车数据
     */
    public void getShopCart(final boolean isRefresh) {
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
                ResponseRoot root = new Gson().fromJson(result, ResponseRoot.class);

                if (isRefresh) {
                    adapter.addData(root.data.cartItems);
                } else {
                    adapter.addData(root.data.cartItems);
                }
            }

            @Override
            public void onError(Throwable ex, boolean isOnCallback) {

            }

            @Override
            public void onFinished() {
                if (isRefresh) {
                    cartList.refreshComplete();
                    cartList.setNoMore(false);
                } else {
                    cartList.loadMoreComplete();
                    cartList.setNoMore(true);
                }
            }
        });
    }

    /**
     * 加入购物车
     */
    void addShopCart() {
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

    @Override
    public void onLoadMore() {
        getShopCart(false);
    }

    @Override
    public void onRefresh() {
        getShopCart(true);
    }
}
