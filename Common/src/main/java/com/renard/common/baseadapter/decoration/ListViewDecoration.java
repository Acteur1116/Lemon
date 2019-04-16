package com.renard.common.baseadapter.decoration;

import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.view.View;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.renard.common.R;
import com.renard.common.baseadapter.viewholder.SuperRecyclerView;
import com.renard.common.skin.SkinManager;

/**
 * Created by Riven_rabbit on 2019/4/15
 *
 * @author Lemon酱
 */
public class ListViewDecoration extends RecyclerView.ItemDecoration {
    private int divideSize;
    private Drawable divider;




    public ListViewDecoration() {
        divider = SkinManager.getInstance().getDrawable(R.drawable.recycler_divider);
    }

    public ListViewDecoration(int divideSize) {
        this.divideSize = divideSize;
    }

    @Override
    public void onDrawOver(Canvas c, RecyclerView parent, RecyclerView.State state) {
        if (divider != null) {
            int count = parent.getChildCount();
            int left = parent.getPaddingLeft();
            int right = parent.getWidth() - parent.getPaddingRight();
            View child = null;
            for (int i = 0; i < count; i++) {
                if (count == 1) {
                    break;
                }
                child = parent.getChildAt(i);
                RecyclerView.LayoutParams params = (RecyclerView.LayoutParams) child.getLayoutParams();
                int top = child.getBottom() + params.bottomMargin;
                int bottom = top + divider.getIntrinsicHeight();
                divider.setBounds(left, top, right, bottom);
                divider.draw(c);
            }
        }
    }

    @Override
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
        if (divider != null) {
            outRect.set(0, 0, 0, divider.getIntrinsicHeight());
        } else {
            int position = parent.getChildAdapterPosition(view); // item position
            boolean hasHeader = false;
            if (parent instanceof SuperRecyclerView) {
                SuperRecyclerView superRecyclerView = (SuperRecyclerView) parent;
                if (superRecyclerView.getHeaderContainer().getChildCount() > position) {
                    return;
                }
                int headerCount = superRecyclerView.getHeaderContainer().getChildCount();
                position -= headerCount;
                hasHeader = headerCount > 0;
            }
            RecyclerView.LayoutManager layoutManager = parent.getLayoutManager();
            if (layoutManager instanceof GridLayoutManager) {

            } else if (layoutManager instanceof LinearLayoutManager) {
                LinearLayoutManager linearLayoutManager = ((LinearLayoutManager) layoutManager);
                if (linearLayoutManager.getOrientation() == LinearLayoutManager.HORIZONTAL) {
                    outRect.right = divideSize;
                    if (hasHeader && position == 0) {
                        outRect.left = divideSize;
                    }
                } else {
                    outRect.bottom = divideSize;
                    if (position == 0) {
                        outRect.top = divideSize;
                    }
                }

            }
        }
    }
}
