package NIo;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.util.Arrays;

public class BUfferTest {
    //分散读取和聚合写入
    public static void main(String[] args) throws Exception {
        File file = new File("1.txt");
        FileInputStream inputStream = new FileInputStream(file);
        FileChannel inputStreamChannel = inputStream.getChannel();
        FileOutputStream outputStream = new FileOutputStream(new File("2.txt"));
        FileChannel outputStreamChannel = outputStream.getChannel();
        //创建三个缓冲区，分别都是5
        ByteBuffer byteBuffer1 = ByteBuffer.allocate(5);
        ByteBuffer byteBuffer2 = ByteBuffer.allocate(5);
        ByteBuffer byteBuffer3 = ByteBuffer.allocate(5);
        //创建一个缓冲区数组
        ByteBuffer[] buffers = new ByteBuffer[]{byteBuffer1, byteBuffer2, byteBuffer3};
        //循环写入到buffers缓冲区数组中，分散读取
        long read;
        long sumLength = 0;
        while ((read = inputStreamChannel.read(buffers)) != -1) {
            sumLength += read;
            Arrays.stream(buffers)
                    .map(buffer -> "posstion=" + buffer.position() + ",limit=" + buffer.limit())
                    .forEach(System.out::println);
            //切换模式
            Arrays.stream(buffers).forEach(Buffer::flip);
            //聚合写入到文件输出通道
            outputStreamChannel.write(buffers);
            //清空缓冲区
            Arrays.stream(buffers).forEach(Buffer::clear);
        }
        System.out.println("总长度:" + sumLength);
        //关闭通道
        outputStream.close();
        inputStream.close();
        outputStreamChannel.close();
        inputStreamChannel.close();
    }




    //通道间的数据传输
    /*
    public static void main(String[] args) throws Exception {
        File file = new File("1.txt");
        FileInputStream inputStream = new FileInputStream(file);
        FileChannel inputStreamChannel = inputStream.getChannel();
        FileOutputStream outputStream = new FileOutputStream(new File("2.txt"));
        FileChannel outputStreamChannel = outputStream.getChannel();
        ByteBuffer byteBuffer = ByteBuffer.allocate((int) file.length());

        //A to B
        inputStreamChannel.transferTo(0, byteBuffer.limit(), outputStreamChannel);
        //B from A
        outputStreamChannel.transferFrom(inputStreamChannel,0,byteBuffer.limit());
        //关闭通道
        outputStream.close();
        inputStream.close();
        outputStreamChannel.close();
        inputStreamChannel.close();
    }
    */



    //ServerSocketChannel传输
    /*
    public static void main(String[] args) throws Exception {
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        InetSocketAddress address = new InetSocketAddress("127.0.0.1", 6666);
        serverSocketChannel.bind(address);
        //创建一个缓冲区
        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
        while (true) {
            //获取SocketChannel
            SocketChannel socketChannel = serverSocketChannel.accept();
            while (socketChannel.read(byteBuffer) != -1){
                System.out.println(new String(byteBuffer.array()));
                //清空缓冲区
                byteBuffer.clear();
            }
        }
    }
    */


    //FileChannel文件复制
    /*
    public static void main(String[] args) throws Exception {
        File file = new File("1.txt");
        FileInputStream inputStream = new FileInputStream(file);
        //从文件输入流获取通道
        FileChannel inputStreamChannel = inputStream.getChannel();

        FileOutputStream outputStream = new FileOutputStream(new File("2.txt"));
        //从文件输出流获取通道
        FileChannel outputStreamChannel = outputStream.getChannel();
        ByteBuffer byteBuffer = ByteBuffer.allocate((int)file.length());
        //把输入流通道的数据读取到缓冲区
        inputStreamChannel.read(byteBuffer);
        //切换成读模式
        byteBuffer.flip();
        //把数据从缓冲区写入到输出流通道
        outputStreamChannel.write(byteBuffer);
        //关闭通道
        outputStream.close();
        inputStream.close();
        outputStreamChannel.close();
        inputStreamChannel.close();
    }
    */


    //ByteBuffer读写数据
    /*
    public static void main(String[] args) {
        String msg = "j术！";
        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
        System.out.println("初始化"+byteBuffer);
        byte[] bytes = msg.getBytes();
        byteBuffer.put(bytes);
        System.out.println("写模式"+byteBuffer);
        //切换成读模式，关键一步
        byteBuffer.flip();
        System.out.println("读模式"+byteBuffer);
        //创建一个临时数组，用于存储获取到的数据
        byte[] tempByte = new byte[bytes.length];
        int i = 0;
        //如果还有数据，就循环。循环判断条件
        while (byteBuffer.hasRemaining()) {
            byte b = byteBuffer.get();
            tempByte[i] = b;
            i++;
            System.out.println("读"+i+"次  "+byteBuffer);
        }
        System.out.println(new String(tempByte));//j术！
    }
    */

    //创建堆内内存块HeapByteBuffer
    /*
    ByteBuffer byteBuffer1 = ByteBuffer.allocate(1024);
    String msg = "java技术爱好者";
    //包装一个byte[]数组获得一个Buffer，实际类型是HeapByteBuffer
    ByteBuffer byteBuffer2 = ByteBuffer.wrap(msg.getBytes());

    //创建堆外内存块DirectByteBuffer
    ByteBuffer byteBuffer3 = ByteBuffer.allocateDirect(1024);
    public static void main(String[] args) {
        BUfferTest bUfferTest=new BUfferTest();
        System.out.println(bUfferTest.byteBuffer1);
        System.out.println(bUfferTest.byteBuffer2);
        System.out.println(bUfferTest.byteBuffer3);
    }
    */
}
