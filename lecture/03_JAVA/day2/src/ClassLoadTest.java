class Product {
    private String prodNo;
    Product(String prodNo){
        this.prodNo = prodNo;
    }
}
class ProductDAO {
    private int totalCnt;
    public void add(Product p){
        totalCnt++;
    }
}
public class ClassLoadTest {
    public static void main(String[] args) {
        ProductDAO dao = new ProductDAO(); //dao는 지역변수 (local variable)
        for(int i=0; i<1000000; i++) { //i는 현재 블록에서만 사용가능
            dao.add(new Product("C" + i));
        }
    }
}
