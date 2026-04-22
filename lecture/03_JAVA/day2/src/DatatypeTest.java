/**
 * 자료형
 *  - 기본 자료형
 *      정수 : byte(1바이트), short(2바이트), int(4바이트), long(8바이트)
 *      단일문자형 : char(2바이트)
 *      실수 : float(4바이트), double(8바이트)
 *      논리형 : boolean(1바이트)
 *          형변환 불가
 *
 *  - 참조 자료형
 */

public class DatatypeTest {
    public static void main(String[] args) {
        byte b = 127; // 최대값
        b++; //오버플로우
        System.out.println(b); // -128

        short s1, s2, s3;
        s1 = 10;
        s2 = 20;
//        s3 = s1 + s2; //s1이 short -> int 자동 형변환, s2도 short -> int
        s3 = (short)(s1 + s2); //연산순서 1) s1+s2 2) short로 변환 3) =대입

        System.out.println(12345);

        // long lon = 100; // 컴파일러는 100을 long이 아닌 int 타입으로 판단을 해버린다
        long lon = 100L; // 이렇게 써줘야 한다 (대문자로 선언하는 것이 일반적)

        // float f1 = 1234.56; // 컴파일 에러가 발생 -> 1234.56을 기본적으로 double로 판단하기 때문 (기본 자료형)
        float f1 = 1234.56F; // 이렇게 써줘야 한다
        double d = 1234.56;

        char c;
        c = 'A';
        c = 65;
        System.out.println(c); //A

        // boolean은 다른 자료형과 형변환이 불가하다
        // boolean bool = 0; //이런거 안된다
    }
}
