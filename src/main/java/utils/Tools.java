package utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class Tools {
    //long到时间日期
    public static String convertTimeToString(Long time){
        DateTimeFormatter ftf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        return ftf.format(LocalDateTime.ofInstant(Instant.ofEpochMilli(time), ZoneId.systemDefault()));
    }
    //根据时间戳获取日期
    public static String getDateByLongTime(long longTime){
        Date date=new Date(longTime);
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return simpleDateFormat.format(longTime);
    }
    //根据字符串日期获取时间戳
    public static long getLongTimeByStrdate(String date){
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date parse = simpleDateFormat.parse(date);
            return parse.getTime();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return 0L;
    }
    //获取10进制转化为二进制后的二进制数和二进制位数
    public static String getTwoBinaryAndBitLengthByTen(long tenBinary){
        String s = Long.toBinaryString(tenBinary);
        return tenBinary+"这个数的二进制是"+s+",共有"+s.length()+"位";
    }
    //求已知bit位数的最大值，符号位位0,假如3位，结果表示0b1000-1
    public static long getMaxByBitLength(long bitLength){
        return ((1L<<bitLength)-1);
    }
    //求已知bit位数的最大值，符号位位0，假如3位，结果表示000000...0111
    public static long getMax2ByBitLength(long bitLength){
        return ~(-1L<<bitLength);
    }
    //分开主从workId后的，已知workIdBitLength时主分区的workIdBound的获取方法
    public static long  getWorkIdBound(long workIdBitLength){
        return 1L<<(workIdBitLength-1);//return ~(-1<<(workIdBitLength-1))+1;
    }
    //已知seqBitLength，获取对应位数的掩码
    public static long getMaskBySeqBitLength(long seqBitLength){
        return ~(-1L<<seqBitLength);//return (1L<<seqBitLength)-1;
    }

    //已知机器id的bit位数获取workIdBound
//    public static long getWorkIdBound(long workIdBitLength){
//        return (1L<<workIdBitLength)-1;
//    }
}
