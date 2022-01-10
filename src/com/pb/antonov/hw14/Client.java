package com.pb.antonov.hw14;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) {
        int port = 7777;
        try {
            Socket socket = new Socket("localhost", port);
            System.out.println("Client is started...");
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter printWriter = new PrintWriter(socket.getOutputStream(), true);


            Scanner scanner = new Scanner(System.in);
            String s = scanner.nextLine();
            printWriter.println(s);
            System.out.println("Sending message to server: " + s);

            System.out.println("Waiting answer from server");
            String str;
            while ((str = bufferedReader.readLine()) != null) {
                if (str.contains("buy")) {
                    System.out.println("buy received, exiting...");
                    break;
                }
                System.out.println("Server: " + str);
                printWriter.println("buy");
            }
            bufferedReader.close();
            printWriter.close();
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
