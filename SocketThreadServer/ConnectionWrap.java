package SocketThreadServer;

import java.io.*;
import java.net.Socket;
import java.util.Date;

class ConnectionWrap implements Runnable{

    private Socket socket = null;

    public ConnectionWrap(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {

        try {
            // ������ ���� ��Ʈ���� ���ɴϴ�.
            OutputStream stream = socket.getOutputStream();
            // �׸��� ���� ��¥�� ������ݴϴ�.
            stream.write(new Date().toString().getBytes());
            InputStream input = socket.getInputStream();
            /*InputStream input = socket.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(input));
            String line = reader.readLine();
            System.out.println(line);*/
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                socket.close(); // �ݵ�� �����մϴ�.
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}