package com.endava.internship.OOP;

public class Feline extends Mammal {

    private int age;
    private String color;

    public Feline() {

    }

    public void setAge(int age) {
        if (age <= 0) {
            throw new IllegalArgumentException("Provided age argument should be greater than zero");
        }
        this.age = age;
    }

    public void setColor(String color) {
        if (!color.equals("black") && !color.equals("white")) {
            throw new IllegalArgumentException("Provided color argument should be black or white");
        }
        this.color = color;
    }

    public int getAge() {
        return age;
    }

    public String getColor() {
        return color;
    }

    public void eat() {
        System.out.println("Are omnivore and herbivore");
    }

    public void run() {
        System.out.println("Run with a high speed");
    }

    public void sleep() {
        System.out.println("Can sleep on the tree");
    }

    public void jump() {
        System.out.println("Can jump");
    }
}
