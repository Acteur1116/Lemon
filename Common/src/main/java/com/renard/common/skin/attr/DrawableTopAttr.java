package com.renard.common.skin.attr;

import android.os.Build;
import android.view.View;
import android.widget.RadioButton;
import androidx.annotation.RequiresApi;
import com.renard.common.skin.SkinManager;

/**
 * Created by COOTEK on 2017/9/7.
 */

public class DrawableTopAttr extends SkinAttr {

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN_MR1)
    @Override
    public void apply(View view) {
        if (isDrawableType()&&view instanceof RadioButton) {
            ((RadioButton) view).setCompoundDrawablesRelativeWithIntrinsicBounds
                    (null, SkinManager.getInstance().getDrawable(getResId()), null, null);
        }
    }
}
