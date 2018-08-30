package com.kkxl.deviceinfo.httpServer;

import android.util.Log;
import com.kkxl.deviceinfo.BuildInfo;
import com.kkxl.deviceinfo.infoManager.InfoManager;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Created by hello on 18-8-24.
 */

public final class HtmlDefault extends AbsHtml {

    private Map<String, List<String>> reqSessionParams;

    public HtmlDefault(Map<String, List<String>> sessionParamters) {
        super(sessionParamters);
        this.reqSessionParams = sessionParamters;


        Set<String> keys = sessionParamters.keySet();
        for (String k : keys) {
            List<String> list = sessionParamters.get(k);
            Log.i("http", "\n ==getParameters-key:" + k + "\n ===getParameters-val:" + list.get(0).toString());
        }


        for (String key : reqSessionParams.keySet()) {
            for (int i = 0; i < BuildInfo.List.length; i++) {
                if (key.equals(BuildInfo.List[i][0])) {
                    if (reqSessionParams.get(key) == null)
                        break;
                    InfoManager.getInstance().setProperty(key, reqSessionParams.get(key).get(0));
                }
            }
        }
    }


    @Override
    public String body(StringBuffer buffer) {

        String caption = String.format("Build.java属性总量:%d.", BuildInfo.List.length);
        String[] theadArray = {"属性描述", "key", "value"};


        buffer.append("<center><h1>手机基本属性展示</h1>");
        buffer.append("<h3>" + caption + "</h3>");

        String[][] arr = BuildInfo.List;
        if (arr.length > 0) {
            buffer.append("<table border=\"1\">");
//thead===========================================
            buffer.append("<thead>");
            buffer.append("<tr>");

            for (int i = 0; i < theadArray.length; i++) {
                buffer.append("<th>");
                buffer.append(theadArray[i]);
                buffer.append("</th>");
            }

            buffer.append("</tr>");
            buffer.append("</thead>");
//tbody =======================================
            buffer.append("<tbody/* width=\"100%\"*/>");

            for (int i = arr.length - 1; i > 0; i--) {

                buffer.append("<tr align=\"left\">");

                buffer.append("<th>");
                buffer.append(arr[i][1]);
                buffer.append("</th>");

                buffer.append("<th>");
                buffer.append(arr[i][0]);
                buffer.append("</th>");

                buffer.append("<th>");
                buffer.append(InfoManager.getInstance().getProperty(arr[i][0]));
                buffer.append("</th>");

                buffer.append("</tr>");
            }
            buffer.append("</tbody>");
//tfoot=========================================
            buffer.append("</table>");
        }
        buffer.append("</center>");
        return null;
    }

}
