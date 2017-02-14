package com.zerovoid.shoppingcart.model;

import com.google.gson.annotations.SerializedName;

/**
 * 1. 类的用途
 * 2. @author：liqingyi
 * 3. @date：2017/2/14 15:46
 */

public class ShopParams {

    @SerializedName("_terminal-type")
    public String type;

    public String access_token;

    public String app_cart_cookie_id;

    public String user_id;

    public String mobile;

    public ShopParams(String mobile) {
        this.mobile = mobile;
    }

    public ShopParams() {
        this.type="ios";
        this.access_token="bPEM1RCBME1FXIYsO2eAN40SrRDqh_Am";
        this.app_cart_cookie_id="8994117fa9b10b3023f53e9c388cb15c";
        this.user_id="121";
    }
}
