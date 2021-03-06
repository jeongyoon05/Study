# 클래스 (Class)



### 클래스의 개념

---

#### 객체 지향 프로그래밍(OOP, Object-Oriented Programming)

겍체 지향 프로그래밍에서는 모든 데이터를 객체(object)로 취급하여, 이러한 객체가 바로 프로그래밍의 중심이 된다.



#### 클래스 (class)

자바에서는 클래스란 객체를 정의하는데 틀 또는 설계도와 같은 의미다.



#### 인스턴스 (instance)

자바에서 클래스를 사용하기 위해서는 우선 해당 클래스 타입의 객체를 선언 해야한다.

즉, 인스턴스란 메모리에 할당된 객체를 의미 합니다.



### 내부 클래스 (inner class)

내부 클래스란 하나의 클래스 내부에 선언된 또 다른 클래스를 의미한다.

이러한 내부 클래스는 외부 클래스에 대해 두 개의 클래스가 서로 긴밀한 관계를 맺고 있을 때 선언할 수 있다.

```java
class Outher {	//외부 클래스
	...
	class Innner {	//내부 클래스
		...
	}
	...
}
```

---

### 내부 클래스의 장점

- 내부 클래스에서 외부 클래스의 멤버에 손쉽게 접근할 수 있다.
- 서로 관련 있는 클래스를 논리적으로 묶어서 표현함으로써, 코드의 캡슐화를 증가 시킨다.
- 외부에서는 내부 클래스에 접근할 수 없으므로, 코드의 복잡성을 줄일 수 있다. 

---

### 내부 클래스의 종류

내부 클래스는 필드와 마찬가지로 선언된 위치에 따라 다음과 같이 구분된다.



1. 정적 클래스 (static class)
2. 인스턴스 클래스 (instance class)
3. 지역 클래스 (local class)
4. 익명 클래스 (anonymous class)



### 익명 클래스 (anonymous class) 

익명 클래스란 다른 내부 클래스와는 달리 이름을 가지지 않는 클래스를 말한다.

익명 클래스는 선언과 동시에 객체를 생성하므로, 단 하나의 클래스를 생성하는 일회용 클래스이다.

따라서 생성자 선언 x, 오로지 단 하나의 클래스나 단 하나의 인터페이스를 상속 받거나 구현할 수 있을 뿐입니다.



이러한 익명 클래스는 매우 제한적인 용도에 사용되며, 구현해야 하는 메서드가 매우 적은 클래스를 구현할 때 사용된다.

```java
// 익명 클래스는 선언과 동시에 생성하여 참조변수에 대입함
ClassName className = new ClassName() {
    // 메서드 선언
}
```



## 추상클래스

#### 추상 메서드 (abstract method)

추상 메서드란 자식 클래스에서 반드시 오버라이딩해야만 사용할수 있는 메서드를 의미한다.

자바에서 추상 메서드를 선언하여 사용하는 목적으로 추상 메서드가 포함된 클래스를 상속받는 자식 클래스가 반드시 추상메서드를 구현          하기 위함이다.



예를 들면 모듈처럼 중복되는 부분이나 공통적인 부분은 미리 다 만들어진 것을 사용하고, 이를 받아 사용하는 쪽에서는 자신에게 필요한 부분만을 재정의하여 사용함으로 생산성이 향상되고 배포 등이 쉬워지기 때문이다.



추상 메서드는 선언부만 존재하고 구현부는 작성하지 않는다.

바로 이 작성되지 않은 구현부를 자식클래스에서 오버라이딩하여 사용한다.



```java
abstract 리턴타입 메서드이름();
```



---

#### 추상 클래스 (abstract class) 

자바에서는 하나 이상의 추상 메서드를 포함하는 클래스를 가리켜 추상클래스라고 합니다.

이런 추상 클래스는 객체 지향 프로그래밍에서 중요한 특징인 다형성을 가지는 메서드의 집합을 정의할 수 있도록 해줍니다.

즉,  반드시 사용되어야 하는 메서드를 추상 클래스에 추상 메서드를 선언해 놓으면, 이 클래스를 상속 받는 모든 클래스에서는 이 추상 메서드를 반드시 재정의 해야 합니다.



```java
abstract class 클래스명() {
    ...
    abstract 리턴타입 메서드이름();
    ...
}
```

 이러한 추상 클래스는 동작이 정의되어 있지 않은 추상메서드를 포함하고 있어서 인스턴스 생성x

```
추상 클래스는 추상 메소드를 포함하고 있다는 점을 제외하면, 일반 클래스와 모든 점이 같습니다.
즉, 생성자와 필드, 일반 메소드도 포함할 수 있습니다.
```

