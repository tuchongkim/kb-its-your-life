/**
 * Java에서
 * 인자값이 메서드의 매개변수에 대입되는 방식은 CallByValue이다
 * 인자값이 매개변수에 복붙된다
 */
public class CallByValue {
    void m(int i) {
        i = 100;
    }

    void m(int[] arr) {
        // 오버로드
        // 메서드 명이 같고, 매개변수의 타입이 다르거나, 갯수가 다르거나, 순서가 다른 경우
        arr[0] = 100;
    }

    public static void main(String[] args) {
        CallByValue c = new CallByValue();
        int i = 99;
        c.m(i);
        System.out.println(i); //99

        int[] arr = {99, 1, 7};
        c.m(arr);
        System.out.println(arr[0]); //100
    }
}
