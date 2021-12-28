package File;

import utils.Tools;

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
        String s = Tools.convertTimeToString(1640699363518L);
        System.out.println(s);
    }

}
