package ch11.sec02.exam01;

public class ExceptionHandlingExample1 {
    /**
     * 문제점:
     * data가 null인 경우에 대한 예외처리가 없기 때문에 NullPointerException이 발생할 수 있다
     * Exception in thread "main" java.lang.NullPointerException: Cannot invoke "String.length()" because "data" is null
     * @param data
     */
    public static void printLength(String data) {
        try {
            int result = data.length();
            System.out.println("문자 수: " + result);
        } catch (NullPointerException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
        System.out.println("[프로그램 시작]\n");
        printLength("ThisIsJava");
        printLength(null);
        System.out.println("[프로그램 종료]");
    }
}
