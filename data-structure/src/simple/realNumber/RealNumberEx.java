package simple.realNumber;

import java.math.BigDecimal;

public class RealNumberEx {
    public static void main(String[] args) {

        float f = 0.1f; //4byte
        double d = 0.1; //8byte

        System.out.println(f);
        System.out.println(d);

        BigDecimal num1 = new BigDecimal("0.001");
        BigDecimal num2 = new BigDecimal("0.1");

        //BigDecimal
        // 실수형 소수점 사칙연산의 한계를 극복하며 큰 수를 다루기 위해 사용됩니다.
        // 단점은 느립니다.

        System.out.println(num1.add(num2)); //더하기
        System.out.println(num1.subtract(num2)); //빼기
        System.out.println(num1.multiply(num2)); //곱하기
    }
}
