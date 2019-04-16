package com.renard.common.baseadapter.listener;

import android.view.View;
import com.renard.common.baseadapter.adapter.BaseRecyclerAdapter;

/**
 * Created by Riven_rabbit on 2019/4/13
 *
 * @author Lemon酱
 */
public abstract class OnSimpleItemClickListener implements BaseRecyclerAdapter.OnItemClickListener {


    @Override
    public boolean onItemLongClick(int position, View view) {
        return false;
    }

    @Override
    public boolean onItemChildLongClick(int position, View view, int id) {
        return false;
    }

    @Override
    public void onItemChildClick(int position, View view, int id) {

    }
}
