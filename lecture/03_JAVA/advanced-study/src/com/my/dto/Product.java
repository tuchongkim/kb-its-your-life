package com.my.dto;

import java.util.Objects;

/**
 * DataTransferObject: 자료 전달용 객체
 */
public class Product { //컴파일시에 extends Object
    protected String prodNo;
    protected String prodName;
    private int prodPrice;

    public Product() {
        System.out.println("Product() 생성자 호출");
    }
    public Product(String prodNo, String prodName, int prodPrice) {
        this.prodNo = prodNo;
        this.prodName = prodName;
        this.prodPrice = prodPrice;
    }

    public String getProdNo() {
        return prodNo;
    }

    public String getProdName() {
        return prodName;
    }

    public int getProdPrice() {
        return prodPrice;
    }

    public void printInfo() {
        System.out.println(prodNo +":" + prodName + ":" + prodPrice);
    }

    @Override
    public String toString() {
        return prodNo + ":" + prodName + ":" + prodPrice;
    }

//    @Override
//    public boolean equals(Object obj) {
//        if (obj instanceof Product) {
//            Product p = (Product) obj;
//            if (this.prodNo.equals(p.prodNo)) {
//                return true;
//            }
//        }
//        return false;
//    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Objects.equals(prodNo, product.prodNo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(prodNo);
    }
}
