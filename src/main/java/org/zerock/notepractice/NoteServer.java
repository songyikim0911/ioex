package org.zerock.notepractice;

import com.google.gson.Gson;

import java.io.DataInputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class NoteServer {
//bad code
    public static void main(String[] args) throws Exception {


        NoteService service = new NoteService();

        //serversocket

        ServerSocket serverSocket = new ServerSocket(9999);
        System.out.println("Ready....");


        //loop
        while (true) {
            Socket socket = serverSocket.accept();
            DataInputStream dataInputStream =
                    new DataInputStream(socket.getInputStream());
            String msg = dataInputStream.readUTF();

            Gson gson = new Gson();
            Command command = gson.fromJson(msg, Command.class);
            System.out.println(command);

            String oper = command.getOper();

            if (oper.equalsIgnoreCase("ADD")) {
                service.add(command.getNoteDTO());
            } else if (oper.equalsIgnoreCase("READ")) {
                String owner = command.getNoteDTO().getWhom();
                System.out.println(service.getList(owner));
            }

        }

    }

}
