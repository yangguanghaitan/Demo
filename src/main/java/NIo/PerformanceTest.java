package NIo;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.ByteBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;

public class PerformanceTest {
    public static void main(String[] args) throws Exception {
        long starTime = System.currentTimeMillis();
        //获取文件输入流
        File file = new File("D:\\AAAA\\bbb\\cn_office_professional_plus_2013_x64_dvd_1134006.iso");//文件大小871 MB
        FileInputStream inputStream = new FileInputStream(file);
        //从文件输入流获取通道
        FileChannel inputStreamChannel = inputStream.getChannel();
        //获取文件输出流
        FileOutputStream outputStream = new FileOutputStream(new File("D:\\AAAA\\bbb\\cn_office_professional_plus_2013_x64_dvd_1134006copy.iso"));
        //从文件输出流获取通道
        FileChannel outputStreamChannel = outputStream.getChannel();
        //创建一个直接缓冲区
//        ByteBuffer byteBuffer = ByteBuffer.allocateDirect(5 * 1024 * 1024);//1774ms
        //创建一个直接缓冲区的父类映射缓冲区
        MappedByteBuffer byteBuffer = (MappedByteBuffer) ByteBuffer.allocateDirect(5 * 1024 * 1024);//1769ms
        //创建一个非直接缓冲区
//        ByteBuffer byteBuffer = ByteBuffer.allocate(5 * 1024 * 1024);//3391ms
        //写入到缓冲区
        while (inputStreamChannel.read(byteBuffer) != -1) {
            //切换读模式
            byteBuffer.flip();
            outputStreamChannel.write(byteBuffer);
            byteBuffer.clear();
        }
        //关闭通道
        outputStream.close();
        inputStream.close();
        outputStreamChannel.close();
        inputStreamChannel.close();
        long endTime = System.currentTimeMillis();
        System.out.println("消耗时间：" + (endTime - starTime) + "毫秒");
    }
}
