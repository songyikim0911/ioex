package org.zerock.ex1practice;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;

public class EchoClient {
    //bad code
    public static void main(String[] args) throws Exception {

        Scanner keyScanner = new Scanner(System.in);

        while(true){

            System.out.println("Input your message");
            String msg = keyScanner. nextLine();

            if(msg.equalsIgnoreCase("exit")){
                break;
            }


            Socket socket = new Socket("127.0.0.1", 9999);//lazy지연연결, 최대한 연결을 미루다가 필요한 순간에 연결
            //이래야 여러명이 한 서버에 연결할 수 있게 된다. http 프로토콜의 중요한 특징!
            InputStream in = socket.getInputStream();
            Scanner inScanner = new Scanner(in);
            OutputStream out = socket.getOutputStream();

            String sendMsg = msg + "\n";
            out.write(sendMsg.getBytes());//전송 완료
            System.out.println(inScanner.nextLine());


            out.close();
            inScanner.close();
            in.close();
            socket.close();


        }//end while

    }

}
