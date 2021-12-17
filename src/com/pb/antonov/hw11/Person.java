package com.pb.antonov.hw11;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Objects;
import static com.pb.antonov.hw11.StrUtil.*;

public class Person implements Comparable<Person>{
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
                  ArrayList<String> phones, String address, LocalDateTime editDateTime) {
        this.fio = fio;
        this.dateOfBirth = dateOfBirth;
        this.phones = phones;
        this.address = address;
        this.editDateTime = editDateTime;
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


//    @Override
//    public String toString() {
//        return "Person{" +
//                "name='" + fio + '\'' +
//                ", dateOfBirth='" + dateOfBirth + '\'' +
//                ", phones='" + phones.toString() + '\'' +
//                ", address='" + address + '\'' +
//                ", editDateTime=" + editDateTime +
//                '}';
//    }

    @Override
    public String toString() {
        //String spaceFio = String.format("%"+ 20 +"s", " ");
        return   rightPadding(fio,25) +
                "| Дата рождения: " + dateOfBirth + "\n" +
                "Телефоны: " + phones.toString() + "\n" +
                "Адресс: " + address + "\n" +
                "Редактирование: " + editDateTime;
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
