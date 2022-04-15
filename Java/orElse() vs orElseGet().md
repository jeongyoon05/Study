# orElse() vs orElseGet()

```java
orElse(T ob)
orElseGet(Supplier<? extends T> ob)
```

Optional 객체 값에 접근하기 위해서는 get, orElse, orElseGet, orElseThrow를 쓸 수 있다.

그중 orElse, orElseGet의 차이에 대해 알아보자.

우선 두 메서드 모두 마치 if문을 대신해서 쓸 수 있다. 객체가 가지고 있는 값이 null일 경우 무슨 값으로 대체해 return할지를 매개값으로 넘겨준다. 

둘이 다른점은 **파라미터**다.

orElseGet 에는 Supplier 가 parameter로 전달된다. orElse에서는 그냥 object T가 전달된다.

orElse는 객체를 그대로 return 하는데 orElseGet은 Supplier 메서드를 받아서 리턴한다.

> Supplier?
>
> 함수적인 인터페이스 API 종류 중 하나이다. 매개값은 없고 리턴값만 있이 람다식을 사용할수 있다.

값이 null이 아닐경우 

```java
    @Test
    public void testSelf() {
        Object object = Optional.ofNullable("김범진").orElse(getSelf());
        Object object2 = Optional.ofNullable("바보").orElseGet(this::getSelf);
        System.out.println(object);
        System.out.println(object2);
    }

    private String getSelf() {
        System.out.println("헬로");
        return "하하";
    }
```

출력결과

````java
헬로
김범진
바보
````

값이 null일 경우

```java
 	@Test
    public void testSelf() {
        Optional.ofNullable(null).orElse(getSelf());
        Optional.ofNullable(null).orElseGet(this::getSelf);
    }

    private String getSelf() {
        System.out.println("헬로");
        return "하하";
    }
```

출력결과

```
헬로
헬로
하하
하하
```

위 결과를 보면 orElse에서는 Optional 값 존재 여부와 상관없이 Object 객체를 생성하는 모습이고 orElseGet은 비어있는 Optional 객체가 넘어온 경우에만 Supplier 함수형 인자를 사용해서 생성된 값을 반환한다.

### **결론**

null이 아닐경우에도 메서드가 호출되는 orElse에는 "헬로"가 출력된후 String 값들이 Object 객체에 담겼고 null일 경우에 메서드를 호출해서 리턴값이 객체에 담겼다.
