package NIo.MappedByteBufferLearn;


import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.util.concurrent.LinkedBlockingQueue;


public class WriteThread extends Thread {

    private int threadId;

    private LinkedBlockingQueue fileNameList;

    WriteThread(int threadId) {
        this.threadId = threadId;
    }

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            long time = System.currentTimeMillis();
            String testMsg = "线程" + threadId + "测试写入数据"+i+"时间为"+  time;
            byte[] bytes = testMsg.getBytes();
            String fileName = threadId + "-" +i+"-"+ time;
            FileChannel fChannel;
            RandomAccessFile file;
            long fileLength = 0L;
            MappedByteBuffer buffer;
            try {
                file = new RandomAccessFile(  "testFile/"+fileName + ".tmp", "rw");
                fChannel = file.getChannel();
                //文件内存映射
                buffer = fChannel.map(FileChannel.MapMode.READ_WRITE, fileLength, bytes.length);
                System.gc();
                buffer.put(bytes);
                file.close();
                fChannel.close();
                fileNameList.add( fileName + ".tmp");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void setFileNameList(LinkedBlockingQueue fileNameList) {
        this.fileNameList = fileNameList;
    }
}
