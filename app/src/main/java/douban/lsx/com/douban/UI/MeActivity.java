package douban.lsx.com.douban.UI;

import android.app.Activity;
import android.os.Bundle;
import android.view.Window;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import douban.lsx.com.douban.R;

public class MeActivity extends Activity {
    private ListView melistview;
    private static final String[] arr = {"我读", "我听", "我评", "我看", "我的日记", "我的资料", "小组", "我读",
            "我听", "我评", "我看", "我的日记", "我的资料", "小组"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_me);

        melistview = (ListView) findViewById(R.id.melistview);

        melistview.setAdapter(new ArrayAdapter<String>(this, R.layout.fav_item, R.id.fav_title, arr));
    }

}
