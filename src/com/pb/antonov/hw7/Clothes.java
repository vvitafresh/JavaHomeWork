package com.pb.antonov.hw7;

public abstract class Clothes {
    public String clothType;
    public Size size;
    public double price;
    public String color;

    public void dress(){
        System.out.println(clothType);
        System.out.println(String.format("Размер: %s (%s) - %s",
                size, size.getEuroSize(), size.getDesctiption()));
        System.out.println("Цвет: " + color);
        System.out.println(String.format("Цена: %1.2f золотых монет", price));
    }
}
