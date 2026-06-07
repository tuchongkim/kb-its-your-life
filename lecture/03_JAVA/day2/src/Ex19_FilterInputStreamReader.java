import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

public class Ex19_FilterInputStreamReader {
    public static void main(String[] args) {
        /*
         * 리소스 : 키보드
         * 입력스트림 : InputStream
         * 필터스트림 : InputStreamReader, BufferedReader
         */
        InputStream is = System.in;
        try(BufferedReader br = new BufferedReader(new InputStreamReader(is))) {
            String line = null;
//            while (!(line = br.readLine()).equals("quit")) {
//                System.out.println("한줄내용: 종료하려면 quit을 입력하세요: " + line);
//            }
            do {
                System.out.println("한줄내용: 종료하려면 quit을 입력하세요: " + line);
            } while (!(line = br.readLine()).equals("quit"));

        } catch (Exception e) {

        }
    }
}
