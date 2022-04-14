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
        Optional.ofNullable(getMethod()).orElse(getSelf());
        Optional.ofNullable(getMethod()).orElseGet(this::getSelf);
    }

    private String getSelf() {
        System.out.println("헬로");
        return "하하";
    }

    private String getMethod() {
        System.out.println("반가워");
        return "hello";
    }
}

```

출력결과

````java
반가워
헬로
반가워
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

    private String getMethod() {
        System.out.println("반가워");
        return "hello";
    }
}
```

출력결과

```
헬로
헬로
```

위 결과를 보면 orElse에서는 Optional 값 존재 여부와 상관없이 Object 객체를 생성하는 모습이고 orElseGet은 비어있는 Optional 객체가 넘어온 경우에만 Supplier 함수형 인자를 사용해서 생성된 값을 반환한다.

### **결론**

orElseGet 은 Optional 객체가 비어있는 경우에만 함수가 호출되기 때문에 orElse 보다 성능상 이점이 있다.

**Optional에서의 orElse값이 null이 아닐 경우 그 해당 값을(Value) 반환하며 null일 경우 Type T를 그대로 반환한다.**
