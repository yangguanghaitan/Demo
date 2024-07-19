package zhonghang;

import org.junit.Test;

import java.math.BigInteger;

/**
 * @Auther d
 * @Date 2024/6/5 9:30
 * @Describe
 **/
public class SnowFlakeDemo {


    @Test
    public void testA(){
        //41位二进制最小值
        String minTimeStampStr = "00000000000000000000000000000000000000000";
        //41位二进制最大值
        String maxTimeStampStr = "11111111111111111111111111111111111111111";
        //转10进制
        long minTimeStamp = new BigInteger(minTimeStampStr, 2).longValue();
        long maxTimeStamp = new BigInteger(maxTimeStampStr, 2).longValue();
        //一年总共多少毫秒
        long oneYearMills = 1L * 1000 * 60 * 60 * 24 * 365;
        //算出最大可以多少年
        System.out.println((maxTimeStamp - minTimeStamp) / oneYearMills);
    }
}
