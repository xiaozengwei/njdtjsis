package com.gx.core.export;

public class StringUtils {
    public static boolean isEmpty(Object str) {
        return !(str != null && str.toString().length() > 0);
    }
}
