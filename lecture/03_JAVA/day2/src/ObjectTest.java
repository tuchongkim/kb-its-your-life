public class ObjectTest {
    public static void main(String[] args) {
        Object o1, o2; //자바취상위 클래스 java.lang.Object
        o1 = new Object();
        System.out.println(o1.hashCode()); //객체정보값 : 2003749087
        o2 = new Object();
        System.out.println(o2.hashCode()); //객체정보값 : 1324119927
        System.out.println(o1 == o2); //false

        System.out.println(o1.toString()); //객체정보값을 문자열로 표현 : java.lang.Object@776ec8df [클래스 이름]@[해시코드값을 16진수로 표현한 값]

        System.out.println(o1.equals(o2)); //o1==o2와 같음 : false
    }
}
