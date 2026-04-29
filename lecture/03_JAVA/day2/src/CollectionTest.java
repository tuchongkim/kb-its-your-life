import com.my.dto.Product;

import java.util.*;

public class CollectionTest {
    public static void m(Collection c) {
        //Collection은 인터페이스이다
        //인터페이스는 toString() 메서드를 지원하지 않는다
        System.out.println(c); //c.toString() 자동호출됨 -> 여기서 toString()은 구현체에서 오버라이딩된 메서드

        //for(int i=0;i<c.size(); i++) { c.get(i); } //안됨

        for(Object e: c) {
            System.out.println(e);
        }

    }

    public static void m(Map map) {
        System.out.println(map);
    }

    public static void main(String[] args) {
        Map map = new HashMap(); //hashCode 값으로 key 구분 -> 같으면 equals() 수행
        map.put(1, "First");
        map.put(2, "Second");
        map.put(1, "Third");
        map.put(4, "Fourth");
        map.put(0, "Zero");
        map.put(new Product("C0001", "상품1", 1000), 1);
        map.put(new Product("C0001", "다른상품", 2000), 2);
        m(map);

//        Collection c = new Collection(); //불가능
//        Collection c = new ArrayList();
        Collection c = new HashSet(); //hashCode 값으로 값 구분 -> 같으면 equals() 수행
//        Collection c = new HashMap(); //불가능

        c.add(Integer.valueOf(1)); //Boxing
        c.add(2); //AutoBoxing : 컴파일시에 Boxing(Integer.valueOf(2))로 코드 변환
        c.add("HELLO");
        c.add("2");
        c.add(2);

        // 서로 중복되었다고 판단하기 위해서는 hashCod() 메서드도 오버라이딩해야 한다
        c.add(new Product("C0001", "상품1", 1000));
        c.add(new Product("C0001", "다른상품", 2000));
        m(c);
    }
}
