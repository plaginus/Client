package com.client;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;

public class Client extends Thread {
    public Client(int number){
        super("Client - " + number);
        this.number = number;
    }

    private int number;
    private String serverName = "PK";
    private int port = 6066;
      
    public void run(){
        try {
         System.out.println("Подключение к " + serverName + " на порт " + port + ", клиент номер - " + number);
         Socket client = new Socket(serverName, port);
         
         InputStream inFromServer = client.getInputStream();
         DataInputStream in = new DataInputStream(inFromServer);
         String input = in.readUTF();

         while (input != "close") {
            System.out.println(in.readUTF()  + ", клиент номер - " + number);
         }
         client.close();
      } catch (IOException e) {
        System.out.println("Отключение");
        // e.printStackTrace();
      }
    }
}
