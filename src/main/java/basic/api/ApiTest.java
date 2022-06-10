package basic.api;

import org.junit.Test;

import java.util.Arrays;
import java.util.Enumeration;
import java.util.List;
import java.util.Properties;

import static java.util.Arrays.asList;

/**
 * @Auther d
 * @Date 2022/5/2 11:12
 * @Describe 测试常见jdk api功能
 **/

public class ApiTest {


    /**
     * @author d
     * @date 2022/6/10 16:20
     * @Description 测试 {@link Arrays#copyOfRange(java.lang.Object[], int, int)} 复制的内容位置
     **/
    @Test
    public void testArrayscopyOfRange(){
        String[]  array={"1","3","5","7","8","9"};
        String[] tempArray = Arrays.copyOfRange(array, 2, array.length);
        List<String> list = asList(tempArray);
        System.out.println(list);
    }

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
