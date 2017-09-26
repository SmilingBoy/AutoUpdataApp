package com.smile.autoupdataapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.allenliu.versionchecklib.core.AllenChecker;
import com.allenliu.versionchecklib.core.VersionParams;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        AllenChecker.init(true);
        VersionParams.Builder builder = new VersionParams.Builder()
                .setCustomDownloadActivityClass(UpdataDialogActivity.class)
                .setRequestUrl("http://www.junfenshidai.com/index.php/Api/User3/up_app")
                .setService(UpdataService.class);

        AllenChecker.startVersionCheck(this, builder.build());
    }
}
