package algorithm.snow;

import org.junit.Test;
import utils.Tools;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Auther d
 * @Date 2024/7/19 16:52
 * @Describe
 **/
public class DemoBinary {
    public static void main(String[] args) {
        DemoBinary demo=new DemoBinary();
        String dateByLongTime = Tools.getDateByLongTime(3776831255552L);
        System.out.println(dateByLongTime);//2089-09-06 15:47:35

    }

    @Test
    public void testGetTwoBinaryAndBitLengthByTen(){
        System.out.println(Tools.getTwoBinaryAndBitLengthByTen(9999999999999999L));
    }

    @Test
    public void testAll(){
        System.out.println(Tools.getTwoBinaryAndBitLengthByTen(9999999999999999L));
        System.out.println(Tools.getMaxByBitLength(8));//255
        System.out.println(Tools.getMax2ByBitLength(8));//255
    }



}
