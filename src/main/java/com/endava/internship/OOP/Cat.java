package com.endava.internship.OOP;

public class Cat extends Feline {

    public final int eyes = 2;
    public final int legs = 4;
    private String breed;
    private String color;

    public Cat() {

    }

    public Cat(String breed) {
        this.breed = breed;
    }

    public Cat(String breed, String color) {
        this.breed = breed;
        this.color = color;
    }

    @Override
    public void setColor(String color) {
        if ((!color.equals("white")) && (!color.equals("red"))) {
            throw new IllegalArgumentException("Provided color argument should be red or white");
        }
        this.color = color;
    }

    public void setBreed(String breed) {
        if (!breed.equals("Scottish")) {
            throw new IllegalArgumentException("Provided argument is not accepted");
        }
        this.breed = breed;
    }

    public String getBreed() {
        return breed;
    }

    @Override
    public String getColor() {
        return color;
    }

    public void eat() {
        System.out.println("Eat special food for cats, are omnivore and herbivore");
    }

    public void run() {
        System.out.println("Can jump very high and run with a high speed");
    }

    public void play() {
        System.out.println("Can play with humans");
    }

    public void play(int toys) {
        System.out.println("Can play with " + toys + " toys");
    }
}
