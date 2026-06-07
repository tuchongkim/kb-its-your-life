package com.my.dto;

public class Coffee extends Product {
    private String origin; //원산지

    public Coffee(){}

    @Override
    public String toString() {
        return super.toString() + ":" + origin;
//        return prodNo + ":" + prodName + ":" + getProdPrice() + ":" + origin;
    }

    public Coffee(String prodNo, String prodName, String origin, int prodPrice) {
        //this.prodNo = prodNo;
        //super.prodNo = prodNo; //부모의 private 정보에 접근 불가하다
        super(prodNo, prodName, prodPrice); //부모생성자 호출, 이코드를 생략하면 부모생성자()가 호출됨
        this.origin = origin;
    }
}
