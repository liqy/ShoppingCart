package com.zerovoid.shoppingcart.view;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.widget.ListView;

/**
 * 1. 类的用途
 * 2. @author：liqingyi
 * 3. @date：2017/2/14 11:30
 */

public class FullListView extends ListView{

    public static final String TAG="FullListView";

    public FullListView(Context context) {
        super(context);
    }

    public FullListView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int expandSpec = MeasureSpec.makeMeasureSpec(Integer.MAX_VALUE >> 2,
                MeasureSpec.AT_MOST);
        super.onMeasure(widthMeasureSpec, expandSpec);
    }
}
