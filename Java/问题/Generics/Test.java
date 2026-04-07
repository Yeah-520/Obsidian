package Generics;

import java.util.ArrayList;
import java.util.List;

public class Test {
    static void main() {
        //? extend T
        List<? extends Animal> animals;
        List<Dog> dogs = new ArrayList<>();
        dogs.add(new Dog());
        animals = dogs;
        System.out.println(animals.get(0));

        //? super T
        List<? super Cat> cats = new ArrayList<>();
        //cats.add(new Animal()); 报错
        cats.add(new Cat());
        cats.add(new MinCat());
        System.out.println(cats.get(0));

    }
}


class Animal {
}

class Cat extends Animal {
}

class Dog extends Animal {
}

class MinCat extends Cat {
}

class MinDog extends Dog {
}