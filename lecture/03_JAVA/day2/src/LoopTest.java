import java.util.Scanner;

public class LoopTest {
    public static void main(String[] args) {
        //1~10까지 출력하세요
        for (int i = 1; i <= 10; i++) {
            System.out.println(i);
        }

        //'A'~'Z'까지 출력하세요
        for (int i = 'A'; i <= 'Z'; i++) {
            System.out.println((char) i);
        }
        for (char c = 'A'; c <= 'Z'; c++) {
            System.out.println(c);
        }

        //키보드로 입력받기
        Scanner sc = new Scanner(System.in);
//        while(true) {
//            System.out.print("입력하세요[정료하려면 quit을 입력하세요]: ");
//            String line = sc.nextLine();
//            System.out.println(line);
//            if (line.trim().equals("quit")) { //line == "quit" 이러면 절대 안된다!
//                break;
//            }
//        }

        String line;
        do {
            System.out.print("입력하세요[정료하려면 quit을 입력하세요]: ");
            line = sc.nextLine();
            System.out.println(line);
        } while(!line.equals("quit"));
    }
}
