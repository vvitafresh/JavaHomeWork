/*
В пакете hw6 создайте класс Animal и расширяющие его классы Dog, Cat, Horse.
Класс Animal содержит переменные food, location и методы makeNoise, eat, sleep.
Метод sleep, например, может выводить на консоль "Такое-то животное спит".
Dog, Cat, Horse переопределяют методы makeNoise, eat.
Добавьте переменные (поля) в классы Dog, Cat, Horse, характеризующие только этих животных.
В классах Dog, Cat, Horse переопределить методы toString, equals, hashCode.
Создайте класс Veterinarian (Ветеринар), в котором определите метод void treatAnimal(Animal animal).
Пусть этот метод печатает на экран food и location пришедшего на прием животного.
Создайте класс VetСlinic в его методе main создайте массив типа Animal, в который запишите животных всех имеющихся у вас типов.
В цикле отправляйте животных на прием к ветеринару.
Объект класса Veterinarian создайте с помощью рефлексии.

 */
package com.pb.antonov.hw6;

import java.lang.reflect.Constructor;

public class VetClinic {
    public static void main(String[] args) throws Exception {
        Dog dog1 = new Dog("Best Dog", "Bones","Forest");
        dog1.setTeethCount(28);
        Dog dog2 = new Dog("Second Dog", "Meat","Lake");
        dog2.setTeethCount(32);
        Dog dog3 = new Dog("Third Dog", "Bones","Forest");
        dog3.setTeethCount(36);

        Cat cat1 = new Cat("Calm cat","Fish", "Home");
        cat1.setWild(true);

        Horse horse1 = new Horse("Horse Quick","Grass", "Yard");
        horse1.setHeight(170);

//        System.out.println(dog1.equals(dog3));
//        Veterinarian veterinarian = new Veterinarian();
//        Animal[] animals = new Animal[] {dog1};
//        for (Animal anim: animals){
//            veterinarian.treatAnimal(anim);
//        }

        Class vetClazz = Class.forName("com.pb.antonov.hw6.Veterinarian");
        Constructor constr = vetClazz.getConstructor(new Class[]{});
        Object objVet = constr.newInstance();

        Animal[] animals = new Animal[]{dog1, dog2, dog3, cat1, horse1};
        if(objVet instanceof Veterinarian){
            for (Animal animal: animals){
                ((Veterinarian) objVet).treatAnimal(animal);
                System.out.println("--");
            }
        }

        System.out.println("*******************************");
        Animal myAnimal = new Animal("My Animal");
        myAnimal.eat();
        myAnimal.makeNoise();
        myAnimal.sleep();
        System.out.println("---");

        System.out.println(dog1.toString());
        System.out.println(dog2.toString());
        System.out.println(dog3.toString());
        dog1.eat();
        dog1.makeNoise();
        dog1.sleep();
        System.out.println("---");

        System.out.println(cat1.toString());
        cat1.eat();
        cat1.makeNoise();
        cat1.sleep();
        System.out.println("---");

        System.out.println(horse1.toString());
        horse1.eat();
        horse1.makeNoise();
        horse1.sleep();
    }
}
