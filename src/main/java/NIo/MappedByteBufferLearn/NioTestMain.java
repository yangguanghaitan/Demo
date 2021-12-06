package NIo.MappedByteBufferLearn;



import java.util.concurrent.LinkedBlockingQueue;

//https://blog.csdn.net/bird_tp/article/details/108408378
public class NioTestMain {

    public static void main(String[] args) {
        int num = 3;
        LinkedBlockingQueue[] fileNameList = new LinkedBlockingQueue[num];
        for (int i = 0; i < fileNameList.length; i++) {
            fileNameList[i] = new LinkedBlockingQueue<String>();
        }
        WriteThread[] writeThreads = new WriteThread[num];
        for (int i = 0; i < writeThreads.length; i++) {
            writeThreads[i] = new WriteThread(i);
            writeThreads[i].setFileNameList(fileNameList[i]);
            writeThreads[i].start();
        }
        ReadThread[] readThreads = new ReadThread[num];
        for (int i = 0; i < fileNameList.length; i++) {
            readThreads[i] = new ReadThread(i);
            readThreads[i].setFileNameList(fileNameList[i]);
            readThreads[i].start();
        }
    }
}
