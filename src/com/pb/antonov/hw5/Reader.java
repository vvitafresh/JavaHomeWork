/* Класс Reader хранит такую информацию о пользователе библиотеки:
- ФИО
- номер читательского билета
- факультет
- дата рождения
- телефон
Типы полей выбирать на свое усмотрение.

Имеет перегруженные методы takeBook(), returnBook():

- takeBook, который будет принимать количество взятых книг.
Выводит на консоль сообщение
"Петров В. В. взял 3 книги".


- takeBook, который будет принимать переменное количество названий книг.
Выводит на консоль сообщение
"Петров В. В. взял книги: Приключения, Словарь, Энциклопедия".

- takeBook, который будет принимать переменное количество объектов класса Book.
Выводит на консоль сообщение
"Петров В. В. взял книги: Приключения (Иванов И. И. 2000 г.), Словарь (Сидоров А. В 1980 г.), Энциклопедия (Гусев К. В. 2010 г.)".

Аналогичным образом перегрузить метод returnBook().
Должно быть 3 метода returnBook() которые выводит на консоль сообщения:
- "Петров В. В. вернул 3 книги"
- "Петров В. В. вернул книги: Приключения, Словарь, Энциклопедия".
- "Петров В. В. вернул книги: Приключения (Иванов И. И. 2000 г.), Словарь (Сидоров А. В 1980 г.), Энциклопедия (Гусев К. В. 2010 г.)".
 */

package com.pb.antonov.hw5;

public class Reader {
    private String name;
    private int libraryCard;
    private String department;
    private String dateBirth;
    private String phoneNumber;

    public Reader(String name) {
        this.name = name;
    }

    public Reader(String name, int libraryCard, String department, String dateBirth, String phoneNumber) {
        this.name = name;
        this.libraryCard = libraryCard;
        this.department = department;
        this.dateBirth = dateBirth;
        this.phoneNumber = phoneNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getLibraryCard() {
        return libraryCard;
    }

    public void setLibraryCard(int libraryCard) {
        this.libraryCard = libraryCard;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getDateBirth() {
        return dateBirth;
    }

    public void setDateBirth(String dateBirth) {
        this.dateBirth = dateBirth;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String toString() {
        return String.format("%s (билет № %d)", name, libraryCard);
    }

    public void takeBook(int numberOfBooks) {
        System.out.println(String.format("%s взял книг: %d шт.", name, numberOfBooks));
        return;
    }

    public void takeBook(String... bookNames) {
        System.out.print(String.format("%s взал книги: ", name));
        for (String bookName : bookNames) {
            System.out.print(bookName + ", ");
        }
        System.out.print("\b\b\n");   //Delete Last ", " - (backspace)(backspace)(new line)
    }

    public void takeBook(Book... books) {
        System.out.print(String.format("%s взал книги: ", name));
        for (Book book : books) {
            System.out.print(book.toString() + ", ");
        }
        System.out.print("\b\b\n");   //Delete Last ", " - (backspace)(backspace)(new line)
    }


    public void returnBook(int numberOfBooks) {
        System.out.println(String.format("%s вернул книг: %d шт.", name, numberOfBooks));
        return;
    }

    public void returnBook(String... bookNames) {
        System.out.print(String.format("%s вернул книги: ", name));
        for (String bookName : bookNames) {
            System.out.print(bookName + ", ");
        }
        System.out.print("\b\b\n");   //Delete Last ", " - (backspace)(backspace)(new line)
    }

    public void returnBook(Book... books) {
        System.out.print(String.format("%s вернул книги: ", name));
        for (Book book : books) {
            System.out.print(book.toString() + ", ");
        }
        System.out.print("\b\b\n");   //Delete Last ", " - (backspace)(backspace)(new line)
    }

}
