package org.zerock.ex1;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;

public class OneToOneClient {

    //bad code
    public static void main(String[] args) throws Exception{


        Scanner keyScanner = new Scanner(System.in);//keyboard에서 입력한 글자를 스캔, 키스캐너
        Socket socket = new Socket("127.0.0.1",9999);

        System.out.println("Connected...");

        OutputStream out = socket.getOutputStream();
        InputStream in = socket.getInputStream();
        Scanner inScanner = new Scanner(in);


        for(int i = 0; i < 100; i++){
            //문자열을 byte[]로 바꿔서, out.write(바이트배열)
            String msg= keyScanner.nextLine()+"\n";// \n이 서버에서 받아들일떄 필요해서 추가한것임. (scanner.nextLine을 이용했기 때문)

            out.write(msg.getBytes());
            System.out.println("------------------------------");
            System.out.println(inScanner.nextLine());

        }//end for

        out.close();
        socket.close();


    }

}
