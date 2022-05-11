# Object

객체가 하나만 필요해서 사용하는 경우에 쓰는 키워드 -> 싱글톤 디자인패턴

*자바에서 static 키워드

```kotlin
fun main() {
    Counter.countUp()
    println(Counter.count)
    Counter.clear()
    println(Counter.count)
}
object Counter { // Counter의 메서드, 변수 모두 static을 적용해준다.
    var count = 0
    fun countUp() {
        count++
    }

    fun clear() {
        count = 0
    }
}
```

class 안에서도 object를 만들 수 있는데 키워드는 companion object이다. 

```kotlin
fun main() {
    var a = Food()
    var b = Food()
    a.up()		//공용 변수 증가
    b.up()		//공용 변수 증가
    println(Food.total)
}

class Food() {
    companion object {
        var total = 0
    }

    fun up() {
        total++
    }
}
```

