fun main() {
    val va = a("a", 123)

    println(va == a("a", 123))
    println(va)

    val vb = b("a", 123)

    println(vb == b("a", 123))
    println(vb)

    //복사
    println(vb.copy())
    println(vb.copy(name = "b"))
    println(vb.copy(id = 234))

    val list = listOf<b>(
        b("a", 123),
        b("b", 234),
        b("c", 345)
    )
    //자동으로 변수의 위치를 판별해 a, b에 값을 넣어준다
    for ((a, b) in list) {
        println("$a $b")
    }
}

class a(val name: String, val id: Int)
data class b(val name: String, val id: Int)