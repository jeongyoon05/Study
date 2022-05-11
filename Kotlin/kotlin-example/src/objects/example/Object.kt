package objects.example

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