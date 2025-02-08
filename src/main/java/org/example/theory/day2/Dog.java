package org.example.theory.day2;

public class Dog extends Animal{

    public Dog(String name) {
        super(name);
    }
    public void bark() {
        System.out.println(name + " is barking.");
    }
}
