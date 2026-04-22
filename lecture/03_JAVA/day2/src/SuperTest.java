import com.my.dto.Coffee;
import com.my.dto.Product;
//import com.my.dto.*;

public class SuperTest {
    public static void main(String[] args) {
        Product p = new Product(); //Product() 생성자 호출됨
        Coffee c = new Coffee(); //부모생성자 자동호출됨
        Coffee c1 = new Coffee("C0001", "아메리카노","과테말라", 12000);
    }
}
