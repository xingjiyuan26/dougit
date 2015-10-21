package douban.lsx.com.douban.UI;

import android.app.TabActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TabHost;
import android.widget.TextView;

import douban.lsx.com.douban.R;


public class MainTabActivity extends TabActivity {
    private TabHost tabHost;
    private LayoutInflater inflater;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main_tab);
        inflater = LayoutInflater.from(this);
        tabHost = getTabHost();
        tabHost.addTab(mydouban());
        tabHost.addTab(newbook());
    }

    private TabHost.TabSpec mydouban(){
        TabHost.TabSpec tabSpec = tabHost.newTabSpec("doupan");
        Intent intent = new Intent(this,MeActivity.class);
        tabSpec.setContent(intent);
        tabSpec.setIndicator(setIndicatorView("我的豆瓣", R.drawable.tab_main_nav_me));
        return tabSpec;
    }

    private TabHost.TabSpec newbook(){
        TabHost.TabSpec tabSpec = tabHost.newTabSpec("doupan");
        Intent intent = new Intent(this,testActivity2.class);
        tabSpec.setContent(intent);
        tabSpec.setIndicator(setIndicatorView("新书",R.drawable.tab_main_nav_book));
        return tabSpec;
    }

    private View setIndicatorView(String name,int iconid){
        View view = inflater.inflate(R.layout.tab_main_nav,null);
        ImageView icon = (ImageView) view.findViewById(R.id.ivIcon);
        TextView titlename = (TextView) view.findViewById(R.id.tvTitle);
        icon.setImageResource(iconid);
        titlename.setText(name);
        return view;
    }
}
