package com.renard.lemon;

import android.os.Bundle;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import com.renard.navigationview.NavigationView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Riven_rabbit on 2019/4/16
 *
 * @author Lemon酱
 */
public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setNavigation();
    }

    /**
     * 设置底部栏
     */
    private void setNavigation() {
        final NavigationView mNV = findViewById(R.id.navigation);
        List<NavigationView.Model> tabs = new ArrayList<>();
        tabs.add(new NavigationView.Model.Builder(R.mipmap.ic_launcher,R.mipmap.ic_launcher_round).title("Music").build());
        tabs.add(new NavigationView.Model.Builder(R.mipmap.ic_launcher,R.mipmap.ic_launcher_round).title("Live").build());
        tabs.add(new NavigationView.Model.Builder(R.mipmap.ic_launcher,R.mipmap.ic_launcher_round).title("News").build());
        tabs.add(new NavigationView.Model.Builder(R.mipmap.ic_launcher,R.mipmap.ic_launcher_round).title("Works").build());
        mNV.setItems(tabs);
        mNV.setOnTabSelectedListener(new NavigationView.OnTabSelectedListener() {
            @Override
            public void selected(int i, NavigationView.Model model) {
                ((TextView)findViewById(R.id.tv_select)).setText(model.getTitle());
            }

            @Override
            public void unselected(int i, NavigationView.Model model) {

            }
        });
        mNV.build();
        mNV.reminder(0,true,"99");
        mNV.reminder(1,true,"···");
        mNV.reminder(2,true,"");
        mNV.reminder(3,true,"16");
    }
}
