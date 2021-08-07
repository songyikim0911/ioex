package org.zerock.ex1practice;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class OneToOneServer {

    //bad code
    public static void main(String[] args) throws Exception {

        Scanner keyScanner = new Scanner(System.in);
        ServerSocket serverSocket = new ServerSocket(9999);

        System.out.println("Ready...");

        Socket client = serverSocket.accept();//소켓연결

        System.out.println("client connected...");

        InputStream in = client.getInputStream();
        OutputStream out = client.getOutputStream();

        Scanner inScanner = new Scanner(in);//inputstream과 연결된 스캐너

        for(int i = 0; i < 100; i++){

           String line = inScanner.nextLine();

            System.out.println(line);

            String myMsg = keyScanner.nextLine()+"\n";
            out.write(myMsg.getBytes());

        }//end for

        inScanner.close();
        in.close();
        client.close();
        serverSocket.close();



    }

}
