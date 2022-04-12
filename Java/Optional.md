# Optional

### null 관련 문제 돌아보기

null 관련된 문제들은 크게 2가지로 요약된다.

- 런타임에 NPE(NullPointerException)라는 예외를 발생시킬 수 있음.
- NPE 방어를 위해서 들어간 null 체크 로직 때문에 코드 가독성과 유지 보수성이 떨어진다.

그냥 두자니 곳곳에 숨어서 일으켜 장애를 유발하고, 조치를 하자니 코드를 엉망으로 만드는 null, 어떡하면 현명하게 다룰수 있을까?

### 함수형 언어에서 그 해결법을 찾다

스칼라나 하스켈과 같은 소위 함수형 언어들은 전혀 다른 방법으로 이 문제을 해결한다. 자바가 “존재하지 않는 값”을 표현하기 위해서 null을 사용했다면, 이 함수형 언어들은 “존재할지 안 할지 모르는 값”을 표현할 수 있는 별개의 타입을 가지고 있다.그리고 이 타입은 이 존재할지 안 할지도 모르는 값을 제어할 수 있는 여러가지 API를 제공하기 때문에 개발자들 해당 API를 통해서 간접적으로 그 값에 접근하게 된다. Java8은 이러한 함수형 언어의 접근 방식에서 영감을 받아 `java.util.Optional<T>`라는 새로운 클래스를 도입했다.

### Optional 이란?

`Optional`은 "존재할 수도 있지만 안 할 수도 있는 객체" 즉, "null이 될 수도 있는" 객체를 감싸고 있는 일종의 `wrapper` 클래스이다.

원소가 없거나 최대 하나 밖에 없는 `Collection`이나 `Stream`으로 생각해도 좋다. 직접 다루기에 위험하고 까다로운 null을 담을 수 있는 특수한 그릇으로 생각하면 이해가 쉽다.

### Optional의 효과

Optional로 객체를 감싸서 사용하면

- NPE을 유발할 수 있는 null을 직접 다루지 않아도 된다.
- 수고롭게 null 체크를 직접 하지 않아도 된다.
- 명시적으로 해당 변수가 null일 수도 있다는 가능성을 표현할 수 있다. (불필요한 방어 로직을 줄일 수 있다.)

### Optional 기본 사용법

`java.util.Optional<T>` 클래스를 어떻게 사용하는지 좀 더 구체적으로 살펴보자.



### Optional 변수 선언하기

제네릭을 제공하기 때문에, 변수를 선언할 때 명기한 타입 파라미터에 따라서 감쌀 수 있는 객체의 타입이 결정된다.

```java
Optional<Order> maybeOrder; // Order 타입의 객체를 감쌀 수 있는 Optional 타입의 변수
Optional<Member> optMember; // Member 타입의 객체를 감쌀 수 있는 Optional 타입의 변수
Optional<Address> address; // Address 타입의 객체를 감쌀 수 있는 Optional 타입의 변수
```

### Optional 객체 생성하기

Optional 클래스는 간편하게 객체를 생성을 할 수 있도록 3가지 정적 팩토리 메소드를 제공한다.

- `Optional.emty()`

null을 담고 있는, 한마니로 비어있는 Optional 객체를 얻어온다. 이 비어있는 객체는 Optional 내부적으로 미리 생성해 놓은 싱글 인스턴스이다.

```java
Optional<Member> maybeMember = Optional.empty();
```

- `Optional.of(value)`

null이 아닌 객체를 담고 있는 Optional 객체를 생성한다. null이 넘어올 경우, NPE를 던지기 때문에 주의해서 사용해야 한다.

```java
Optional<Member> maybeMember = Optional.of(aMember);
```

- `Optional.ofNullable(value)`

null인지 아닌지 확신할 수 없는 객체를 담고 있는 Optional 객체를 생성한다.

`Optional.empty()`와 `Optional.ofNullable(value)`를 합쳐놓은 메서드라고 생각하면 된다.

null이 넘어올 경우, NPE를 던지지 않고 `Optional.empty()`와 동일하게 비어있는 Optional객체를 얻어온다.

해당 객체가 null인지 아닌지 자신이 없는 상황에서는 이 메서드를 사용하면 된다.

```java
Optional<Member> maybeMember = Optional.ofNullable(aMember);
Optional<Member> maybeNotMember = Optional.ofNullable(null);
```

###  Optional이 담고 있는 객체 접근하기

Optional 클래스는 담고 있는 객체를 꺼내오기 위해서 다양한 인스턴스 메서드를 제공한다.

아래 메서드들은 모두 Optional이 담고 있는 객체가 존재할 경우 동일하게 해당 값을 반환한다.

반면에 Optional이 비어있는 경우(즉, null을 담고 있는 경우), 다르게 작동한다. 

- `get()`

비어있는 Optional 객체에 대해서, `NoSuchElementException`을 던진다.

- `orElse(T other)`

비어있는 Optional 객체에 대해서, 넘어온 인자를 반환한다.

- `orElseGet(Supplier<? extends T> other)`

비어있는 Optional 객체에 대해서, 넘어온 함수형 인자를 통해 생성된 객체를 반환한다.

`orElse(T other)`의 게으른 버전이라고 보면된다. 비어있는 경우에만 함수가 호출되기 때문에 `orElse(T other)` 대비 성능상 이점을 기대할 수 있다.

- `orElseThrow(Supplier<? extends x> exceptionSupplier)`

비어있는 Optional 객체에 대해서, 넘어온 함수형 인자를 통해 생성된 예외를 던진다.

