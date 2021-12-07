package NIo.MappedByteBufferLearn;

import java.io.*;
import java.lang.reflect.Method;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.security.AccessController;
import java.security.PrivilegedAction;
import java.util.concurrent.LinkedBlockingQueue;


public class ReadThread extends Thread {

    private LinkedBlockingQueue fileNameList = null;
    private int thredId;

    ReadThread(int thredId) {
        super("aaaaa");
        this.thredId = thredId;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(100000000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        RandomAccessFile raf;
        FileChannel fChannel;
        MappedByteBuffer byteBuffer;
        int delCount = 0;
        try {
            while (true) {
                String pathname = (String) fileNameList.poll();
                if (null != pathname) {
                    File file = new File(pathname);
                    if (!file.exists()) {
                        for (int i = 0; i < 3; i++) {
                            System.out.println("读不到文件：" + file.getName());
                            Thread.sleep(1000);
                            file = new File(pathname);
                        }
                    }
                    raf = new RandomAccessFile(pathname, "r");
                    fChannel = raf.getChannel();
                    byteBuffer = fChannel.map(FileChannel.MapMode.READ_ONLY, 0,
                            raf.length());
                    // 用UTF-8进行解码为字符串
                    String bufString = Charset.forName("UTF-8")
                            .decode(byteBuffer).toString();
                    //文件内存映射清理，以防止文件无法删除
                    clean(byteBuffer);
                    System.gc();
                    //文件解析执行
                    System.out.println(bufString);
                    //文件关闭
                    raf.close();
                    fChannel.close();
                    File delFile = new File(pathname);
                    if (!file.exists()) {
                        continue;
                    }
                    if (!delFile.delete()) {
                        delCount++;
                        System.out.println(delFile.getName() + "删除不成功,已有" + delCount + "个文件删除不成功");
                    }else{
                        System.out.println(delFile.getName() + "删除成功");
                    }
                } else {
                    Thread.sleep(3000);
                }
            }
        } catch (IOException e) {
            System.out.println(thredId + ":" + getName());
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void clean(final MappedByteBuffer buffer) {
        if (null == buffer) {
            return;
        }
        AccessController.doPrivileged(new PrivilegedAction() {
            @Override
            public Object run() {
                try {
                    Method getCleanerMethod = buffer.getClass().getMethod(
                            "cleaner");
                    getCleanerMethod.setAccessible(true);
                    sun.misc.Cleaner cleaner = (sun.misc.Cleaner) getCleanerMethod
                            .invoke(buffer, new Object[0]);
                    cleaner.clean();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                return null;
            }
        });

    }

    public void setFileNameList(LinkedBlockingQueue fileNameList) {
        this.fileNameList = fileNameList;
    }
}
