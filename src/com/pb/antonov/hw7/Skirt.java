package com.pb.antonov.hw7;

public class Skirt extends Clothes implements WomanClothes {

    public Skirt(Size size, double price, String color) {
        this.clothType = "Юбка";
        this.size = size;
        this.price = price;
        this.color = color;
    }

    @Override
    public void dressWoman() {
        dress();
    }

}
