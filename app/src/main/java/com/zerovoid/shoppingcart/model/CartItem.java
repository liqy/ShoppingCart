package com.zerovoid.shoppingcart.model;

/**
 * 1. 类的用途
 * 2. @author：liqingyi
 * 3. @date：2017/2/16 10:25
 */

public class CartItem {

    public int id;
    public int cart_id;
    public int created_at;
    public String created_by;
    public int status;
    public int updated_at;
    public String updated_by;
    public int count;
    public int product_id;
    public String sku_id;
    public int is_ordered;
    public int is_selected;
    public int user_id;
    public String cookie_id;
    public String app_cart_cookie_id;
    public Product product;

}
