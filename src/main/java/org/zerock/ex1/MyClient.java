package org.zerock.ex1;

import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.Socket;

public class MyClient {

    //bad code

    public static void main(String[] args) throws Exception{
        //입출력 3가지 규칙 ! 1) in=read, 2) out = write, 3) close꼭하기

        Socket socket = new Socket("127.0.0.1", 9999);

        System.out.println(socket);

        InputStream in = socket.getInputStream();
        FileOutputStream fos = new FileOutputStream("C:\\zzz\\get.jpg");

        byte[] buffer = new byte[1024*8];//버퍼만들기

        while(true){//루프를통해 버퍼에서 계속 데이터 읽기
            int count =in.read(buffer);//몇개나 새로운 데이터를 읽어들였는지.
            if(count == -1){break;}//새로운데이터 없으면 브레이크
            fos.write(buffer,0,count);//데이터 새로운데이터만큼 읽어오기

        }//end while


        fos.close();

        socket.close();

    }


}
