package org.zerock.expractice;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;

public class FileCopy2 {

    public static void main(String[] args) throws IOException {

      File file = new File("C:\\zzz\\aaa.jpg");

      Path filePath = file.toPath();

      OutputStream out = new FileOutputStream("C:\\zzz\\copy2.jpg");

      Files.copy(filePath, out);


    }
}
