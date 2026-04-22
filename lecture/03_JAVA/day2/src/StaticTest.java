
public class StaticTest {
    // java -cp ~~ StaticTest
    // 1. StaticTest.class 파일 찾기
    // 2. 바이트코드 검증
    // 3. 바이트코드를 JVM 메서드 영역에 저장
    //      3-1. static 변수 자동 초기화됨
    // 4. main 메서드 실행 (byte -> binary -> 실행)

    int iv;
    static int sv;
    void m() {

    }
    static void sm() {
//        System.out.println(this);
//        System.out.println(this.iv);
//        System.out.println(iv);
        System.out.println(sv);
//        this.m();
    }

    public static void main(String[] args) {
        System.out.println(sv);
        sv++; //1증가
        StaticTest t1 = new StaticTest();
        System.out.println(t1.sv); //1

        System.out.println(StaticTest.sv); //1
        t1.sv++;
        t1.iv++;

        StaticTest t2;
        t2 = new StaticTest();
        System.out.println(t2.sv); //2
        System.out.println(t2.iv); //0
    }
}
