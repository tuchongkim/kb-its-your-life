import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class Ex20_FilterDataIO {
    public static void main(String[] args) {
        /*
        타깃 : 파일(a.dat)
        출력스트림 : FileOutputStream
        필터스트림 : DataOutputStream
         */
        try(
            DataOutputStream dos = new DataOutputStream(new FileOutputStream("C:\\Users\\rhino\\projects\\kb-its-your-life\\lecture\\03_JAVA\\day2\\resources\\a.dat"))
        ){
            dos.writeUTF("홍길동"); //UTF-8 9+2
            dos.writeInt(1); //4
            dos.writeDouble(2.0); //8
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        /*
        리스소 :  파일(a.dat)
        입력스트림 : FileInputStream
        필터스트림 : DataInputStream
         */
        //TODO 1. 완성하세요

        try(
                DataInputStream dis = new DataInputStream(new FileInputStream("C:\\Users\\rhino\\projects\\kb-its-your-life\\lecture\\03_JAVA\\day2\\resources\\a.dat"))
        ){
            String s = dis.readUTF();
            int i = dis.readInt();
            double d = dis.readDouble();
            System.out.println(s + " : " + i + " : " + d);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
