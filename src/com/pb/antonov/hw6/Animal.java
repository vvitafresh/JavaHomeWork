package com.pb.antonov.hw6;

public class Animal {

    public Animal(String animalName){
        this.animalName=animalName;
    }

    private String animalName;
    private String food;
    private String location;


    public String getAnimalName() {
        return animalName;
    }

    public void setAnimalName(String animalName) {
        this.animalName = animalName;
    }

    public String getFood() {
        return food;
    }

    public void setFood(String food) {
        this.food = food;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void makeNoise(){
        System.out.println("Making animal noise");
    }

    public void eat(){
        System.out.println("Eating");
    }

    public void sleep(){
        System.out.println(animalName + " is sleeping.");
    }
}
