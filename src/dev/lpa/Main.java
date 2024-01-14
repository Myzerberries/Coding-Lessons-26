package dev.lpa;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        //Below won't compile because you can't create an instance of an abstract class.This is another advantage of an
        //abstract class. What is an animal, after all, that you'd want an instance of one?
//        Animal animal = new Animal("animal", "big", 100);

        Dog dog = new Dog("Wolf", "big", 100);
        dog.makeNoise();

        //Even though we called move on the Animal class in the Main class's doAnimalStuff method, and that class didn't
        //have any code in it for the move method, we get Wolf walking. This is really calling Dog's move method,
        //because we passed a dog instance to this method.
        doAnimalStuff(dog);

        //When you code, writing code using more generic or abstract type saves you a lot of effort.

        //We can have an array list of an abstracted type, and at runtime, instances inherited from that class can use
        //Polymorphism to execute code specific to the concrete type.
        ArrayList<Animal> animals = new ArrayList<>();
        animals.add(dog);
        animals.add(new Dog("German Shepard", "big", 150));
        animals.add(new Fish("Goldfish", "small", 1));
        animals.add(new Fish("Barracuda", "big", 20));
        animals.add(new Dog("Pug", "small", 20));

        animals.add(new Horse("Clydesdale", "large", 1000));

        for(Animal animal : animals){
            doAnimalStuff(animal);
            //Below, we know animal is an Animal, but it could be a lot of things, like Dog, Fish, or Horse. But it
            //could also be a Mammal, a type of Mammal. And we should always try to code generically, so that when
            //new subclasses are added, it won't be disruptive to our code.
            if(animal instanceof Mammal currentMammal){
                currentMammal.shedHair();
            }
        }

    }

    //Where abstraction becomes interesting is when we can use Dog anywhere an Animal is used.

    //We can't create an instance of Animal, because it is abstract. However, that doesn't prevent us from using that
    //type in methods, declarations, and lists. This is what makes the code so flexible and scalable.

    //The abstract class told the world that Animals move and make noise, so anyone can use an Animal class, and call
    //those methods on the object that it gets at runtime. And regardless of what the object is, as long as it's an
    //Animal, meaning it has the Animal class in its hierarchy, this code will continue to work. This is abstraction,
    //promoting polymorphism techniques.
    private static void doAnimalStuff(Animal animal){

        animal.makeNoise();
        animal.move("slow");

    }

}

//Generalization and Abstraction:

//We use the terms abstraction and generalization when we start trying to model real world things in software.

//When you start modeling objects for your application, you start by identifying what features and behavior your
//objects have in common.

//We generalize when we create a class hierarchy.

//A base class is the most general class, the most basic building block, which everything can be said to have in common.

//Part of generalizing is abstraction.

//You can generalize a set of characteristics and behavior to an abstract type.

//If you consider an octopus, a dog, and a penguin, you would probably say they're all animals.

//An animal is really an abstract concept.

//An animal doesn't really exist, except as a way to describe a set of more specific things.

//If you can't draw it on a piece of paper, it's probably abstract.

//Abstraction simplifies the view of a set of items' traits and behavior, so we can talk about them as a group, as well
//as generalize their functionality.

//Java supports abstraction in several different ways:

//Java allows us to create a class hierarchy, where the top of the hierarchy, the base class, is usually an abstract
//concept, whether it's an abstract class or not.

//Java lets us create abstract classes.

//Java gives us a way to create interfaces.

//Abstract method:

//An abstract method has a method signature, and a return type, but doesn't have a method body.

//Because of this, we say an abstract method is unimplemented.

//Its purpose is to describe behavior, which any object of that type will always have.

//Conceptually, we can understand behaviors like move or eat on an Animal, so we might include those as abstract methods,
//on an abstract type.

//You can think of an abstract method as a contract.

//This contract promises that all subtypes will provide the promised functionality, with the agreed upon name and
//arguments.

//Concrete method:

//A concrete method has a method body, usually with at least one statement.

//This means it has operational code that gets executed under the right conditions.

//A concrete method is said to implement an abstract method if it overrides one.

//Abstract classes and interfaces can have a mix of abstract and concrete methods.

//Method modifiers:

//In addition to access modifiers, methods have other modifiers listed below as a high-level introduction:

//      abstract                When you declare a method abstract, a method body is always omitted. An abstract method
//                              can only be declared on an abstract class or interface.

//      static                  Sometimes called a class method, rather than an instance method, because its called
//                              directly on the Class instance.

//      final                   A method that is final cannot be overridden by subclasses.

//      default                 The modifier is only applicable to an interface, tbd later.

//      native                  This is another method without a body, but it's very different from the abstract modifier
//                              . The method body will be implemented in platform-dependant code, typically written in
//                              another programming language such as C. This is not commonly used.

//      synchronized            This modifier manages how multiple threads will access the code in this method.

//Abstraction:

//What is 'it'?

//Consider the following sentences:

//We adopted a new pet this weekend.

//I ordered something I really wanted from the store.

//I bought a ticket and won a prize.

//If we said any of these things to a friend or coworker, it might be frustrating for them.

//We haven't given them enough information in any of these cases.

//In other words, they can't paint a picture in their head, because the lack details.

//New pet, something ordered, and a ticket are too general when talking about one item.

//On the other hand, when we talk about groups of things, we don't usually need too many specifics.

//Consider these sentences:

//I need to go home to feed the animals.

//I'm waiting for my box of stuff from an online store to be delivered.

//So here, 'animals' and 'stuff', are probably enough information to fully describe the situation.

//The abstract class is declared with the abstract modifier.

//Here we are declaring an abstract class called Animal.

//abstract class Animal {}

//An abstract class is a class that's incomplete.

//You can't create an instance of an abstract class.

//Animal a = new Animal();          --> INVALID, an abstract class never gets instantiated.

//An abstract class can still have a constructor, which will be called by its subclasses during their construction.

//An abstract class's purpose is to define the behavior it's subclasses are required to have, so it always participates
//in inheritance.

//For the examples below, assume Animal is an abstract class.

//Classes extend abstract classes and can be concrete.

//Here, Dog extends Animal, Animal is abstract but Dog is concrete.

//class Dog extends Animal {}

//A class that extends an abstract class can be abstract itself, as seen below.

//Mammal is declared abstract, and it extends Animal, which is also abstract.

//abstract class Mammal extends Animal {}

//And finally an abstract class can extend a concrete class.

//Here we have BestOfBreed, an abstract class, extending Dog, which is concrete:

//abstract class BestOfBreed extends Dog {}

//An abstract method is declared with the modifier abstract.

//You can see below that we're declaring an abstract method called move with a void return type.

//It simply ends with a semi-colon.

//It doesn't have a body, not even curly braces:

//abstract class Animal { public abstract void move();}

//What good is an abstract method if it doesn't have any code in it?

//An abstract method tells the outside world that all Animals move, in the example we show below:

//abstract class Animal { public abstract void move();}

//Any code that uses a subtype of Animal knows it can call the move method, and the subtype will implement this method
//with this signature.

//This is also true for a concrete class, and a concrete method that's overridden.

//Earlier when we worked with Inheritance, we created a very basic Animal class, and extended it to create a Dog.

//In that example, Animal was a concrete class, so the move and makeNoise methods had code in their method bodies.

//Subclasses have choices when they extend a concrete class with concrete methods.

//They can inherit the same behavior from their parent. This means they have a method with the same signature, but
//with their own code in there, ignoring the parent's code altogether.

//They can also override the behavior but leverage the parent's method code by calling the parent's method, using super
//in their overridden code.

//But what happens if Animal is declared as abstract, and the move and makeNoise methods are also abstract?

//If Animal is abstract and it's methods are abstract, subclasses no longer have th options mentioned above.

//There is no concrete method for a subclass to inherit from.

//Instead, the subclass must provide a concrete method for any abstract method declared on its parent.

//The subclass won't compile if it doesn't implement the abstract methods.

//Why would this behavior be preferred to a concrete class?

//There may be times when it really doesn't make any sense at all for a base class to provide default behavior for a
//method.

//This mechanism forces designers of the subclasses to provide the implementation that's appropriate to the class
//they're designing. Now let's build this new version of our model(In the code above).

