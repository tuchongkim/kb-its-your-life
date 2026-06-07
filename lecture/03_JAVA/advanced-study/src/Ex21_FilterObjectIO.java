import java.io.*;
import java.util.Date;

class A {
    int i = 10;
    int j = 20;
}

class A2 implements Serializable {
    transient int i = 10; //직렬화에서 제외
    int j = 20;

    A2(int i, int j) {
        this.i = i;
        this.j = j;
    }

    @Override
    public String toString() {
        return "A2{" +
                "i=" + i +
                ", j=" + j +
                '}';
    }
}

public class Ex21_FilterObjectIO {
    public static void main(String[] args) {

        /*
        타깃 : 파일(a.ser)
        출력스트림 : FileOutputStream
        필터스트림 : ObjectOutputStream
         */
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("C:\\Users\\rhino\\projects\\kb-its-your-life\\lecture\\03_JAVA\\day2\\resources\\a.ser"))){
            oos.writeObject(new Date()); //직렬화
            //oos.writeObject(new A()); //NotSerializableException 발생
            oos.writeObject(new A2(999, 999));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        /*
        역직렬화
        리스소 :  파일(a.ser)
        입력스트림 : FileInputStream
        필터스트림 : ObjectInputStream
         */
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("C:\\Users\\rhino\\projects\\kb-its-your-life\\lecture\\03_JAVA\\day2\\resources\\a.ser"))) {
            Object obj = ois.readObject(); //역직렬화
            System.out.println(obj);
            Object obj1 = ois.readObject();
            System.out.println(obj1); //obj1.toString() 자동 호출됨
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
