package org.zerock.ex1;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

public class KeyInOut {

    public static void main(String[] args) {
        InputStream in = System.in;
        OutputStream out = null;
        try {
            out = new FileOutputStream("C:\\zzz\\test.txt");

            for(int i =0; i < 10; i++){
                int data = in.read(); //1byte의 내용을 읽는다. read할 값이 없는 경우는 -1이된다.
                out.write(data);

            }

        } catch (Exception e){
            e.printStackTrace();
        } finally {
            if( out != null){
                try{ out.close(); } catch (Exception e){}
            }
            if( in != null){
                try{ in.close(); } catch (Exception e){}
            //close는 반드시 따로 해주는게 정석이다. 위에 겹쳐서 적게 될 경우 out.close가 안될떄 in.close도 같이 실행안된다.
            }
        }
    }


}
