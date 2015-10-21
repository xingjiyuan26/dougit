package douban.lsx.com.douban.UI;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.os.Handler;
import android.provider.Settings;
import android.view.WindowManager;
import android.view.animation.AlphaAnimation;
import android.widget.LinearLayout;
import android.widget.TextView;

import douban.lsx.com.douban.R;

/**
 * Created by Administrator on 2015/10/16.
 */
public class SplashActivity extends Activity {
    private TextView versionnumber;
    private LinearLayout linearLay;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager
                .LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.splash);

         versionnumber = (TextView) findViewById(R.id.versionNumber);
         linearLay = (LinearLayout) findViewById(R.id.LinearLayout01);
        String versionname = getVersion();
        versionnumber.setText(versionname);

        //判断当前网络是否可用？

        if(isNetConnected()){
            //显示动画效果
            AlphaAnimation aa = new AlphaAnimation(0.0f,1.0f);
            aa.setDuration(2000);
            linearLay.setAnimation(aa);
            linearLay.startAnimation(aa);
            //通过handler延迟执行
            new Handler().postDelayed(new mypostDelay(),2000);
        }else {
            //弹出对话框
            getShowSetNetWorkDialog();
        }
    }

    class mypostDelay implements Runnable{
        @Override
        public void run() {
            Intent intent = new Intent(SplashActivity.this,MainTabActivity.class);
            startActivity(intent);
            finish();
        }
    }
    private void getShowSetNetWorkDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("设置网络");
        builder.setMessage("网络错误，请检查网络设置。");
        builder.setPositiveButton("设置网络", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Intent intent = new Intent(Settings.ACTION_WIRELESS_SETTINGS);
                startActivity(intent);
                finish();
            }
        });
        builder.setNegativeButton("取消", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                finish();
            }
        });

        builder.create().show();
    }

    /**
     * 获取版本号
     * @return 版本号
     */
    private String getVersion(){
        try {
           PackageInfo info =  getPackageManager().getPackageInfo(getPackageName(), 0);
            return "Version"+info.versionName;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
            return "Version";
        }
    }

    private boolean isNetConnected(){
        ConnectivityManager connectivityManager = (ConnectivityManager)getSystemService(CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();

//        if(networkInfo!=null&&networkInfo.isConnected()){
//            return true;
//        }else {
//            return false;
//        }
        return (networkInfo!=null&&networkInfo.isConnected());
    }
}
