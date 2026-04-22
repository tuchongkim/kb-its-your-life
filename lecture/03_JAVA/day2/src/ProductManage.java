import com.my.dao.ProductDAO;
import com.my.dao.ProductDAOArray;
import com.my.dto.Coffee;
import com.my.dto.Product;

public class ProductManage {
    public static void main(String[] args) {
//        Product p = new Product();
        String prodNo = "C0001";
        String prodName = "아메리카노";
        int prodPrice = 1000;
        String origin = "과테말라";

        Product p1 = new Product(prodNo, prodName, prodPrice);

        Coffee c1 = new Coffee(prodNo, prodName, origin, prodPrice);
//        c1.printInfo();
        System.out.println(c1); //"C0001:아케리카노:1000:과테말라"가 출력되도록 한다 -> toString() 메서드 오버라이딩
        // System.out.println(Object x); -> String.valueOf(x); -> x.toString();


//        String no1 = p1.getProdNo();
//        String name1 = p1.getProdName();
//        int price1 = p1.getProdPrice();
//        System.out.println(no1 +":" + name1 + ":" + price1);

        p1.printInfo();

        ProductDAO dao;
        dao = new ProductDAOArray(5); //추후에 바꿔야 함 (BAD CODE)
        dao.add(c1);
        dao.findAll();
        Product[] all = dao.findAll();
        for (int i = 0; i < all.length; i++) {
            System.out.println(all[i]);
        }

        /*
        ProductDAOArray dao = new ProductDAOArray(5);
        dao.add(p1);
        dao.add(new Product("C0001", "다른상품", 2000));

        Product[] all = dao.findAll();
        for (int i = 0; i < all.length; i++) {
            all[i].printInfo(); //저장된 상품만 출력
        }
         */
    }
}
