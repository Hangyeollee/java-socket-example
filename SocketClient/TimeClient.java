package SocketClient;

import java.io.*;
import java.net.Socket;
import java.net.UnknownHostException;

public class TimeClient {
    /*public static void main(String [] args){
        *//*if(args.length < 1){
            System.out.println("Argument is null");
            return;
        }
        String domainName = args[0];*//*
        String domainName = "asd";
        String hostname = "localhost";
        int port = 8888;

        try(Socket socket = new Socket(hostname,port)) {
            OutputStream output = socket.getOutputStream();
            PrintWriter writer = new PrintWriter(output,true);
            writer.println(domainName);
            InputStream input = socket.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(input));

            String line;
            while((line = reader.readLine()) != null){
                System.out.println(line);
            }
        } catch (UnknownHostException e) {
            System.out.println("Server not found");
        } catch (IOException e) {
            System.out.println("Server not found");
        }
    }*/
    public static void main(String [] args){
        String hostname = "localhost";
        int port = 8888;
        for(int i = 0; i < 10; i++){
            try(Socket socket = new Socket(hostname,port)) {
                OutputStream output = socket.getOutputStream();
                String test = "aaaa";
                output.write(test.getBytes());
                InputStream input = socket.getInputStream();
                BufferedReader reader = new BufferedReader(new InputStreamReader(input));

                String line = reader.readLine();
                System.out.println(line);
            } catch (UnknownHostException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
