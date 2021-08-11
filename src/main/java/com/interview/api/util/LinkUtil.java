package com.interview.api.util;

import com.interview.api.exception.link.InvalidUrlFormatException;

import java.util.StringTokenizer;
import java.util.regex.Pattern;

public class LinkUtil {

    private static final String URL_FORMAT = "^((http|https)://)?(www.)?([a-zA-Z0-9]+)\\.{1}[a-z]+([a-zA-Z0-9])/?([a-zA-Z0-9.-[=_$%+&~;:'\"]]/?)+";
    private static final String DELIMITER = ":";
    private static final String[] PROTOCOL = {"https:", "//", ""};

    public static String buildUrlForSave(String url){
        validateUrlFormat(url);
        StringBuilder urlFormatted = new StringBuilder();
        boolean isContainsProtocol = isContainsProtocol(url);

        urlFormatted.append(PROTOCOL[0])
                .append(isContainsProtocol ? PROTOCOL[2]: PROTOCOL[1]);

        StringTokenizer token = new StringTokenizer(url, DELIMITER);
        if(isContainsProtocol) token.nextToken();

        while(token.hasMoreTokens()) {
            urlFormatted.append(token.nextToken());
        }
        return urlFormatted.toString();
    }

    public static void validateUrlFormat(String url){
        if(!Pattern.matches(URL_FORMAT,url)){
            throw new InvalidUrlFormatException();
        }
    }

    public static boolean isContainsProtocol(String url){
        return url.contains(PROTOCOL[1]);
    }





}
