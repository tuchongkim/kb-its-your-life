class Single {
    private static Single s = new Single();
    private Single() {

    }
    static public Single getInstance() {
        return s;
    }
}

public class SingletonTest {
    public static void main(String[] args) {
        Single s1, s2;
//        s1 = new Single(); //가 오류가 발생하도록 Single을 바꾸세요
        s1 = Single.getInstance();
        s2 = Single.getInstance();
        System.out.println(s1 != null); //true
        System.out.println(s1 == s2); //true
    }
}
