package ru.geekbrains.junior.lesson2.task1;

public class Cat extends Animal {
    private double weight;

    public Cat(String name, int age, double weight) {
        super(name, age);
        this.weight = weight;
    }

    @Override
    public String makeSound() {
        return " said \"Meow-meow!\"";
    }

    String catchMouse() {
        return " and caught the mouse";
    }
}
