abstract public class Animal {

    abstract void cry();
}

class Cat extends Animal {

    @Override
    void cry() {
        System.out.println("냐옹냐옹");
    }
}

class Dog extends Animal {

    @Override
    void cry() {
        System.out.println("멍멍");
    }
}

