
package com.renard.common.baseadapter.swipeview;


public interface OnSwipeMenuItemClickListener {


    void onItemClick(Closeable closeable, int adapterPosition, int menuPosition, @SwipeMenuRecyclerView.DirectionMode int direction);

}