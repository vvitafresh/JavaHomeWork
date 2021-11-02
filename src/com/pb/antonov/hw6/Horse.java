package com.pb.antonov.hw6;

import java.util.Objects;

public class Horse extends Animal {
    public Horse(String name, String food, String location){
        super(name);
        super.setFood(food);
        super.setLocation(location);
    }

    private int height;

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    @Override
    public void makeNoise() {
        System.out.println("Eee-go-go ");
    }

    @Override
    public void eat() {
        System.out.println("Eating grass");
    }

    @Override
    public String toString() {
        return "Horse{" +
                "name=" + super.getAnimalName() + ", " +
                "food=" + super.getFood() + ", " +
                "location=" + super.getLocation() + ", " +
                "height=" + height +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Horse horse = (Horse) o;
        return height == horse.height && this.getAnimalName().equals(horse.getAnimalName()) && this.getFood().equals(horse.getFood()) && this.getLocation().equals(horse.getLocation());
    }

    @Override
    public int hashCode() {
        return Objects.hash(height, this.getAnimalName(), this.getFood(),this.getLocation());
    }
}
