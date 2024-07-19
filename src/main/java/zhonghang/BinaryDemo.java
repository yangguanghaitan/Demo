package zhonghang;

import org.junit.Test;

/**
 * @Auther d
 * @Date 2024/5/30 15:35
 * @Describe
 **/
public class BinaryDemo {

    /**
     * @author d
     * @date 2024/5/30 15:35
     * @Description 二进制运算，雪花算法中,workId 12位的最大值,（2~20位）
     **/
    @Test
    public void test(){
        int wordIdLength=12;
        long l = ~(-1L << (wordIdLength - 1));
        System.out.println(l);
    }


}
