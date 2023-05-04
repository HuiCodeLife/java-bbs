package com.h.utils;

/**
 * @author: Lin
 * @since: 2023-05-04
 */
public class StringTools {
    public static Boolean isEmpty(String str) {
        if (null == str || "".equals(str.trim()) || "null".equals(str)){
            return true;
        }else {
            return false;
        }
    }
}
