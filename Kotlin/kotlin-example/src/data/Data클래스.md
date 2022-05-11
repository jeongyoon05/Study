# Data클래스

클래스에 has(), equals(), toString(), copy(), componentX()을 자동으로 구현해주는 클래스이다.

#### Java의 data class

Car 이라는 객체를 자바로 작성

```java
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
```

코드가 엄청 길다.. 롬복을 사용하면 줄일수 있긴하다.

```kotlin
package data.example

data class KotlinDataClass(private val name: String, private val price: Int) {
}
```

끝이다!

kotlin에 data class는 getter, setter, toString, equals, hashCode까지 모두 가지고 있다.

또한 비구조화 할당도 할 수 있다.

```kotlin
val (name, price) = newCar
```

