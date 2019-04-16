package com.renard.common.keeplive.onepix;

import android.os.Bundle;
import android.view.Gravity;
import android.view.Window;
import android.view.WindowManager;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import com.renard.common.utils.CommonLogger;

/**
 * Created by Riven_rabbit on 2019/4/12
 *
 * @author Lemon酱
 */
public class OnePxActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        CommonLogger.e("一像素activity启动");
        Window mWindow = getWindow();
        mWindow.setGravity(Gravity.END | Gravity.TOP);
        WindowManager.LayoutParams attrParams = mWindow.getAttributes();
        attrParams.x = 0;
        attrParams.y = 0;
        attrParams.height = 1;
        attrParams.width = 1;
        mWindow.setAttributes(attrParams);
    }
}
