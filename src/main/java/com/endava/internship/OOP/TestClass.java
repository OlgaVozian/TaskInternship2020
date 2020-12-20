package com.endava.internship.OOP;

public class TestClass {

    public static void main(String [] args){
        Feline feline = new Feline();
        feline.setAge(3);
        System.out.println("The age of the feline is: " + feline.getAge());
        feline.setColor("white");
        System.out.println("The color of the feline is: "+feline.getColor());
        feline.eat();
        feline.run();
        feline.jump();
        feline.sleep();

        Cat cat = new Cat("Scottish","red");
        System.out.println("The cat has " + cat.eyes + " eyes");
        System.out.println("The cat has " + cat.legs + " legs");
        System.out.println("The cat is " + cat.getBreed() + " breed");
        System.out.println("The cat has " + cat.getColor() + " color");
        cat.eat();
        cat.play();
        cat.play(2);
        cat.run();

        Human human = new Human(1.80, "white");
        System.out.println("The person has " + human.eyes + " eyes");
        System.out.println("The person has "+ human.legs + " legs");
        System.out.println("The person is " + human.getHeight() + " cm");
        System.out.println("The person has " + human.getColorSkin() + " color skin");
        human.eat();
        human.play();
        human.rest();
        human.run();
        human.run(10,20,1.5f, 5);
        human.intelligence();
        human.work();
    }
}
