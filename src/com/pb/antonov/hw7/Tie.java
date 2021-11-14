package com.pb.antonov.hw7;

public class Tie extends Clothes implements ManClothes {

    public Tie(Size size, double price, String color) {
        this.clothType = "Галстук";
        this.size = size;
        this.price = price;
        this.color = color;
    }

    @Override
    public void dressMan() {
        dress();
    }
}
