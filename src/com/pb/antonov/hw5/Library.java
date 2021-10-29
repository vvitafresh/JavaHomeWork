/* Класс Library используется как демонстрация работы классов Book и Reader.
Имеет метод main() в котором создается массивы объектов Book и Reader, по 3 или более элементов в каждом.
Выполняются такие действия:
- печатаются все книги.
- печатаются все читатели.
- демонстрируется работа всех вариантов методов takeBook() и returnBook().

 */
package com.pb.antonov.hw5;


public class Library {
    public static void main(String[] args) {

        Book[] books = new Book[3];
        books[0] = new Book("Незнайка на луне", "Николай Носов", 1965);
        books[1] = new Book("Java. Основы", "Кей Хорстманн", 2019);
        books[2] = new Book("Изучаем Java, 2-е издание", "Кэти Сьерра", 2012);

        Reader[] readers = new Reader[3];
        readers[0] = new Reader("Суханов Ефим Юхимович", 111, "ИТ", "25.02.1990", "0501234567");
        readers[1] = new Reader("Кличко Яков Романович", 222, "Спорт", "12.02.1991", "0501234567");
        readers[2] = new Reader("Абрамов Нестор Владимирович", 333, "Финансы", "12.12.1992", "0501234567");

        System.out.println("Книги: ");
        for (Book book : books) {
            System.out.println(book.toString());
        }
        System.out.println("---");
        System.out.println("Читатели: ");

        for (Reader reader : readers) {
            System.out.println(reader.toString());
        }
        System.out.println("---");

        readers[0].takeBook(5);
        readers[0].takeBook("Первая Книга", "Вторая Книга", "Третья Книга");
        readers[0].takeBook(books[0], books[1], books[2]);
        System.out.println("---");

        readers[1].returnBook(3);
        readers[1].returnBook( "Третья Книга", "Вторая Книга", "Первая Книга");
        readers[1].returnBook(books[0], books[1], books[2]);

    }
}
