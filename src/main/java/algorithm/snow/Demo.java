package algorithm.snow;

import utils.Tools;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Auther d
 * @Date 2024/7/19 16:52
 * @Describe
 **/
public class Demo {
    public static void main(String[] args) {
        Demo demo=new Demo();
        String dateByLongTime = Tools.getDateByLongTime(3776831255552L);
        System.out.println(dateByLongTime);//2089-09-06 15:47:35

    }




}
