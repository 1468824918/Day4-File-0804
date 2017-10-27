package com.lanou.utils;

import sun.misc.BASE64Encoder;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

/**
 * Created by dllo on 17/10/26.
 */
public class FIleNameEncoder {
    public static String filenameEncoding(String filename, HttpServletRequest request) throws UnsupportedEncodingException {
        String agent = request.getHeader("User-Agent");
        if (agent.contains("Firefox")) {
            BASE64Encoder base64Encoder = new BASE64Encoder();
            filename = "=?utf-8?B?" + base64Encoder.encode(filename.getBytes("utf-8")) + "?=";
        } else if (agent.contains("MSIE")) {
            filename = URLEncoder.encode(filename, "utf-8");
        } else if (agent.contains("Safari")) {
            filename = new String(filename.getBytes("UTF-8"), "ISO8859-1");
        } else {
            filename = URLEncoder.encode(filename, "utf-8");
        }
        return filename;
    }

}

