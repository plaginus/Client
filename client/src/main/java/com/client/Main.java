package com.client;

import java.net.*;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.*;

public class Main {

   public static void main(String [] args) {
      
      String serverName = "PK";
      int port = 6066;
      try {
         System.out.println("Подключение к " + serverName + " на порт " + port);
         Socket client = new Socket(serverName, port);
         
         System.out.println("Просто подключается к " + client.getRemoteSocketAddress());
         OutputStream outToServer = client.getOutputStream();

         DataOutputStream out = new DataOutputStream(outToServer);
         out.writeUTF("Привет из " + client.getLocalSocketAddress());
         
         InputStream inFromServer = client.getInputStream();
         DataInputStream in = new DataInputStream(inFromServer);
         ObjectMapper objectMapper = new ObjectMapper();

         ComputerEquipment ce1 = objectMapper.readValue(in.readUTF(), ComputerEquipment.class);
         Laptop l1 = objectMapper.readValue(in.readUTF(), Laptop.class);
         Desktop d1 = objectMapper.readValue(in.readUTF(), Desktop.class);
         PDA pda1 = objectMapper.readValue(in.readUTF(), PDA.class);

         System.out.println(in.readUTF());
         client.close();

         ce1.Show();
         l1.Show();
         d1.Show();
         pda1.Show();
         
      } catch (IOException e) {
         e.printStackTrace();
      }

   }
}