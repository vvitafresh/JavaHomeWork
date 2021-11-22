/*
В пакете hw9 создать класс FileNumbers.
В нем создать методы:
- createNumbersFile - создает текстовый файл "numbers.txt" заполненный случайными целыми числами от 1 до 99. 10 строк и по 10 чисел в каждой строке. Числа разделять пробелами.
- createOddNumbersFile - читает файл "numbers.txt", и создает на основе него новый файл "odd-numbers.txt" в который входят все числа из "numbers.txt" только все четные заменены на 0.
В методе main продемонстрировать работу методов createNumbersFile и createOddNumbersFile.
По желанию можно добавить логирование работы программы.
 */
package com.pb.antonov.hw9;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Random;

public class FileNumbers {
    public static void main(String[] args) {
        final String fileNameNumbers = "files/numbers.txt";
        final String fileNameOddNumbers = "files/odd-numbers.txt";

        createNumbersFile(fileNameNumbers);
        createOddNumbersFile(fileNameNumbers, fileNameOddNumbers);
    }

    public static void createNumbersFile(String fileName) {
        final int minNumber = 0;
        final int maxNumber = 99;

        Random rnd = new Random();
        int randNumber;

        StringBuilder sbRandNumbers = new StringBuilder();

        for (int i = 0; i < 100; i++) {
            if (i % 10 == 0 && i != 0) {
                sbRandNumbers.append("\n");
            }
            randNumber = rnd.nextInt(maxNumber + 1 - minNumber) + minNumber;
            sbRandNumbers.append(String.format("%2d ", randNumber));
        }
        toFile(fileName, sbRandNumbers);
    }

    public static void createOddNumbersFile(String fileNameNumbers, String fileNameOddNumbers) {
        StringBuilder sbFromFile = fromFile(fileNameNumbers);
        toFile(fileNameOddNumbers, sbFromFile);
    }

    private static StringBuilder fromFile(String fileName) {
        StringBuilder sb = new StringBuilder();
        Path path = Paths.get(fileName);

        // read from file
        System.out.println("Read text from file \"" + path.toAbsolutePath());
        try (BufferedReader reader = Files.newBufferedReader(path)) {
            String line;
            while ((line = reader.readLine()) != null) {
                sb.append(replaceOddNumbers(removeMultipleSpaces(line.trim()))).append("\n");
            }
        } catch (Exception ex) {
            System.out.println("Error with file read: " + ex);
        }
        System.out.println("Read from file done!");
        return sb;
    }

    private static boolean toFile(String fileName, StringBuilder sb) {
        Path path = Paths.get(fileName);

        // write to file
        try (BufferedWriter writer = Files.newBufferedWriter(path)) {
            writer.write(sb.toString());
        } catch (Exception ex) {
            System.out.println("Error with file write: " + ex);
        }
        System.out.println("Write to file \"" + path.toAbsolutePath() + "\" done!");
        return true;
    }

    private static String replaceOddNumbers(String stringLine) {
        String stringNoOdds = "";
        String[] arrStrings = stringLine.split(" ");
        for (String s : arrStrings) {
            try {
                int i = Integer.parseInt(s);
                if (i % 2 == 0) {
                    i = 0;
                }
                stringNoOdds += String.format("%2d ", i);
            } catch (NumberFormatException ex) {
                // Skip
            }
        }
        return stringNoOdds;
    }

    private static String removeMultipleSpaces(String s) {
        return s.replaceAll(" {2,}", " ");
    }
}
