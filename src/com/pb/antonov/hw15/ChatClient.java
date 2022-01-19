package com.pb.antonov.hw15;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.net.Socket;


public class ChatClient extends JFrame {
    private int port = 7777;

    private BufferedReader bufferedReader;
    private PrintWriter printWriter;

    private JTextArea txtArea;
    private JTextField txtField;
    private JButton btnSend;

    public ChatClient(){
        initCompontnts();
        //this.setVisible(true);
    }

    public void initCompontnts(){
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);


        JPanel p = new JPanel();
        this.add(p);
        //p.setLayout(new BorderLayout());
        p.setLayout(null);

        txtArea = new JTextArea("");
        txtArea.setLineWrap(true);
        txtArea.setBounds(0,0,500,400);
        p.add(txtArea);

        txtField = new JTextField("Send this message");
        txtField.setBounds(0,410,385,20);
        p.add(txtField);

        btnSend = new JButton("Send");
        btnSend.setBounds(390,410,90,20);
        p.add(btnSend);

        this.setSize(500, 490);
        this.setVisible(true);

        btnSend.addActionListener(new ActionListener() {
                                      @Override
                                      public void actionPerformed(ActionEvent e) {
                                          sendMessage(txtField.getText());
                                      }
                                  }
        );
    }

    public void startRunning(){
        //TODO start network communication

        try {
            Socket socket = new Socket("localhost", port);
            txtArea.append("Client is started...\n");
            bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            printWriter = new PrintWriter(socket.getOutputStream(), true);


            //System.out.println("Waiting answer from server");
            txtArea.append("Waiting answer from server\n");
            String str;
            while ((str = bufferedReader.readLine()) != null) {
                if (str.contains("buy")) {
                    //System.out.println("buy received, exiting...");
                    txtArea.append("Disconnected form server");
                    break;
                }
                //System.out.println("Server: " + str);
                txtArea.append("Server: " + str + "\n");
                //printWriter.println("buy");
            }
            bufferedReader.close();
            printWriter.close();
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void sendMessage(String messageText){
        //TODO Send message

        txtArea.append("Sending message to server: ");
        txtArea.append(messageText + "\n");
        txtField.setText("");
        txtField.requestFocus();
        printWriter.println(messageText);
    }
}
