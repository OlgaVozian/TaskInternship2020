package com.endava.internship.OOP;

public abstract class Mammal {

    private int eyes;
    private int legs;
    private double weight;

    public Mammal() {

    }

    public void setEyes(int eyes) {
        if (eyes != 2) {
            throw new IllegalArgumentException("Provided eyes argument should be equal with 2");
        }
        this.eyes = eyes;
    }

    public void setLegs(Integer legs) {
        if ((legs != 4) && (legs != 2)) {
            throw new IllegalArgumentException("Provided legs argument should be 4 or 2");
        }
        this.legs = legs;
    }

    public void setWeight(Double weight) {
        if ((weight <= 50)) {
            throw new IllegalArgumentException("Provided weight argument should be greater than 50");
        }
        this.weight = weight;
    }

    public int getEyes() {
        return eyes;
    }


    public int getLegs() {
        return legs;
    }

    public double getWeight() {
        return weight;
    }

    public void eat() {

    }

    public void run() {

    }

    public void sleep() {

    }
}
