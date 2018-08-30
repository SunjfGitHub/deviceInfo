package com.kkxl.deviceinfo.httpServer;

import java.util.List;
import java.util.Map;

/**
 * Created by hello on 18-8-24.
 */

public abstract class AbsHtml implements IhtmlTemplate {

    public AbsHtml(Map<String, List<String>> sessionParamters) {

    }

    @Override
    public String css(StringBuffer buffer) {
        return "";
    }

    @Override
    public String script(StringBuffer buffer) {
        return "";
    }

    @Override
    public StringBuffer mkHtml() {

        StringBuffer buffer = new StringBuffer();
        buffer.append("<html><head>");
        buffer.append("<style type=\"text/css\">");

        css(buffer);

        buffer.append("</style>");
        buffer.append("<script type=\"text/javascript\">");

        script(buffer);

        buffer.append("</script>");
        buffer.append("</head><body>");

        body(buffer);

        buffer.append("</body></html>");
        return buffer;
    }

}
