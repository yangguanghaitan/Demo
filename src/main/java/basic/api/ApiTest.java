package basic.api;

import org.junit.Test;

import java.util.Enumeration;
import java.util.Properties;

/**
 * @Auther d
 * @Date 2022/5/2 11:12
 * @Describe 测试常见jdk api功能
 **/

public class ApiTest {

    /**
     * @author d
     * @date 2022/5/2 11:13
     * @Description  测试 {@link System#getProperties()} 返回的内容
     **/
    @Test
    public void testSystemProperties() {
        Properties properties = System.getProperties();
        Enumeration<?> e = properties.propertyNames();
        while (e.hasMoreElements()) {
            String key = (String) e.nextElement();
            String value = properties.getProperty(key);
            System.out.println(key + "======" + value);
        }
    }

}
