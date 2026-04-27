import java.util.StringTokenizer;

public class StringTest {
    public static void main(String[] args) {
        String s1, s2, s3, s4;
        s1 = "KB";
        s2 = "KB"; //s1과 같은 메모리
        s3 = new String("KB"); //새로운 메모리 할당
        s4 = new String("KB"); //새로운 메모리 할당
        System.out.println(s1 == s2); //true
        System.out.println(s1 == s3); //false
        System.out.println(s3 == s4); //false

        //Object의 equals()는 == 와 같음
        //String에서 equals()를 재정의해놨음 : 문자열 내용이 같으면 true 반환
        //The result is true if and only if the argument is not null and is a String object
        //that represents the same
        System.out.println(s1.equals(s2)); //true
        System.out.println(s1.equals(s3)); //true
        System.out.println(s3.equals(s4)); //true

        String str = "토마토";
        int size = str.length(); //3
        int i;
        for( i = 0; i < size/2; i++) {
            if (str.charAt(i) != str.charAt(size-1-i)) {
                break;
            }
        }
        if (i == size/2) {
            System.out.println(str + "은 앞뒤가 같은 문자열입니다");
        } else {
            System.out.println(str + "은 앞뒤가 다른 문자열입니다");
        }

        //indexOf() 를 활용해서 특정 문자열의 위치를 얻어낼 수 있다
        str = "https://www.kbstar.com";
        System.out.println(str.indexOf("com")); //index는 0부터 제공, 19
        //str.indexOf(".");
        System.out.println(str.lastIndexOf(".")); //18
        str.substring(19); //index19부터 끝까지의 부분문자열을 반환 com
        System.out.println(str.substring(0, 18)); //endIndex는 포함되지 않는다 0~17 https://www.kbstar

        String[] arr = "사과,,배".split(",", 3); //split()은 무조건 잘라낸다
        for (String s: arr) {
            /*
             ***사과***
             ******
             ***배***
             */
            System.out.println("***" + s + "***");
        }

//        StringTokenizer st = new StringTokenizer("사과,토마토,배", ",");
        StringTokenizer st = new StringTokenizer("사과,,배", ","); //StringTokenizer는 token단위 분리
        while (st.hasMoreTokens()) {
            String fruit = st.nextToken();
            System.out.println(fruit); //사과 배
        }
    }
}
