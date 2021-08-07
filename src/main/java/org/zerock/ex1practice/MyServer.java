package org.zerock.ex1practice;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class MyServer {


    //bad code 본래는 close 철저히 할 것
    public static void main(String[] args) throws Exception{

        ServerSocket serverSocket = new ServerSocket(9999);

        System.out.println("Ready...");

        while(true){
            //accept라는 행위를 함

            Socket client = serverSocket.accept(); //소켓 연결
            System.out.println(client);

            OutputStream out = client.getOutputStream();//아웃풋스트림연결
            //out.write(97);

            File file = new File("C:\\zzz\\image0802.jpg");


            //데이터 보낼때의 약속(프로토콜)
            out.write(new String("HTTP/1.1 200 OK\r\n").getBytes());
            out.write(new String("Cache-Control: private\r\n").getBytes());
            out.write(new String("Content-Length:" + file.length()+"\r\n").getBytes());//이 길이만큼 보낸다고
            //브라우저에게 약속하는것.
            out.write(new String("Content-Type: image/jpg;\r\n\r\n").getBytes());

            InputStream fin = new FileInputStream("C:\\zzz\\image0802.jpg");//데이터 읽기

            byte[] buffer = new byte[1024* 8];//버퍼만들기

            while (true) {//루프를통해 버퍼에서 계속 데이터 읽기
                int count = fin.read(buffer);//몇개나 새로운 데이터를 읽어들였는지.
                if(count == -1){break;}//새로운 데이터 없으면 브레이크
                out.write(buffer, 0, count);//새로운 데이터만큼 write(out)

            }//end while

            //client.close();//원래는 finally에서 해야 하는 close...
            //fin.close();


            //out.close();

        }//end while





    }

}
