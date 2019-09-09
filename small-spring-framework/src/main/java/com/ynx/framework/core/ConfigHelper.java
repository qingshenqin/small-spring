package com.ynx.framework.core;

import com.sun.xml.internal.ws.policy.spi.AssertionCreationException;
import com.ynx.framework.FrameworkConstant;
import com.ynx.framework.util.PropsUtil;

import java.util.Properties;

/**
 * 描述：
 *
 * @author karl
 * @date 2019/9/9 17:33
 */
public class ConfigHelper {
    private ConfigHelper(){
        throw new RuntimeException("非法创建");
    }

    /**
     * 属性文件对象
     */
    private static final Properties CONFIG_FILE = PropsUtil.loadProps(FrameworkConstant.CONFIG_PROPS);
    public static String getString(String key){
        return PropsUtil.getString(CONFIG_FILE,key);
    }
    public static String getString(String key ,String defaultValue){
        return PropsUtil.getString(CONFIG_FILE,key,defaultValue);
    }
    public static int getInt(String key){
        return PropsUtil.getInt(CONFIG_FILE,key);
    }
}
