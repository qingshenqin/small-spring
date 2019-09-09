package com.ynx.framework;

import com.ynx.framework.core.ConfigHelper;
import com.ynx.framework.util.PropsUtil;
import org.junit.Test;

import java.util.Properties;

/**
 * 描述：
 *
 * @author karl
 * @date 2019/9/9 17:00
 */
public class PropsUtilsTest {
    @Test
    public void testLoadProps(){
        Properties properties = PropsUtil.loadProps("test.properties");
        Object hello = properties.getProperty("hello");
        System.out.println(hello);
    }
    @Test
    public void testGetString(){
        int anInt = ConfigHelper.getInt("test.rmb");
        System.out.println(anInt);

    }
}
