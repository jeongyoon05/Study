package data.example;

import java.util.Objects;

//toString
//equals
//hashCode
//getter
//setter
public class JavaDataClass {
    private String name;
    private int price;

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        JavaDataClass that = (JavaDataClass) o;
        return price == that.price && Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, price);
    }

    @Override
    public String toString() {
        return "NewJavaDataClass{" +
                "name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}
