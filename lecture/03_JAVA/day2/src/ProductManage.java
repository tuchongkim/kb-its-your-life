import com.my.dao.ProductDAO;
import com.my.dao.ProductDAOArray;
import com.my.dto.Coffee;
import com.my.dto.Product;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Properties;

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

        ProductDAO dao = null;
//        dao = new ProductDAOArray(5); //추후에 바꿔야 함 (BAD CODE)
        Properties env = new Properties();
        try {
            env.load( new FileInputStream("c:\\my.properties"));
            String className = env.getProperty("dao");
            //className으로 클래스 로드
            Class clazz = Class.forName(className);
            //clazz.getDeclaredMethods();
            dao = (ProductDAO) clazz.getDeclaredConstructor().newInstance();
        } catch (FileNotFoundException e) { //자식 Exception
            System.out.println(e.getMessage());
        } catch (IOException e) { //부모 Exception
            System.out.println(e.getMessage());
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        } catch (InstantiationException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        } catch (NoSuchMethodException e) {
            throw new RuntimeException(e);
        }

        System.out.println(">>>상품 추가<<<");
        dao.add(c1);
        System.out.println(">>>상품 전체조회<<<");
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
