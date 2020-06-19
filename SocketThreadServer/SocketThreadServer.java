package SocketThreadServer;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SocketThreadServer {
    private static final int PORT = 8888;
    // ������ Ǯ�� �ִ� ������ ������ �����մϴ�.
    private static final int THREAD_CNT = 5;
    private static ExecutorService threadPool = Executors.newFixedThreadPool(THREAD_CNT);
    public static void main(String[] args) {

        try {
            // �������� ����
            ServerSocket serverSocket = new ServerSocket(PORT);
            System.out.println("listen");
            // ���ϼ����� ����ɶ����� ���ѷ���
            while(true){
                // ���� ���� ��û�� �ö����� ����մϴ�.

                Socket socket = serverSocket.accept();
                try{
                    // ��û�� ���� ������ Ǯ�� ������� ������ �־��ݴϴ�.
                    // ���Ĵ� ������ ������ ó���մϴ�.
                    threadPool.execute(new ConnectionWrap(socket));
                }catch(Exception e){
                    e.printStackTrace();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
