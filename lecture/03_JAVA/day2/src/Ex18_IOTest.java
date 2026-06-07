import java.io.*;

public class Ex18_IOTest {
    public static void main(String[] args) {
        //리소스부터 결정하기 -> 이에맞는 input stream 결정
        /*
         * 리소스 : 키보드
         * 입력스트림 : InputStream
         */
//        InputStream is = System.in;
//        try {
//            int readValue = -1;
//            while ((readValue = is.read()) != -1) { //A는 65, 가는 234
//                System.out.println(readValue);
//            }
//            System.out.println((char)readValue); //한글깨짐이 발생할 수 있다
//            //알파벳이나 특수문자들은 충분히 char 타입으로 변환 가능하다
//            //한글은 한 글자당 2바이트에서 3바이트까지 사용하기 때문에 문제가 발생
//
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }

        /*
         * 리소스 : 파일
         * 입력스트림 : FileInputStream
         */
        String fileName = "C:\\Users\\rhino\\projects\\kb-its-your-life\\lecture\\03_JAVA\\day2\\resources\\a.txt";
//        FileReader fr = null;
//        try {
//            fr = new FileReader(fileName); //문자 단위로 읽기
//            char[] arr = new char[10];
//            int readCnt = -1;
//
//            while((readCnt = fr.read(arr, 0, arr.length)) != -1) {
//                for (int i = 0; i < readCnt; i++) {
//                    System.out.println(arr[i]);
//                }
//            }
//
////            readCnt = fr.read(arr, 0, arr.length);
////            for (byte b: arr) {
////                System.out.print(b); //한글깨짐 현상 주의
////            }
//        } catch (FileNotFoundException e) {
//            throw new RuntimeException(e);
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        } finally {
//            //레거시 코드 - close를 하기위해 예외처리를 또 해준다
//            if (fr != null) {
//                try {
//                    fr.close(); //NullPointerException 발생 가능
//                } catch (IOException e) {
//                    throw new RuntimeException(e);
//                }
//            }
//        }

        try (FileReader fr = new FileReader(fileName)) {
            char[] arr = new char[10];
            int readCnt = -1;

            while((readCnt = fr.read(arr, 0, arr.length)) != -1) {
                for (int i = 0; i < readCnt; i++) {
                    System.out.println(arr[i]);
                }
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
