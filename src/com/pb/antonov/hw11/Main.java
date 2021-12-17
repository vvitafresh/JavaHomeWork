package com.pb.antonov.hw11;



import com.sun.deploy.util.StringUtils;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;

import static com.pb.antonov.hw11.StrUtil.rightPadding;

public class Main {
    static ArrayList<Person> persons;



    public static void main(String[] args) {
        System.out.println("Main module");
        String s = rightPadding("Main Menu", 25);
        System.out.println(s + "ggg");

        persons = new ArrayList<Person>(
                Arrays.asList(
                    new Person("Иван Петров",
                            LocalDate.of(1988, 12, 21),
                            new ArrayList<String>(Arrays.asList("0997093133")),
                            "Харьков, ул. Главная 1",
                            LocalDateTime.now()
                    ),
                    new Person("Виталий Антонов",
                            LocalDate.of(1979, 6, 25),
                            new ArrayList<String>(Arrays.asList("0687093010", "0971234567")),
                            "Херсон, ул. Потемкинская 20",
                            LocalDateTime.now()
                    ),
                    new Person("Нина Андреева",
                            LocalDate.of(1999, 7, 1),
                            new ArrayList<String>(Arrays.asList("0669876541")),
                            "Никополь, ул. Никопольская 10",
                            LocalDateTime.now()
                    ),
                    new Person("Ксюша Рыжеева",
                            LocalDate.of(2001, 2, 3),
                            new ArrayList<String>(Arrays.asList("0976548732")),
                            "Киев, ул. Театральная 11",
                            LocalDateTime.now()
                    ),
                    new Person("Ахмет Ахметов",
                            LocalDate.of(1968, 3, 23),
                            new ArrayList<String>(Arrays.asList("0981326545", "0971234576")),
                            "Харьков, ул. Главная 1",
                            LocalDateTime.now()
                    )
                ));
//        System.out.println(persons.toString());

        mainConsoleMenu();

    }

    public static void printMenu(String[] options) {
//        cleanConsole();
        System.out.println("Меню");
        for (String option : options) {
            System.out.println(option);
        }
        System.out.print("Сделайте выбор: ");
    }

    public static void cleanConsole() {
        for (int i = 0; i < 15; i++) {
            System.out.println(); //clean console
        }
    }

    public static void mainConsoleMenu() {
        cleanConsole();
        String[] options = {"1- Добавить контакт",
                "2- Найти контакт (удалить, редактировать)",
                "3- Отобразить весь список (сортировка)",
                "4- Выход",
        };
        Scanner scanner = new Scanner(System.in);
        int option = 1;
        while (option != 4) {
            printMenu(options);
            try {
                option = scanner.nextInt();
                switch (option) {
                    case 1:
                        addContact();
                        break;
                    case 2:
                        searchContact();
                        break;
                    case 3:
                        listContacts();
                        break;
                    case 4:
                        exitApp();
                        break;
                }
            } catch (InputMismatchException ex) {
                System.out.println("Введите целое число между 1 и " + options.length);
                scanner.next();
            } catch (Exception ex) {
                System.out.println("Неизвестная ошибка");
                scanner.next();
            }
        }
    }

    public static void addContact() {
        cleanConsole();
        System.out.println("Добавить контакт:");
        Scanner scanner = new Scanner(System.in);
        String s = scanner.next();
    }

    public static void searchContact() {
        cleanConsole();
        System.out.println("Найти контакт");
        System.out.println("Введите ФИО: ");
        Scanner scanner = new Scanner(System.in);
        String fio = scanner.next();

        Person p = new Person("Виталий Антонов", LocalDate.now());
        int index = persons.indexOf(p);
        System.out.println("indexOf " + index);
        if(index>-1){
            System.out.println("Контакт найден:");
            System.out.println(persons.get(index).toString());
        }

    }

    public static void listContacts() {
        System.out.println("Отобразить весь список");
        for (Person p :
                persons) {
            System.out.println("ФИО: " + p.getFio());
        }

        persons.sort(
                new Comparator<Person>() {
                    @Override
                    public int compare(Person o1, Person o2) {
                        return o1.getFio().compareTo(o2.getFio());
                    }
                }
        );
        System.out.println(persons.toString());
    }

    public static void exitApp() {

    }
}
