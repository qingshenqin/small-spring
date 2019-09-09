package com.ynx.framework.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * 描述：
 *
 * @author karl
 * @date 2019/9/9 16:35
 */
public class PropsUtil {
   private static Logger logger = LoggerFactory.getLogger(PropsUtil.class);

    /**
     * 以类的根目录做为根目录load去Properties
     * @param propsPath
     * @return
     */
    public static Properties loadProps(String propsPath) {
        assert propsPath !=null;
        Properties properties = new Properties();

        String suffix = ".properties";
        if (propsPath.lastIndexOf(suffix) == -1){
            propsPath += suffix;
        }
        InputStream is = PropsUtil.class.getClassLoader().getResourceAsStream(propsPath);
        try {
            properties.load(is);
        } catch (IOException e) {
            logger.error("加载属性文件{}出错",propsPath,e);
            throw new RuntimeException(e);
        }finally {
            try {
                if (is != null){
                    is.close();
                }
            } catch (IOException e) {
                is = null;
                logger.error("释放资源出错",e);
            }

        }
        return properties;
    }
    public static String getString(Properties properties ,String key){
        return properties.getProperty(key);
    }

    public static String getString(Properties properties ,String key,String defaultValue){
        return properties.getProperty(key,defaultValue);
    }
    public static int getInt(Properties properties,String key){

        String ret = properties.getProperty(key);
        Integer value = Integer.valueOf(ret);
        return value;
    }
}
