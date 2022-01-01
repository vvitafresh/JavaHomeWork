package com.pb.antonov.hw13;

import java.util.List;

public class Consumer implements Runnable{
    private List<String> buffer;

    public Consumer(List<String> buffer) {
        this.buffer = buffer;
    }

    @Override
    public void run() {
        synchronized (buffer){
            while (!Thread.interrupted()){
                try {
                    if(!buffer.isEmpty()){
                        System.out.println(Thread.currentThread().getName() + " removed value=" + buffer.remove(0));
                        buffer.notifyAll();
                    }
                    else {
                        System.out.println("Waiting for Producer");
                        buffer.wait();
                    }

                }
                catch (InterruptedException ex){
                    System.out.println("Interrupted consumer!!!");
                    break;
                }
            }
        }

    }
}
