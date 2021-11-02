package com.pb.antonov.hw6;

import java.util.Objects;

public class Dog extends Animal{

    public Dog(String animalName){
        super(animalName);
    }

    public Dog(String animalName, String food, String location){
        super(animalName);
        this.setFood(food);
        this.setLocation(location);
    }

    private int teethCount;

    public int getTeethCount() {
        return teethCount;
    }

    public void setTeethCount(int teethCount) {
        this.teethCount = teethCount;
    }

    @Override
    public void makeNoise(){
        System.out.println("Gav-gav-gav!");
    }

    public void eat(){
        System.out.println("Eating bones and meat");
    }

    @Override
    public String toString() {
        return "Dog{" +
                "name=" + super.getAnimalName() + ", " +
                "food=" + super.getFood() + ", " +
                "location=" + super.getLocation() + ", " +
                "teethCount=" + teethCount +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Dog dog = (Dog) o;
        return teethCount == dog.teethCount && this.getAnimalName().equals(dog.getAnimalName()) && this.getFood().equals(dog.getFood()) && this.getLocation().equals(dog.getLocation());
    }

    @Override
    public int hashCode() {
        return Objects.hash(teethCount, this.getAnimalName(), this.getFood(),this.getLocation());
    }
}
