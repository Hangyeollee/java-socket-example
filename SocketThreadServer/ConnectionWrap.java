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
            // 응답을 위해 스트림을 얻어옵니다.
            OutputStream stream = socket.getOutputStream();
            // 그리고 현재 날짜를 출력해줍니다.
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
                socket.close(); // 반드시 종료합니다.
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}