package com.pb.antonov.hw12;

import com.pb.antonov.hw12.Person;

import java.io.*;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

import static com.pb.antonov.hw12.StrUtil.*;

public class Main {
    static ArrayList<com.pb.antonov.hw12.Person> persons;

    public static void main(String[] args) {
        File file = Paths.get("files/person.data").toFile();
        if (file.exists()){
            System.out.println("Saved Address Book found");
            loadFromFile();
        }
        else{
            initAddressBook();
        }
        mainConsoleMenu();
    }


    public static void mainConsoleMenu() {
        cleanConsole();
        String[] options = {"1: Добавить контакт",
                "2: Найти контакт (удалить, редактировать)",
                "3: Отобразить весь список (сортировка)",
                "4: Сохранить в файл",
                "5: Загрузить из файла",
                "6: Выход",
        };
        Scanner scanner = new Scanner(System.in);
        int option = 1;
        while (option != 6) {
            printMenu(options, "==========    Главное Меню   ==========");
            try {
                option = scanner.nextInt();
                switch (option) {
                    case 1:
                        addEditContact(-1);     //  -1 => add new Item
                        break;
                    case 2:
                        searchContact();
                        break;
                    case 3:
                        listContacts();
                        break;
                    case 4:
                        saveToFile();
                        break;
                    case 5:
                        loadFromFile();
                        break;
                    case 6:
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

    public static void listAndSortMenu() {
//        cleanConsole();
        String[] options = {"1: Отобразить с сортировкой по ФИО",
                "2: Отобразить с сортировкой по дате рождения",
                "3: Возврат в главное меню",
                "4: Выход",
        };
        Scanner scanner = new Scanner(System.in);
        int option = 1;
        while (option != 3) {
            printMenu(options, "==========    Сортировка   ==========");
            try {
                option = scanner.nextInt();
                switch (option) {
                    case 1:
                        listPersonsWithSorting(1);
                        break;
                    case 2:
                        listPersonsWithSorting(2);
                        break;
                    case 3:
                        cleanConsole();
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

    public static void editAndDeleteMenu(int selectedItem) {
//        cleanConsole();
        System.out.println("Выбран: " + persons.get(selectedItem).getFio());
        String[] options = {"1: Редактировать контакт",
                "2: Удалить контакт",
                "3: Возврат в главное меню",
                "4: Выход",
        };
        Scanner scanner = new Scanner(System.in);
        int option = 1;
        while (option != 3) {
            printMenu(options, "==========    Редактирование/Удаление   ==========");
            try {
                option = scanner.nextInt();
                switch (option) {
                    case 1:
                        addEditContact(selectedItem);   // Edit item with index = selectedItem
                        break;
                    case 2:
                        deleteContact(selectedItem);
                        break;
                    case 3:
                        cleanConsole();
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
            cleanConsole();
            break;
        }

    }

    public static void printMenu(String[] options, String menuTitle) {
//        cleanConsole();
        System.out.println(menuTitle);
        for (String option : options) {
            System.out.println(option);
        }
        System.out.print("Сделайте выбор: ");
    }

    public static void cleanConsole() {
        for (int i = 0; i < 20; i++) {
            System.out.println(); //clean console
        }
    }

    private static void pressEnterKeyToContinue() {
        System.out.println("Нажмите Enter чтобы продолжить...");
        try {
            System.in.read();
            cleanConsole();
        } catch (Exception e) {
        }
    }


    public static void initAddressBook() {
        persons = new ArrayList<com.pb.antonov.hw12.Person>(
                Arrays.asList(
                        new com.pb.antonov.hw12.Person("Леонардо ди Каприо",
                                LocalDate.of(1974, 11, 11),
                                new ArrayList<String>(Arrays.asList("+19687093010", "+18971234567")),
                                "Лос-Анджелес, Калифорния"
                        ),
                        new com.pb.antonov.hw12.Person("Кристен Джеймс Стюарт",
                                LocalDate.of(1990, 4, 9),
                                new ArrayList<String>(Arrays.asList("10669876541")),
                                "Лос-Анджелес, США"
                        ),
                        new com.pb.antonov.hw12.Person("Эмма Ватсон",
                                LocalDate.of(1990, 4, 15),
                                new ArrayList<String>(Arrays.asList("70976548732")),
                                "Мезон-Лаффит, Франция"
                        ),
                        new com.pb.antonov.hw12.Person("Джонни Депп",
                                LocalDate.of(1963, 6, 9),
                                new ArrayList<String>(Arrays.asList("+1997093133")),
                                "Оуэнсборо, Кентукки"
                        ),
                        new com.pb.antonov.hw12.Person("Хейден Лесли Панеттьер",
                                LocalDate.of(1989, 8, 21),
                                new ArrayList<String>(Arrays.asList("+1997093133")),
                                "Палисейдс, Нью-Йорк, США"
                        ),
                        new com.pb.antonov.hw12.Person("Том Хэнкс",
                                LocalDate.of(1968, 3, 23),
                                new ArrayList<String>(Arrays.asList("70981326545", "70971234576")),
                                "Конкорд, Калифорния"
                        )
                ));
    }

    public static void addEditContact(int index) {
        cleanConsole();
        System.out.println("Добавить контакт:");

        System.out.print("Введите ФИО: ");
        Scanner scanner = new Scanner(System.in);
        String fio = scanner.nextLine();

        System.out.print("Введите дату рождения (год-месяц-число): ");
        String strDateOfBirth = scanner.nextLine();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate dateOfBirth = LocalDate.parse(strDateOfBirth, formatter);


        System.out.print("Введите телефоны (через запятую): ");
        String phone = scanner.nextLine();
        ArrayList<String> phonesList = new ArrayList<String>(Arrays.asList(phone.split(",")));

        System.out.print("Введите адрес: ");
        String address = scanner.nextLine();

        com.pb.antonov.hw12.Person pers = new com.pb.antonov.hw12.Person(fio, dateOfBirth, phonesList, address);
        if(index < 0)
        {
            // Add new item
            persons.add(pers);
            System.out.println("Новый контакт добавлен");
        }
        else {
            // Edit item
            persons.set(index, pers);
            System.out.println("Данные сохранены");
        }
        pressEnterKeyToContinue();
    }

    public static void deleteContact(int index) {
        String fio = persons.get(index).getFio();
        persons.remove(index);
        System.out.println("Удален: " + fio);
        pressEnterKeyToContinue();
    }

    public static void searchContact() {
        cleanConsole();
        System.out.println("Найти контакт");
        System.out.println("Введите ФИО: ");
        Scanner scanner = new Scanner(System.in);
        String fio = scanner.nextLine();

//        Person p = new Person("Виталий Антонов", LocalDate.now());
        System.out.println(String.format("Ищем по ФИО '%s' ...", fio));
        com.pb.antonov.hw12.Person p = new com.pb.antonov.hw12.Person(fio, LocalDate.now());
        int index = persons.indexOf(p);
        if (index > -1) {
            System.out.println("Контакт найден:");
            System.out.println(delimiterLine(80));
            System.out.println(persons.get(index).toConsole());
            System.out.println(delimiterLine(80));
            editAndDeleteMenu(index);
        } else {
            System.out.println("Контакт НЕ найден!");
        }
//        pressEnterKeyToContinue();
    }

    public static void listContacts() {
        System.out.println("Отобразить весь список:");
        listPersonsWithSorting(0);
        listAndSortMenu();
    }

    public static void listPersonsWithSorting(int sortOrder) {
        //TODO Use enum for sortOrder
        System.out.println(delimiterLine(80));
        switch (sortOrder) {
            case 1:
                //TODO Replace .sort with lambda
                persons.sort(
                        (o1, o2) -> o1.getFio().compareTo(o2.getFio())
                );
                break;
            case 2:
                //TODO Replace .sort with lambda
                persons.sort(
                        (o1, o2) -> o1.getDateOfBirth().compareTo(o2.getDateOfBirth())
                );
                break;
        }
        for (com.pb.antonov.hw12.Person p :
                persons) {
            System.out.println(p.toConsole());
            System.out.println(delimiterLine(80));
        }
    }

    public static void saveToFile(){
        System.out.println("Сохранение в файл");
        File file = Paths.get("files/person.data").toFile();
        try {
            FileOutputStream outputStream = new FileOutputStream(file);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);

            objectOutputStream.writeObject(persons);
            objectOutputStream.close();
        }
        catch (Exception ex){
            System.out.println(ex.toString());
            System.out.println(ex.getMessage().toString());
        }
        cleanConsole();
        System.out.println("Сохранение в файл завершено");
        pressEnterKeyToContinue();
    }

    public static void loadFromFile(){
        System.out.println("Загрузка из файла");

        File file = Paths.get("files/person.data").toFile();
        try {
            FileInputStream fileInputStream = new FileInputStream(file);
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);

            persons = (ArrayList<Person>) objectInputStream.readObject();

            System.out.println(persons);
        }
        catch (Exception ex){
            System.out.println(ex.toString());
        }

    }

    public static void exitApp() {
        System.exit(0);
    }
}
