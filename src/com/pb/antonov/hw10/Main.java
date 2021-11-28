package com.pb.antonov.hw10;

public class Main {
    public static void main(String[] args) {
        System.out.println("Generics demo");

        NumBox<Float> numBoxFloat = new NumBox<Float>(5);
        NumBox<Integer> numBoxInt = new NumBox<Integer>(10);

        numBoxFloat.add(10.0f);
        numBoxFloat.add(10.1f);
        numBoxFloat.add(10.2f);
        numBoxFloat.add(10.3f);
        numBoxFloat.add(10.4f);
        //numBoxFloat.add(10.5f);   //ArrayIndexOutOfBoundsException

        numBoxInt.add(10);
        numBoxInt.add(11);
        numBoxInt.add(12);
        numBoxInt.add(13);
        numBoxInt.add(14);

        System.out.println("Floats:");
        for (int i = 0; i < numBoxFloat.length(); i++) {
            System.out.println(String.format("numBoxFloat[%d] = %f", i, numBoxFloat.get(i)));
        }
        System.out.println("Sum = " + numBoxFloat.sum());
        System.out.println("Average = " + numBoxFloat.average());
        System.out.println("Max = " + numBoxFloat.max());

        System.out.println("----------------------------------------------------");
        System.out.println("Integers:");
        for (int i = 0; i < numBoxInt.length(); i++) {
            System.out.println(String.format("numBoxFloat[%d] = %d", i, numBoxInt.get(i)));
        }
        System.out.println("Sum = " + numBoxInt.sum());
        System.out.println("Average = " + numBoxInt.average());
        System.out.println("Max = " + numBoxInt.max());
    }
}
