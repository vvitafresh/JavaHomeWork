package com.pb.antonov.hw14;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.time.LocalDateTime;

public class Server {
    public static void main(String[] args) {
        int port = 7777;
        try {
            ServerSocket srvSocket = new ServerSocket(port);
            while (true) {
                System.out.println("Waiting for connection on port " + port);
                Socket clnSocket = srvSocket.accept();
                System.out.println("Client connected");

                try (Socket localSocket = clnSocket;
                     PrintWriter out = new PrintWriter(localSocket.getOutputStream(), true);
                     BufferedReader in = new BufferedReader(new InputStreamReader(localSocket.getInputStream()))
                ) {
                    String str;
                    while ((str = in.readLine()) != null) {
                        System.out.println("The message: " + str);
                        if (str.equals("bue")) {
                            out.println("Buy");
                            break;
                        } else {
                            LocalDateTime localDateTime = LocalDateTime.now();
                            str = localDateTime.toString() + " - " + str;
                            out.println(str);
                        }
                    }
                } catch (IOException ex) {
                    System.out.println("Can't connect");
                    ex.printStackTrace(System.out);
                    System.exit(-1);
                }
            }
        } catch (IOException ex) {
            ex.printStackTrace(System.out);
        }
    }
}
