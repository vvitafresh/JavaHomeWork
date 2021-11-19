/*
Создать пакет hw8.
Создать класс Auth, который содержит поля login и password и методы:

- signUp (регистрация на сайте) принимающий login, password, и confirmPassword.
Проверяет параметр login, длинна должна быть от 5 до 20 символов. Login должен содержать только латинские буквы и цифры. Если логин не соответствует требованиям нужно выбросить WrongLoginException.
Проверяет параметр password, длинна более 5, только латинские буквы и цифры и знак подчеркивания. Также password и confirmPassword должны совпадать. Если password не соответствует требованиям нужно выбросить WrongPasswordException.
Если проверки все пройдены успешно записать в свои поля значение login и password. Так сохраняем пользователя :)

- signIn (вход на сайт) принимающий login и password.
Проверяет что login и password соответствуют значениям из полей класса.
Если нет - выбрасывает исключение WrongLoginException.

WrongPasswordException и WrongLoginException - пользовательские классы исключения с двумя конструкторами – один по умолчанию, второй принимает сообщение и передает его в конструктор класса Exception.

Создать класс OnlineShop с методом main.
В main создать один объект класса Auth.
Предложить пользователю сперва зарегистрироваться (signUp) потом войти на сайт (signIn).
Обработать исключения методов signUp signIn с помощью блоков try-catch.

 */
package com.pb.antonov.hw8;

import java.util.Scanner;

public class OnlineShop {
//    static final String defaultLogin = "DefaultUser";
//    static final String defaultPassword = "DefaultUserPassword";
    static Auth auth = new Auth();

    public static void main(String[] args) {

        simulateSignUp();
        simulateLogIn();
    }

    private static void simulateSignUp(){
        Scanner scan = new Scanner(System.in);
        String userLogin, pass, passConfirm;

        System.out.println("Simulating of new user SignUP...");
        System.out.print("Enter new user login: ");
        userLogin = scan.next();

        System.out.print("Enter user password: ");
        pass = scan.next();

        System.out.print("Confirm user password: ");
        passConfirm = scan.next();


        try {
            if (auth.signUp(userLogin, pass, passConfirm)) {
                System.out.printf("SignUp of user %s was successful!%n", auth.getLogin());
            }
        } catch (WrongLoginException ex) {
            System.out.println("Wrong Login: " + ex.getMessage());
        } catch (WrongPasswordException ex) {
            System.out.println("Wrong Password: " + ex.getMessage());
        }
    }

    private static void simulateLogIn(){
        Scanner scan = new Scanner(System.in);
        String userLogin, pass;

        System.out.println();
        System.out.println("Simulating of user Logging In process...");
        System.out.print("Enter user login: ");
        userLogin = scan.next();

        System.out.print("Enter user password: ");
        pass = scan.next();

        System.out.println();
        try {
            if (auth.signIn(userLogin, pass)) {
                System.out.println(auth.getLogin() + " successfully logged in.");
            } else {
                System.out.println("LogIn failed!");
            }
        } catch (WrongLoginException ex) {
            System.out.println("Wrong Login: " + ex.getMessage());
        }
    }

}
