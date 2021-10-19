/* 2. Создайте класс Array в пакете hw3.Программа должна позволить пользователю ввести одномерный массив целых чисел размерностью 10 элементов.
Вывести на экран введенный массив.
Подсчитать сумму всех элементов массива и вывести ее на экран.
Подсчитать и вывести на экран количество положительных элементов.
Произвести сортировку этого массива от меньшего к большему по алгоритму сортировки пузырьком. (https://en.wikipedia.org/wiki/Bubble_sort)
Вывести на экран отсортированный массив.
 */
package com.pb.antonov.hw3;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Array {
    public static void main(String[] args) {
        final int arraySize = 10;
        int[] a = new int[arraySize];

        int sum = 0;
        int countPositive = 0;

        Random rnd = new Random();
        Scanner scan = new Scanner(System.in);

        for (int i = 0; i < arraySize; i++) {
            a[i] = rnd.nextInt(101) - 50;
//            System.out.print("Enter A[" + i + "]: ");
//            a[i]=scan.nextInt();
            sum = sum + a[i];
            if (a[i] > 0) {
                countPositive++;
            }
        }
        System.out.println("Original array: " + Arrays.toString(a));

        // Bubble sort
        for (int j = 0; j < arraySize - 1; j++) {
            for (int i = 0; i < arraySize - 1; i++) {
                if (a[i] > a[i + 1]) {
                    int x = a[i];
                    a[i] = a[i + 1];
                    a[i + 1] = x;
                }
            }
        }

//        for (int i = 0; i < arraySize; i++) {
//            System.out.println("a[" + i + "]=" + a[i]);
//        }

        System.out.println("Sorted array: " + Arrays.toString(a));
        System.out.println("Sum = " + sum);
        System.out.println("Number of positive elements = " + countPositive);
    }
}
