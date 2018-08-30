package com.kkxl.deviceinfo.httpServer;

import android.util.Log;

import com.kkxl.deviceinfo.BuildInfo;
import com.kkxl.deviceinfo.util.Utils;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.List;
import java.util.Set;


public class HttpdSevices extends NanoHTTPD {

    public HttpdSevices(int port) {
        super(port);
    }

    public HttpdSevices(String hostname, int port) {
        super(hostname, port);
    }


    @Override
    public Response serve(IHTTPSession session) {
        Log.i("http", "====getQueryParameterString:" + session.getQueryParameterString() +
                "\n ====getRemoteHostName:" + session.getRemoteHostName() +
                "\n ====getRemoteIpAddress:" + session.getRemoteIpAddress() +
                "\n ====getUri:" + session.getUri() +
                "\n ====getHeaders:" + session.getHeaders().toString() +
                "\n ====getMethod:" + session.getMethod() +
                "\n ====getParms:" + session.getParms().toString());


        IhtmlTemplate html = null;
        switch (session.getUri()) {
            case IhtmlTemplate.BUILD_REQ:
                html = new HtmlDefault(session.getParameters());
                break;

            default:
                html = new HtmlDefault(session.getParameters());
                break;
        }


        return newFixedLengthResponse(html.mkHtml().toString());
    }

}
