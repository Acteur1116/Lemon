package com.renard.common.customview.draglayout;

import android.view.View;

/**
 * Created by Riven_rabbit on 2019/4/16
 *
 * @author Lemon酱
 */
public interface OnDragDeltaChangeListener {
    void onDrag(View view, float delta);

    void onCloseMenu();

    void onOpenMenu();
}
