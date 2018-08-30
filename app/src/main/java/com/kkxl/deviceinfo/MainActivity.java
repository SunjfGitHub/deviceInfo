package com.kkxl.deviceinfo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import com.kkxl.deviceinfo.util.JniMethodUtils;
import com.kkxl.deviceinfo.util.Utils;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Utils.initPermission(this);
        Agent.getInstance().init(this.getApplicationContext());

        // Example of a call to a native method
        TextView tv = (TextView) findViewById(R.id.sample_text);
        tv.setText(JniMethodUtils.stringFromJNI());

    }

}
