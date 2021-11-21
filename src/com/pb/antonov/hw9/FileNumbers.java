/*
В пакете hw9 создать класс FileNumbers.
В нем создать методы:

- createNumbersFile - создает текстовый файл "numbers.txt" заполненный случайными целыми числами от 1 до 99. 10 строк и по 10 чисел в каждой строке. Числа разделять пробелами.

- createOddNumbersFile - читает файл "numbers.txt", и создает на основе него новый файл "odd-numbers.txt" в который входят все числа из "numbers.txt" только все четные заменены на 0.

В методе main продемонстрировать работу методов createNumbersFile и createOddNumbersFile.

По желанию можно добавить логирование работы программы.
 */
package com.pb.antonov.hw9;

import java.util.Arrays;
import java.util.Random;

public class FileNumbers {
    public static void main(String[] args) {
        final String fileName = "numbers.txt";

        createNumbersFile(fileName);
        createOddNumbersFile(fileName);
    }

    public static void createNumbersFile(String fileName) {
        final int minNumber = 0;
        final int maxNumber = 99;

        Random rnd = new Random();
        int randNumber;

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < 100; i++) {
            if (i % 10 == 0 && i != 0) {
                sb.append("\n");
            }
            randNumber = rnd.nextInt(maxNumber + 1 - minNumber) + minNumber;
            sb.append(String.format("%2d", randNumber)).append(" ");
        }
        toFile(fileName, sb);
        String s = sb.toString();
        s = s.replaceAll(" {2,}", " ");
        System.out.println();
        System.out.println(s);
//        String[] arr = sb.toString().split(" ");
//        //String[] arr = {"a", "b", "c"};
//        System.out.println(Arrays.toString(arr));
    }

    public static void createOddNumbersFile(String fileName) {

    }

    private static boolean toFile(String fileName, StringBuilder sb) {
        System.out.println(sb);
        return true;
    }
}
