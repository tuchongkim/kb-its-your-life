import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.BinaryOperator;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class StudentScore{
    private String name;
    private int score;

    public StudentScore(String name, int score) {
        this.name = name;
        this.score = score;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    @Override
    public String toString() {
        return "StudentScore{" +
                "name='" + name + '\'' +
                ", score=" + score +
                '}';
    }
}
public class Ex17_StreamTest {
    public static void main(String[] args) {
        System.out.println("""
    1. 다음 문자열 리스트에서 길이가 5 이상인 문자열만 필터링하여 대문자로 변환한 뒤, 새로운 리스트로 수집하는 코드를 작성하세요.""");
        List<String> words = Arrays.asList("apple", "banana", "cherry",  "pineapple");
        List<String> result = null;

        //TODO 1. 완성하세요
        result = words.stream()
            .filter(w -> w.length() >= 5)
            .map(w -> w.toUpperCase()) //.map(String::toUpperCase)
            .collect(Collectors.toList());
        System.out.println(result);


        System.out.println("""
    2. 정수 리스트에서 짝수만 골라 그 합계를 구하는 코드를 스트림으로 구현하세요.""");
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        int evenSum = 0;
        //TODO 2-1. IntStream의 sum()활용합니다
        evenSum = numbers.stream()
                .filter(n -> n % 2 == 0)
                .mapToInt(inte -> inte.intValue()) //.mapToInt(Integer::intValue)
                .sum();
        System.out.println("IntStream의 sum()=" + evenSum);

        //TODO 2-2. reduce()를 활용하면 데이터를 계속 줄여서 값 하나로 만들 수 있어요
        evenSum = 0;
        Integer identity = 0; //초기값
        BinaryOperator<Integer> accumulator =  (before,current)-> before+current;
/*                before(이전값)   current(현재값)  결과
                      0              2              2
                      2              4              6
                      6              6              12
                      12             8              20
                      20            10              30
*/
        evenSum = numbers.stream()
                    .filter(n -> n % 2 == 0)
                    .reduce(identity, accumulator);
        System.out.println(" reduce()를 활용=" + evenSum);
//--------------------------------------------------------------
        List<StudentScore> students =
                Arrays.asList(new StudentScore("Kim", 75),
                        new StudentScore("Lee", 85),
                        new StudentScore("Park", 90));

        System.out.println("""
    3. 위의 students에서 점수가 80점 이상인 학생들의 이름만 추출하여 콤마(,)로 구분된 하나의 문자열로 만드세요.
        hint : Collectors.joining(delim) : Collector    은 스트림 요소를 하나의 문자열로 합칠 때 사용합니다.
         ex) Collectors.joining(",")
         """);

        String str = null;
        //TODO 3. 완성
        str = students.stream()
                .filter(s -> s.getScore() >= 80)
                .map(s -> s.getName())
                .collect(Collectors.joining(","));
        System.out.println(str);

        System.out.println("""
    4. 위의 students에서 최고점을 출력하세요""");
        int maxPrice = 0;
        //TODO 4.
        maxPrice = students.stream()
                .map(s -> s.getScore())
                .max((a, b) -> a.compareTo(b)) //.max(Integer::compareTo)
                .orElse(0);
        System.out.println(maxPrice);

        System.out.println("""
    5. 위의 students에서 최고점을 받은 학생정보를 출력하세요
    hint : Comparator.comparing()은 람다로 작성할 비교 로직을 생성해주는 팩토리 메서드
    """);
        StudentScore topStudent = null;
        //TODO 5.
        topStudent = students.stream()
                        //.max((a, b) -> Integer.compare(a.getScore(), b.getScore()))
                        .max(Comparator.comparing(StudentScore::getScore))
                        .orElse(null);
        System.out.println(topStudent);

//--------------------------------------------------------------
        System.out.println("""
    6. 위의 students를 최고점받은 학생부터 내림차순해서 출력하세요
    hint : Comparator.reversed()""");
        students.stream()
                //.sorted((a, b) -> Integer.compare(b.getScore(), a.getScore()))
                .sorted(Comparator.comparing(StudentScore::getScore).reversed())
                //.forEach(s -> System.out.println(s));
                .forEach(System.out::println);
    }
}
