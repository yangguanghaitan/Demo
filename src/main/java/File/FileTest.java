package File;

import utils.Tools;

import java.io.*;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

/**
 * @author d
 * @date 2022/2/1 19:14
 * @Describe {@link OutputStreamWriter},内容输出控制台
 **/
public class FileTest {
    public static void main(String[] args) throws IOException {
        File file=new File("D:\\AAAA\\ccccc\\aa.txt");
        FileOutputStream out=new FileOutputStream(file,true);
        out.write("1234".getBytes("gbk"));
        out.write("6666".getBytes("gbk"));
        long l = file.lastModified();
        String s = Tools.convertTimeToString(1640699363518L);
        System.out.println(s);

        Writer out1 = new OutputStreamWriter(System.out);
        out1.write(66);
        out1.write("asd");
        out1.write("asdfgh",3,3);
        out1.write(new char[]{'a','g','k','l','o'},2,2);
        out1.write(new char[]{'a','g'});
        out1.flush();
    }

}
