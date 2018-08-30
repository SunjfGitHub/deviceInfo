package com.kkxl.deviceinfo.util;

import android.Manifest;
import android.app.Activity;
import android.content.pm.PackageManager;
import android.os.Build;
import java.util.LinkedList;
import java.util.List;

public class Utils {

    public static boolean initPermission(Activity activity) {
        String[] permissions = {
                Manifest.permission.ACCESS_FINE_LOCATION,
                Manifest.permission.ACCESS_COARSE_LOCATION,
                Manifest.permission.READ_EXTERNAL_STORAGE,
                Manifest.permission.WRITE_EXTERNAL_STORAGE,
                Manifest.permission.READ_PHONE_STATE,
                Manifest.permission.GET_TASKS,};
        int granted = PackageManager.PERMISSION_GRANTED;
        List<String> deniedPermissioned = new LinkedList<String>();
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            for (String permission : permissions) {
                int result = activity.checkSelfPermission(permission);
                if (result != granted) {
                    deniedPermissioned.add(permission);
                }
            }
            if (!deniedPermissioned.isEmpty()) {
                String[] p = deniedPermissioned.toArray(new String[deniedPermissioned.size()]);
                activity.requestPermissions(p, 892746);
            }
        }
        return true;
    }
}
