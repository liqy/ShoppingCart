package com.zerovoid.shoppingcart.view;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.GridView;

/**
 * 1. 类的用途
 * 2. @author：liqingyi
 * 3. @date：2017/2/14 11:59
 */

public class FullGridView extends GridView{
    public FullGridView(Context context) {
        super(context);
    }

    public FullGridView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int expandSpec = MeasureSpec.makeMeasureSpec(Integer.MAX_VALUE >> 2,
                MeasureSpec.AT_MOST);
        super.onMeasure(widthMeasureSpec, expandSpec);
    }
}
