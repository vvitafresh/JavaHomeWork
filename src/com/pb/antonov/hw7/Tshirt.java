package com.pb.antonov.hw7;

public class Tshirt extends Clothes implements ManClothes, WomanClothes {

    public Tshirt(Size size, double price, String color) {
        this.clothType = "Футболка";
        this.size = size;
        this.price = price;
        this.color = color;
    }

    @Override
    public void dressWoman() {
        //dress(clothType, size, price, color);
        dress();
    }

    @Override
    public void dressMan() {
        //dress(clothType, size, price, color);
        dress();
    }

}
