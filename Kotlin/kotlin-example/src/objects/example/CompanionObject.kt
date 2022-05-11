package objects

fun main() {
    var a = Food()
    var b = Food()
    a.up()		//공용 변수 증가
    b.up()		//공용 변수 증가
    println(Food.total)
}

class Food {
    companion object {
        var total = 0
    }

    fun up() {
        total++
    }
}