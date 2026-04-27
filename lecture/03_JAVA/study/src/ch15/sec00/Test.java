package ch15.sec00;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Test {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("Test");

        // of() 메서드를 활용해서 간단하게 초기화 가능
        // readonly로 생성한다 -> 해당 리스트엣 추가/삭제 작업을 하게 되면 예외가 발생한다
        List<String> list2 = List.of("Test1", "Test2", "Test3");
        System.out.println(list2);

        // list2.add("Test4"); //불가능
        // list2.clear(); //불가능

        Map<String, String> map = Map.of("k1", "v1", "k2", "v2");
        System.out.println(map);
    }
}
