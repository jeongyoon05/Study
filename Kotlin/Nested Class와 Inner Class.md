# Nested Class와 Inner Class

![Java - Inner classes](https://www.tutorialspoint.com/java/images/inner_classes.jpg)

#### Nested Class

Nested Class는 말 그대로 클래스 안에 클래스를 말한다.

Inner Class는 하위 개념이었다.





#### 차이점

Inner Class는 Outher Class의 필드를 참조 할 수 있다.

하지만 Nested Class는 참조하지 못한다.





> 정확한 개념을 몰라서 오류가 생겼었다😂 





###### Inner Class Ex

##### java

```java
ex) inner class

public class InnerClass {

	class Inner {
	
	}
}
```

##### kotlin

```kotlin
ex) inner class

class InnerClass {
    
	inner class Inner {
	
	}
}
```





###### Nested Class Ex

##### java

```java
ex) nested class

public class NestedClass {

	public static class Nested {
	
	}
}
```

##### kotlin

```kotlin
ex) inner class

class NestedClass {

	class Nested {
	
	}
}
```



