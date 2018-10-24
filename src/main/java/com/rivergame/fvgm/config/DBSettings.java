package com.rivergame.fvgm.config;


import com.alibaba.druid.util.StringUtils;

import java.util.PropertyResourceBundle;
import java.util.ResourceBundle;

public class DBSettings {

    protected static ResourceBundle source = PropertyResourceBundle.getBundle("db-"+ConstantConfig.profile);

    private static ResourceBundle localSource;

    static {
        try {
            localSource = PropertyResourceBundle.getBundle("db-"+ConstantConfig.profile);
        } catch (Exception ignored) {
            localSource = null;
        }
    }

    public static int getIntProperty(String key) {
        return Integer.valueOf(source.getString(key));
    }

    public static boolean getBooleanProperty(String key) {
        return Boolean.valueOf(source.getString(key));
    }


    public static String getProperty(String key) {
        if (localSource != null) {
            String val = localSource.getString(key);
            if (!StringUtils.isEmpty(val)) {
                return val;
            }
        }
        return source.getString(key);
    }
}
