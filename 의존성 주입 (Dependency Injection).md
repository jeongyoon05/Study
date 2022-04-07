# 의존성 주입 (Dependency Injection)

Spring에서의 의존성 주입이란 다음과 같다.

> 어떤 객체에 스프링 컨테이너가 또 다른 객체와 의존성을 맺어주는 행위



*의존성 주입 머리로 이해하기

`햄버거 가게 요리사는 햄버거 레시피에 의존한다. 햄버거 레시피가 변화하게 되었을 때, 변화된 레시피에 따라서 요리사는 햄버거 만드는 방법을 수정해야 한다. 레시피의 변화가 요리사의 행위에 영향을 미쳤기 때문에, “요리사는 레시피에 의존한다”고 말할 수 있다. 코드로 표현해보면 다음과 같다.`



ex) 

군인이 총을 가지고 있는 것을 나타내기 위해 Soldier 객체와 Gun 객체가 의존관계가 맺어진다고 해본다.

그렇다면 의존성 주입을 적용하지 않은 경우와 적용한 경우는 다음과 같다.

### 적용하지 않은 경우

<Gun.java>

```java
public class Gun {
	...
	...
}
```

<Soldier.java>

```java
public class Soldier {
    private Gun gun;
    
    public Soldier() {
        gun = new Gun();
    }
}
```

위 코드의 경우에는 Soldier 클래스 내부에서 Gun 객체를 생성하였기 때문에 의존성 주입이 아닌 의존성을 스스로 만든것이다.

![img](https://media.vlpt.us/images/damiano1027/post/1fa1ec61-2389-46fe-9a0d-adb2db9cde64/image.png)

### 적용한 경우

<Gun.java>

```java
@Component  // 스프링 컨테이너에 Bean으로 등록 
public class Gun {
	...
	...
}
```

<Solider.java>

```java
@RequiredArgsConstructor // lombok에서 private final 필드에 의존성 주입 해주는 어노테이션
public class Soldier {
    
	private final Gun gun;
}
```

위 코드의 경우에는 Gun 객체(Bean)를 스프링 컨테이너에 등록하고, 스프링 컨테이너에서 Soldier의 gun 멤버 변수에 Bean을 주입할수 있게 해준다. 

![img](https://media.vlpt.us/images/damiano1027/post/e5624a20-6a5d-4c31-8042-ab5d06b9622b/image.png)

### DI(의존성 주입)를 해야 하는 이유

DI로 프로그램을 설계 했을 때, 다음과 같은 이점을 얻을 수 있다.

- Unit Test가 용이해진다.
- 코드의 재활용성을 높여준다.
- 객체 간의 의존성을 줄이거나 없엘 수 있다.
- 객체 간의 결합도를 낮추면서 유연한 코드를 작성할 수 있다.