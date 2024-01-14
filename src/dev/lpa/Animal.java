package dev.lpa;

abstract class Mammal extends Animal {

    //In this class, we're not forced to use implementations for the move and makeNoise methods, like we were for the
    //Dog and Fish class. Why not?

    //An abstract class that extends another abstract class has some flexibility.

    //It can implement all the parent's abstract methods.
    //It can implement some of them.
    //Or it can implement none of them.

    //It can also include additional abstract methods which will force subclasses to implement both Animal's abstract
    //methods, and also Mammals.
    public Mammal(String type, String size, double weight) {
        super(type, size, weight);
    }

    @Override
    public void move(String speed) {
        System.out.println(getExplicitType() + " ");
        System.out.println(speed.equals("slow") ? "walks" : "runs");
    }

    public abstract void shedHair();
}
public abstract class Animal {

    protected String type;
    private String size;
    private double weight;

    public Animal(String type, String size, double weight) {
        this.type = type;
        this.size = size;
        this.weight = weight;
    }

    public abstract void move(String speed);
    public abstract void makeNoise();

    //Here we have a concrete method on an abstract class, which has a body. We get the class's simple name and print
    //that with the type that was passed as the field.

    //When we add final after the access modifier, we are not allowing this method to be overridden.
    public final String getExplicitType(){
        return getClass().getSimpleName() + " (" + type + ")";
    }

}

//Why use an abstract class?

//In truth, you may never need to use an abstract class in your design, but there are some good arguments for using them.

//An abstract class in your hierarchy forces the designers of subclasses to think about, and create unique and targeted
//implementations for the abstracted methods.

//It may not always make sense to provide a default, or inherited implementation, of a particular method.

//An abstract class can't be instantiated, so if you're using abstract classes to design a framework for implementation,
//this is definitely an advantage.

//In our example code, we don't really want people creating instances of Animals or Mammals.

//We used those classes to abstract behavior at different classification levels.

//All Animals have to implement the move and makeNoise methods, but only Mammals needed to implement shedHair, as we
//demonstrated.
