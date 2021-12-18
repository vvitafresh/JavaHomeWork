package com.pb.antonov.hw11;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Objects;

import static com.pb.antonov.hw11.StrUtil.*;

public class Person implements Comparable<Person>, Serializable {
    private String fio;
    private LocalDate dateOfBirth;
    private ArrayList<String> phones;
    private String address;
    private LocalDateTime editDateTime;

    //@JsonDeserialize(using = LocalDateDeserializer.class)
    //@JsonSerialize(using = LocalDateSerializer.class)

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Person() {
    }

    public Person(String fio, LocalDate dateOfBirth,
                  ArrayList<String> phones,
                  String address) {
        this.fio = fio;
        this.dateOfBirth = dateOfBirth;
        this.phones = phones;
        this.address = address;
        this.editDateTime = LocalDateTime.now();
    }

    public Person(String fio, LocalDate dateOfBirth) {
        this.fio = fio;
        this.dateOfBirth = dateOfBirth;
    }

    public String getFio() {
        return fio;
    }

    public void setFio(String fio) {
        this.fio = fio;
    }

    public ArrayList<String> getPhones() {
        return phones;
    }

    public void setPhones(ArrayList<String> phones) {
        this.phones = phones;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public LocalDateTime getEditDateTime() {
        return editDateTime;
    }

    public void setEditDateTime(LocalDateTime editDateTime) {
        this.editDateTime = editDateTime;
    }

    @Override
    public String toString() {
        return "Person{" +
                "fio='" + fio + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                ", phones=" + phones +
                ", address='" + address + '\'' +
                ", editDateTime=" + editDateTime +
                '}';
    }

    public String toConsole() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        String formattedDateTime = editDateTime.format(formatter); // "2021-12-31 12:30"

        return rightPadding(fio, 50) +
                "| Дата рождения: " + dateOfBirth + "\n" +
                "Телефоны: " + phones.toString() + "\n" +
                "Адрес: " + address + "\n" +
                "Сохранено: " + formattedDateTime;
    }

    @Override
    public int compareTo(Person o) {
        return fio.compareTo(o.getFio());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return Objects.equals(fio, person.fio) || Objects.equals(dateOfBirth, person.dateOfBirth);
    }

}
