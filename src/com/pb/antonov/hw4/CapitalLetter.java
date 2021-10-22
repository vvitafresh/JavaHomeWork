/* 1. Создайте класс CapitalLetter в пакете hw4.
Напишите программу, которая принимает строку и переводит первую букву слова в верхний регистр.
Строку должен ввести пользователь.
Пример работы:
Истина — это то, что выдерживает проверку опытом. Эйнштейн А.
Истина — Это То, Что Выдерживает Проверку Опытом. Эйнштейн А.
При выполнении задания использовать метод(ы).
 */
package com.pb.antonov.hw4;

import java.util.Locale;
import java.util.Scanner;

public class CapitalLetter {
    public static void main(String[] args) {
        System.out.println(capitalizeFirstLetters(getUserString()));
    }

    static String getUserString(){
        //String userString = "Истина — это то, что выдерживает проверку опытом. Эйнштейн А.";
        System.out.println("Enter your string: ");
        Scanner scan = new Scanner(System.in);
        return scan.nextLine();
    }

    static String capitalizeFirstLetters(String originalString) {
        String newString = "";
        boolean isItSpace = true;

        for (char c : originalString.toCharArray()
        ) {
            newString += isItSpace ? String.valueOf(c).toUpperCase() : String.valueOf(c);
            isItSpace = String.valueOf(c).equals(" ");
        }
        return newString;
    }
}
