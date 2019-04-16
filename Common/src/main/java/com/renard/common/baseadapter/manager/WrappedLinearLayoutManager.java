package com.renard.common.baseadapter.manager;

import android.content.Context;
import android.util.AttributeSet;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

/**
 * Created by Riven_rabbit on 2019/4/15
 *
 * @author Lemon酱
 */
public class WrappedLinearLayoutManager extends LinearLayoutManager {
    public WrappedLinearLayoutManager(Context context) {
        super(context);
    }


    public WrappedLinearLayoutManager(Context context,int orientation){
        super(context,orientation,false);
    }

    public WrappedLinearLayoutManager(Context context, int orientation, boolean reverseLayout) {
        super(context, orientation, reverseLayout);
    }

    public WrappedLinearLayoutManager(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }


    @Override
    public void onLayoutChildren(RecyclerView.Recycler recycler, RecyclerView.State state) {
        try {
            super.onLayoutChildren(recycler, state);
        } catch (IndexOutOfBoundsException e) {
            e.printStackTrace();
        }
    }
}
