package com.pb.antonov.hw14;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.time.LocalDateTime;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Server {

    static class Handler implements Runnable {

        private final Socket socket;

        public Handler(Socket socket) {
            this.socket = socket;
        }


        @Override
        public void run() {
            //
            try {
                System.out.println(Thread.currentThread().getName() + " connected");
                try (Socket localSocket = this.socket;
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
            catch (Exception ex){
                ex.printStackTrace();
            }
            finally {
                try {
                    socket.close();
                }
                catch (Exception ex){
                    // Ignore
                }
            }
        }
    }

    public static void main(String[] args) throws Exception {
        int port = 7777;
        ServerSocket serverSocket = new ServerSocket(port);
        System.out.println("Server started. Port: " + port);
        ExecutorService threadPool = Executors.newFixedThreadPool(10);

        System.out.println("Waiting for client");
        while (true) {
            Socket clientSocket = serverSocket.accept();
            threadPool.submit(new Handler(clientSocket));
        }
    }

}
