package com.pb.antonov.hw11;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Main module");

        List<Person> persons = Arrays.asList(
                new Person("Виталий Антонов",
                        LocalDate.of(1979,6,25),
                        new ArrayList<String>(Arrays.asList("0687093010","0971234567")),
                        "Херсон, ул. Потемкинская 20}",
                        LocalDateTime.now()
                ),
                new Person("Иван Петров",
                        LocalDate.of(1988,12,21),
                        new ArrayList<String>(Arrays.asList("0687093010","0971234567")),
                        "Харьков, ул. Главная 1",
                        LocalDateTime.now()
                )
        );

        System.out.println(persons.toString());
        mainMenu();
    }

    public static void printMenu(String[] options){
        cleanConsole();
        for (String option : options){
            System.out.println(option);
        }
        System.out.print("Choose your option : ");
    }
    public static void cleanConsole(){
        for(int i=0; i<15; i++){
            System.out.println(); //clear console
        }
    }

    public static void mainMenu(){
        cleanConsole();
        System.out.println("Main menu:");
        String[] options = {"1- Option 1",
                "2- Option 2",
                "3- Option 3",
                "4- Exit",
        };
        Scanner scanner = new Scanner(System.in);
        int option;
        while (true){
            printMenu(options);
            option = scanner.nextInt();
        }
    }
}
