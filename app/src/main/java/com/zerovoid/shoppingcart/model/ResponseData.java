package com.zerovoid.shoppingcart.model;

import java.util.ArrayList;

/**
 * 1. 类的用途
 * 2. @author：liqingyi
 * 3. @date：2017/2/16 10:30
 */

public class ResponseData {

    public ArrayList<CartItem> cartItems;
    public String couponItems;
    public int cart_num;
    public int total_price;
    public boolean is_logged_in;
    public String app_cart_cookie_id;
}
