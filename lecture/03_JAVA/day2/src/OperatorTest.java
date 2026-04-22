/**
 * @author 오문정
 *
 * 연산자 종류
 * - 산술연산자: +, -, *, /, %
 * - 비교연산자: >, >=, <, <=, ==, !=
 * - 논리연산자: &&, ||, !
 * - 증감연산자: ++, --
 * - 대입연산자: =, +=, -=, *=, /=, %=
 *
 */
public class OperatorTest {
    public static void main(String[] args) {
        // 산술연산자
        int a = 2; //정수
        int b = 3; //정수
        int c = a / b; //정수/정수는 정수
        System.out.println(c); //0
        b = 0;
        // c = a/b; //정수/정수의 값이 Infinity가 될 수 없다, 정수/0는 ArithmeticException 발생 후 프로그램 종료
        // System.out.println(c);

        System.out.println(2.0/0.0); //실수/0.0 는 Infinity
        a = 2; b= 3;
        float f = a/b;
        System.out.println(f); //0.0
    }
}
