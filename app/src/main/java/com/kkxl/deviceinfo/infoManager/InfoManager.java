package com.kkxl.deviceinfo.infoManager;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build;
import android.telephony.SubscriptionInfo;
import android.telephony.SubscriptionManager;
import android.telephony.TelephonyManager;
import com.kkxl.deviceinfo.util.JniMethodUtils;
import com.kkxl.deviceinfo.util.reflect.Reflect;
import org.json.JSONArray;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * device information management class , all methods for getting device information will be here.
 * Created by black on 18-8-27.
 */
public class InfoManager {

    private static final InfoManager infoManager = new InfoManager();

    public static int s_sdk_ver = Build.VERSION.SDK_INT;

    public static InfoManager getInstance(){return infoManager;}


    public synchronized String getProperty(String propName) {
        String value = null;
        try {
            value = Reflect.on("android.os.SystemProperties").call("get",propName).get();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return value == null ? "" : value;
    }

    public void setProperty(String propName, String propNameValue) {
        try {
            Reflect.on("android.os.SystemProperties").call("set",propName,propNameValue).get();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public String getBluetoothAddr(Context context) {
        try {
            String bth = null;
            if (context != null)
                bth = android.provider.Settings.Secure.getString(context.getContentResolver(), "bluetooth_address");
            return bth != null ? bth : "null";
        } catch (SecurityException e) {
            return "No Permission";
        } catch (Exception e) {
            return "exception";
        }
    }

    public String getImei(Context context) {
        String imei = null;
        try {
            if (context == null)
                return "null";
            TelephonyManager tm = (TelephonyManager) context.getSystemService(Context.TELEPHONY_SERVICE);
            if (tm != null)
                imei = tm.getDeviceId();
            if (imei == null)
                imei = "null";
        } catch (SecurityException e) {
            imei = "No Permission";
        } catch (Exception e) {
            imei = "exception";
        }
        return imei;
    }

    public String getImsi(Context context) {
        String imsi = null;
        if (Build.VERSION.SDK_INT >= 21)
            imsi = getImeisAndImsi(context, "imsi");
        try {
            if (context == null)
                return "null";
            TelephonyManager tm = (TelephonyManager) context.getSystemService(Context.TELEPHONY_SERVICE);
            if (tm != null)
                imsi = tm.getSubscriberId();
            if (imsi == null)
                imsi = "null";
        } catch (SecurityException e) {
            imsi = "No Permission";
        } catch (Exception e) {
            imsi = "exception";
        }
        return imsi;
    }

    //API 在5.0以上
    public synchronized String getImeisAndImsi(Context context, String type) {
        String methodName = "";
        Class<?> clazz = null;
        JSONArray info = new JSONArray();
        if (context == null || type == null)
            return methodName;
        try {
            TelephonyManager tm = (TelephonyManager) context.getSystemService(Context.TELEPHONY_SERVICE);
            if (tm == null)
                return methodName;
            String msg1 = null, msg2 = null;
            if (getPermissionSafety(context, "android.permission.READ_PHONE_STATE") == PackageManager.PERMISSION_DENIED) {
                info.put("No Permission");
                return methodName;
            }

            if (type.equals("imei"))
                methodName = "getImei";
            if (type.equals("imsi"))
                methodName = "getSubscriberId";

            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {  //21
                clazz = tm.getClass();
                if (clazz != null) {
                    Method method = clazz.getDeclaredMethod(methodName, int.class);
                    msg1 = (String) method.invoke(tm, 0);
                    msg2 = (String) method.invoke(tm, 1);
                }
            }
            //deal : nex6p get two same imsi
            if (msg1 != null && msg2 != null && msg1.equals(msg2)) {
                info.put(msg1);
                return methodName;
            }
            if (msg1 != null)
                info.put(msg1);
            if (msg2 != null)
                info.put(msg2);
        } catch (Exception e) {
        }
        return methodName;
    }


    @SuppressLint("MissingPermission")
    public JSONArray getPhoneNumber(Context context) {
        JSONArray phoneNumber = new JSONArray();
        if (context == null)
            return phoneNumber;
        String number = null;
        if (getPermissionSafety(context, "android.permission.READ_PHONE_STATE") == PackageManager.PERMISSION_DENIED) {
            phoneNumber.put("No Permission");
            return phoneNumber;
        }
        if (Build.VERSION.SDK_INT > 22) {
            SubscriptionManager subscriptionManager = SubscriptionManager.from(context);
            if (subscriptionManager != null) {
                java.util.List<SubscriptionInfo> subsInfoList = subscriptionManager.getActiveSubscriptionInfoList();
                if (subsInfoList != null) {
                    for (SubscriptionInfo subscriptionInfo : subsInfoList) {
                        number = subscriptionInfo.getNumber();
                        phoneNumber.put(number);
                    }
                }
            }
        } else {
            TelephonyManager tm = (TelephonyManager) context.getSystemService(Context.TELEPHONY_SERVICE);
            if (tm != null)
                phoneNumber.put(tm.getLine1Number());
        }
        return phoneNumber;
    }

    public int getPermissionSafety(Context context, String permisson) {
        int ret = PackageManager.PERMISSION_DENIED;
        try {
            if (context != null)
                ret = context.getPackageManager().checkPermission(permisson, context.getPackageName());
        } catch (Exception e) {
        }
        return ret;
    }

    public HashMap getPropInfo() {
        HashMap hashMap = new HashMap();
        try {
            String allPropInfo = JniMethodUtils.jniExecCmd("getprop");
            if (allPropInfo == null)
                return hashMap;
            String[] propInfos = allPropInfo.split("\n");
            Pattern p = Pattern.compile("\\[(.*[^\\]])\\]*");
            for (String a_propInfo : propInfos) {
                String[] sub = a_propInfo.split(":", 2);
                if (sub.length != 2) {
                    continue;
                }
                String key = sub[0].trim();
                String value = sub[1].trim();
                Matcher m1 = p.matcher(key);
                Matcher m2 = p.matcher(value);
                if (m1.find()) {
                    key = m1.group(1);
                } else {
                    continue;
                }
                if (m2.find()) {
                    value = m2.group(1);
                } else {
                    value = "unknown";
                }
                hashMap.put(key, value);
            }
        } catch (Exception e) {
        }
        return hashMap;
    }

    /**
     * Java VM 虚拟机
     *
     * @return
     */
    public String getJavaVM() {
        String result = null;
        result = System.getProperty("java.vm.name");
        if (result != null) {
            result = result + System.getProperty("java.vm.version");
        }

        return result;
    }

    /**
     * 内核架构
     *
     * @return
     */
    public String getKernelArchitecture() {
        return System.getProperty("os.arch");
    }




}
