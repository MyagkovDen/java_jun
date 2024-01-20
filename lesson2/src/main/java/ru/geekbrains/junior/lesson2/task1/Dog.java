package ru.geekbrains.junior.lesson2.task1;

public class Dog extends Animal{
    private double height;

    public Dog(String name, int age, double height) {
        super(name, age);
        this.height = height;
    }

    @Override
    public String makeSound() {
        return " said \"Wah-wah-wah!!!\"";
    }
    private String bitThief(){
        return " and bit the thief";
    }
}
