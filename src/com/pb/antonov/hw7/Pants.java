package com.pb.antonov.hw7;

public class Pants extends Clothes implements ManClothes, WomanClothes {

    public Pants(Size size, double price, String color) {
        this.clothType = "Штаны";
        this.size = size;
        this.price = price;
        this.color = color;
    }

    @Override
    public void dressWoman() {
        dress();
    }

    @Override
    public void dressMan() {
        dress();
    }
}
