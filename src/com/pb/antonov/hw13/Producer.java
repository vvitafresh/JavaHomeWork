package com.pb.antonov.hw13;

import java.util.List;
import java.util.Random;

public class Producer implements Runnable {
    private List<String> buffer;
    private final int bufferSize;

    public Producer(List<String> buffer, int bufferSize) {
        this.buffer = buffer;
        this.bufferSize = bufferSize;
    }

    @Override
    public void run() {
        int counter = 0;
        while (!Thread.interrupted() && counter < 2022) {
            try {
                synchronized (buffer) {
                    if (buffer.size() < bufferSize) {
                        counter++;
                        Random rnd = new Random();
                        String num = String.valueOf(rnd.nextInt(100));
                        buffer.add(num);
                        System.out.printf("%s buffer.size=%d add element #[%d] value=%s%n", Thread.currentThread().getName(), buffer.size(), counter, num);
                        buffer.notifyAll();
                    } else {
                        System.out.println("Waiting for consumer");
                        buffer.wait();
                    }
                }
            }
            catch (InterruptedException ex){
                System.out.println("Interrupted Producer");
                break;
            }
        }
    }
}
