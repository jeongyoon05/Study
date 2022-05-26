# Null 처리

자바에서는 보통 if (변수 == null) 형식으로 null값을 처리한다.

코틀린 에서는 ? ?: !!을 통해 null값을 처리한다.



1. #### ' ?. ' - 안전 호출 연산자 (safe calls)

   ```kotlin
   val nullable: String? = null
   println(nullable?.length)
   ```

   - 코틀린에서 nullable 한 변수를 처리할때 가장 자주 사용되는 방법이다.
   - 안전 호출 연산자는 '?' 이다.
   - null값을 검사하여 null이면 건너뛰고 null이 아닐 때는 호출된 연산을 실행한다.

2. #### ' ?: ' - Elvis 연산자

   ```kotlin
   var nullable: String? = null
   var nonNullable: String = nullable ?: "반환 될 문자열"
   ```

   - Elvis 연산자는 '?:' 이다.

   - 왼쪽의 피연산자(nullbale)가 null 이면 오른쪽 피연산자("반환될 문자열")를 실행하고

     **오른쪽 피연산자("반환 될 문자열")가 null 이면 왼쪽 피연산자(nullbale)를 실행한다.**

3. #### ' !! ' - double-bang 연산자 (non-null 단언 연산자)

   ```kotlin
   var nullable: String? = null
   val lengthOfText = nullable!!.length
   ```

   - non-null 단언 연산자는 '!!' 이다.

   - 이 연산자 nullable 변수에 쓰면 ‘nullable 변수이지만 여기에 null이 절대 할당되지 않았음을 내가 단언한다.’

     라는 의미를 지님.

   **✅주의**

   NPE(NullPointerException)를 일으킬 수 도 있으므로 주의 깊게 사용해야 한다.

4. #### ' as? ' - Safe Cast

   ```kotlin
   val aInt: Int? = a as? Int
   ```

   - 안전한 캐스팅 연산자는 'as?' 이다.
   - 캐스팅이 실패한 경우 null이 할당 됨

5. #### **Collections of a nullable type**

   ```kotlin
   val nullableList: List<Int?> = listOf(1, 2, null, 4)
   val intList: List<Int> = nullableList.filterNotNull()
   ```

   - Collection에 있는 Null 객체를 미리 제거할 수 있는 함수도 제공한다.

   - 다음은 List에 있는 null 객체를 filterNotNull 메소드를 이용하여 삭제하는 코드이다.