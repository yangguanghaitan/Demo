package algorithm.snow;

import org.junit.Test;
import utils.Tools;

import java.sql.Timestamp;

/**
 * @Auther d
 * @Date 2024/7/19 16:58
 * @Describe
 **/
public class TimeTest {
    //long beginTime = Tools.getLongTimeByStrdate(Constants.beginTime);//1577808000000=>2020-01-01
//System.out.println("abc".substring(1));//bc
    @Test
    public void f() {
        System.out.println(Long.toBinaryString(1577808000000L));
        System.out.println(Long.toBinaryString(3776831255552L).substring(1));
        System.out.println(Long.toBinaryString(3776831255552L - 1577808000000L - 1));

    }

    @Test
    public void f2() {
        System.out.println(new Timestamp(1577808000000L));
    }

    /**
     * @param bitPosition 截取时间戳bit位的位数
     * @date 2024/7/19 17:39
     * @Description 计算自1577808000000L开始,时间戳后bitPosition bit位相同的时间戳
     **/
    public long nextSameBit(int bitPosition) {
        return 0L;
    }
}
