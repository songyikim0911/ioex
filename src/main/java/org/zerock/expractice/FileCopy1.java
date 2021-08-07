package org.zerock.expractice;

import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;


public class FileCopy1 {

    //bad code..

    public static void main(String[] args) throws Exception {

        URL url = new URL("https://cdn.011st.com/11dims/resize/900x900/quality/75/11src/cat/20/4/5/7/8/8/2/FYCUv/33457882_1.jpg");
        InputStream in = url.openStream();

        System.out.println(in);

        OutputStream out = new FileOutputStream("C:\\zzz\\copy.jpg");

        while(true){
            int data = in.read();
            if(data==-1){break;}
            out.write(data);
        }


    }

}
