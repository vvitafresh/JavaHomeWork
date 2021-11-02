package com.pb.antonov.hw6;

import java.util.Objects;

public class Cat extends Animal {
    public Cat(String catName, String food, String location){
        super(catName);
        this.setFood(food);
        this.setLocation(location);
    }
    public boolean isWild() {
        return isWild;
    }

    public void setWild(boolean wild) {
        isWild = wild;
    }

    private boolean isWild;

    @Override
    public void makeNoise(){
        System.out.println("Meow-meow");
    }

    @Override
    public void eat() {
        System.out.println("Eating fish");
    }

    @Override
    public String toString() {
        return "Cat{" +
                "name=" + super.getAnimalName() + ", " +
                "food=" + super.getFood() + ", " +
                "location=" + super.getLocation() + ", " +
                "isWild=" + isWild +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cat cat = (Cat) o;
        return isWild == cat.isWild && this.getAnimalName().equals(cat.getAnimalName()) && this.getFood().equals(cat.getFood()) && this.getLocation().equals(cat.getLocation());
    }

    @Override
    public int hashCode() {
        return Objects.hash(isWild, this.getAnimalName(), this.getFood(),this.getLocation());
    }
}
