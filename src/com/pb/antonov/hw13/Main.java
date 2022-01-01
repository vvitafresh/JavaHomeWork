package com.pb.antonov.hw13;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println("Producer-Consumer work");
        List<String> buffer = new ArrayList<>();

        Thread prodThread = new Thread(new Producer(buffer,5));
        prodThread.start();
        prodThread.setName("Producer");

        Thread consThread = new Thread(new Consumer(buffer));
        consThread.start();
        consThread.setName("Consumer");

        try {
            Thread.sleep(500);
        }
        catch (Exception ex){
            System.out.println("Main interrupt (sleep)");
        }

        prodThread.interrupt();
        consThread.interrupt();

    }
}
