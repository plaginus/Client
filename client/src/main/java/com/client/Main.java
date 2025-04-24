package com.client;

public class Main {

   public static void main(String [] args) {
      try{
         for (int i = 0; i < 5; i++){
            new Client(i).start();
            Thread.sleep((i) * 200);
         }
      } catch (InterruptedException e){
         e.printStackTrace();
      }
   }
}