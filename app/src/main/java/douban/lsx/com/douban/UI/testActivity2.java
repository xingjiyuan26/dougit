package douban.lsx.com.douban.UI;

import android.app.Activity;
import android.os.Bundle;
import android.view.Window;

import douban.lsx.com.douban.R;

public class testActivity2 extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_test_activity2);
    }

}
