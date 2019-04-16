package com.renard.common.customview;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import androidx.viewpager.widget.ViewPager;
import com.renard.common.utils.CommonLogger;

/**
 * Created by Riven_rabbit on 2019/4/16
 *
 * @author Lemon酱
 */
public class WrappedViewPager extends ViewPager {
    public WrappedViewPager(Context context) {
        super(context);
    }

    public WrappedViewPager(Context context, AttributeSet attrs) {
        super(context, attrs);
    }
    @Override
    public boolean onTouchEvent(MotionEvent ev) {
        try {
            return needScroll && super.onTouchEvent(ev);
        } catch (IllegalArgumentException ex) {
            ex.printStackTrace();
        }
        return false;
    }


    private boolean needScroll=true;


    public void setNeedScroll(boolean needScroll) {
        this.needScroll = needScroll;
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        try {
            if (ev.getAction() == MotionEvent.ACTION_MOVE) {
                CommonLogger.e("move");
            }
            return needScroll && super.onInterceptTouchEvent(ev);
        } catch (IllegalArgumentException ex) {
            ex.printStackTrace();
        }
        return true;
    }
}
