package com.kkxl.deviceinfo.httpServer;

import android.annotation.SuppressLint;

/**
 * Created by hello on 18-8-24.
 */

public interface IhtmlTemplate {


    String css(StringBuffer buffer);

    String script(StringBuffer buffer);

    String body(StringBuffer buffer);

    StringBuffer mkHtml();

    final String BUILD_REQ = "build";
}
