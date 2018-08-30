package com.kkxl.deviceinfo;

import android.content.Context;
import android.util.Log;
import com.kkxl.deviceinfo.httpServer.HttpdSevices;
import com.kkxl.deviceinfo.infoManager.InfoManager;
import java.io.IOException;
import java.util.HashMap;
import java.util.Set;

public class Agent {

    private static final Agent agent = new Agent();

    private static Context g_ctx = null;

    public static Agent getInstance(){return agent;}

    public Context getContext(){return g_ctx;}

    private static HttpdSevices httpd = null;


    public boolean init(Context context){
        g_ctx = context;

        HashMap hashMap = InfoManager.getInstance().getPropInfo();
        Set<String> set = hashMap.keySet();
        for (String line : set) {
            Log.i("android.os.Build", line + ":" + hashMap.get(line));
        }

        startHttpServer();

        return true;
    }


    public void startHttpServer() {
        new Thread() {
            int port = 10086;

            @Override
            public void run() {
                super.run();
                try {
                    httpd = new HttpdSevices(port);
                    for (int i = 1; i < 5; i++) {
                        try {
                            httpd.start();
                            break;
                        } catch (IOException e) {
                            e.printStackTrace();
                            httpd.setMyPort(port + i * 100);
                            continue;
                        }
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }.start();
    }

}
