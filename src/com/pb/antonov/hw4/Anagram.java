/* 2. Создайте класс Anagram в пакете hw4.
Напишите программу, которая определяет, является ли одна строка анаграммой другой строки.
Обе строки вводит пользователь.
Анаграмма - это слово или фраза, сделанная путем переноса букв другого слова или фразы.
Программа должна игнорировать пробелы и знаки препинания.

Пример анаграмм:
Аз есмь строка, живу я, мерой остр. -> За семь морей ростка я вижу рост.
Я в мире — сирота. -> Я в Риме — Ариост.
При выполнении задания использовать метод(ы).

Еще примеры анаграмм:
Пойду, шаман, долиною! - Пой, душа, мандолиною!
Утро пылает догмой - у тропы лает дог мой.
И дико мне... - Иди ко мне!
Покалечилась - пока лечилась...
Ему же надо будет - ему жена добудет...
 */
package com.pb.antonov.hw4;
import java.util.Arrays;
import java.util.Scanner;

public class Anagram {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter first phrase: ");
        String str1 = scan.nextLine();
        System.out.println("Enter second phrase: ");
        String str2 = scan.nextLine();

        if(normalizeAnagram(str1).equals(normalizeAnagram(str2))){
            System.out.println("These phrases are anagrams.");
        }
        else{
            System.out.println("These phrases are NOT anagrams.");
        }

    }

    static String normalizeAnagram(String str){
        str = str.replaceAll("[^a-zA-Zа-яА-Я]", "").toLowerCase();
        char[] charArray = str.toCharArray();
        Arrays.sort(charArray);
        return Arrays.toString(charArray);
    }
}
