package com.pb.antonov.hw6;

public class Veterinarian {

    public void treatAnimal(Animal animal){
        System.out.println("Treating animal " + animal.getAnimalName() + ":");
        System.out.println("Food - " + animal.getFood());
        System.out.println("Location - " + animal.getLocation());
    }
}
