package guide.collection.map;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @Auther d
 * @Date 2022/3/26 0:43
 * @Describe
 **/
public class ConcurrnetHashMapTest {
    /**
     * @author d
     * @date 2022/3/26 0:45
     * @Description 源码分析
     **/
    @Test
    public  void putMap1(){
        ConcurrentHashMap map = new ConcurrentHashMap();
        Map hashMap=new HashMap();
        hashMap.put("a1","1");
        hashMap.put("a2","2");
        hashMap.put("a3","3");
        hashMap.put("a4","4");
        hashMap.put("a5","5");
        hashMap.put("a6","6");
        hashMap.put("a7","7");
        hashMap.put("a8","8");
        hashMap.put("a9","9");
        hashMap.put("a10","10");
        hashMap.put("a11","11");
        hashMap.put("a12","12");
        hashMap.put("a13","13");
        System.out.println(hashMap);
        Object a1 = hashMap.get("a1");
        System.out.println(a1);
    }
}
