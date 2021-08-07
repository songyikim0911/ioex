package org.zerock.expractice;

import java.io.File;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.file.Files;

public class Server2 {



    //bad code
    public static void main(String[] args) throws Exception {

      ServerSocket serverSocket = new ServerSocket(9999);

        System.out.println("Ready...");
//누군가 연결될때까지 멈춰 있는 상황 = blocked

        for (int i = 0; i < 10; i++ ){
            Socket client = serverSocket.accept();
            System.out.println(client);
            File file = new File("C:\\zzz\\2.html");
            OutputStream out = client.getOutputStream();
            String msg = "<h1>Hello world</h1>";
            out.write(new String("HTTP/1.1 200 OK\r\n").getBytes());
            out.write(new String("Cache-Control: private\r\n").getBytes());
            out.write(new String("Content-Length:" + file.length()+"\r\n").getBytes());
            out.write(new String("Content-Type: text/html; charset=UTF-8\r\n\r\n").getBytes());

            Files.copy(file.toPath(), out);
        }

    }


}
