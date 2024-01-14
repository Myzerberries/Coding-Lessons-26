package dev.lpa;

public class Dog extends Mammal{

    //Even though our abstract class won't ever be instantiated, a constructor we declared on it must be called by every
    //subclass constructor. This means we're forcing subclasses to also use this constructor. The abstract class can
    //make subclasses follow its rules. Truthfully any parent can, but an abstract class never gets instantiated, so you
    //have more freedom in building the rules on this kind of class. And well-behaved classes are a good idea.
    public Dog(String type, String size, double weight) {
        super(type, size, weight);
    }

    @Override
    public void move(String speed) {

        if(speed.equals("slow")){
            System.out.println(getExplicitType() + " walking");
        } else {
            System.out.println(getExplicitType() + " running");
        }

    }

    @Override
    public void shedHair() {

        System.out.println(getExplicitType() + " shed hair all the time");

    }

    //Even though the abstract class is forcing us to create a method named move in our class, we don't actually have to
    //put statements in tha block. This is probably not what you'd do in a real application, but it's an option if
    //that method makes no sense for your class.
    @Override
    public void makeNoise() {

        if(type == "Wolf"){
            System.out.println("Howling! ");
        }else {
            System.out.println("Woof! ");
        }

    }
}
