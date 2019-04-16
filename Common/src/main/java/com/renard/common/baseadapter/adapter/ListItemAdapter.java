package com.renard.common.baseadapter.adapter;

import com.renard.common.R;
import com.renard.common.baseadapter.viewholder.BaseWrappedViewHolder;

/**
 * Created by Riven_rabbit on 2019/4/13
 *
 * @author Lemon酱
 */
public class ListItemAdapter extends BaseRecyclerAdapter<String, BaseWrappedViewHolder> {
    @Override
    protected int getLayoutId() {
        return R.layout.item_list;
    }

    @Override
    protected void convert(BaseWrappedViewHolder holder, String data) {
        holder.setText(R.id.tv_item_list_content, data)
                .setOnItemClickListener();
    }
}
