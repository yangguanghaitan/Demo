package File;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

public class FileTest {
    public static void main(String[] args) throws IOException {
        File file=new File("D:\\AAAA\\ccccc\\aa.txt");
        FileOutputStream out=new FileOutputStream(file,true);
        out.write("1234".getBytes("gbk"));
        out.write("6666".getBytes("gbk"));
        long l = file.lastModified();
        String s = convertTimeToString(l);
        System.out.println(s);
    }
    //long到时间日期
    public static String convertTimeToString(Long time){
        DateTimeFormatter ftf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        return ftf.format(LocalDateTime.ofInstant(Instant.ofEpochMilli(time), ZoneId.systemDefault()));
    }
}
