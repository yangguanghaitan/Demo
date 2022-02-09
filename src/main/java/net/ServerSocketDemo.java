package net;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @Auther d
 * @Date 2022/2/9 17:11
 * @Describe 测试 {@link ServerSocket} 单线程处理多个请求，轮流来; 注释的类是多线程处理多个请求
 **/
public class ServerSocketDemo {
    public static void main(String[] args) {
        try (ServerSocket server=new ServerSocket(6688)){
            while (true){
                try (Socket accept = server.accept()){
                    Writer writer=new OutputStreamWriter(accept.getOutputStream());
                    writer.write("AAAA");
                    Thread.sleep(9000);
                    writer.flush();
                    accept.close();
                }catch (Exception e){

                }

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

////多线程处理多个请求
//public class ServerSocketDemo {
//    public static void main(String[] args) throws IOException{
//        ServerSocket server=new ServerSocket(6688);
//        while (true){
//            Socket accept = server.accept();
//            new Thread(
//                    new Runnable() {
//                        @Override
//                        public void run() {
//                            try {
//                                Writer writer=new OutputStreamWriter(accept.getOutputStream());
//                                writer.write("AAAA");
//                                Thread.sleep(9000);
//                                writer.flush();
//                                accept.close();
//                            } catch (IOException e) {
//                                e.printStackTrace();
//                            } catch (InterruptedException e) {
//                                e.printStackTrace();
//                            }
//                        }
//                    }).start();
//        }
//    }
//}