public class Main {
    public static void main(String[] args) {
        // Animal a = new Animal(); // 추상 클래스는 인스턴스를 생성 불가능
        Cat c = new Cat();
        Dog d = new Dog();

        c.cry();
        d.cry();
    }
}
