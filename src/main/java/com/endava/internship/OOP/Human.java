package com.endava.internship.OOP;

public class Human extends Mammal implements HumanDetails {

    public final int eyes = 2;
    public final int legs = 2;
    private double height;
    private String colorSkin;

    public Human() {

    }

    public Human(double height) {
        this.height = height;
    }

    public Human(double height, String colorSkin) {
        this.height = height;
        this.colorSkin = colorSkin;
    }

    public void setHeight(double height) {
        if (height <= 50) {
            throw new IllegalArgumentException("Provided height argument should be greater than 50");
        }
        this.height = height;
    }

    public void setColorSkin(String colorSkin) {
        if (!colorSkin.equals("white") && !colorSkin.equals("black")) {
            throw new IllegalArgumentException("Provided color argument should be white or black");
        }
        this.colorSkin = colorSkin;
    }

    public double getHeight() {
        return height;
    }

    public String getColorSkin() {
        return colorSkin;
    }

    public void eat() {
        System.out.println("The person can prepare the food, can eat vegetables, fruits and meat");
    }

    public void run() {
        System.out.println("Can walk, run, jump and swim");
    }

    public void run(int a, int b, float c, int d) {
        System.out.println("Can walk " + a + "km, run " + b + "km, jump " + c + "km and swim " + d + "km");
    }

    public void intelligence() {
        System.out.println("Have a good intelligence");
    }

    public void work() {
        System.out.println(profession + "has " + studyDegree + " and works at hospital");
    }

    public void rest() {
        System.out.println("The most of the doctors rest at the nature");
    }

    public void play() {
        System.out.println(profession + " can play different games");
    }
}
