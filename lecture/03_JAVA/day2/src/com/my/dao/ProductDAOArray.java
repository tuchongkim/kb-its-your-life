package com.my.dao;

import com.my.dto.Product;

/**
 * DataAccessObject : 자료처리용 객체
 */
public class ProductDAOArray implements ProductDAO {
    private Product[] products; //상품저장소
    private int totalCnt; //저장된 상품수

    /**
     * 저장소의 최대 상품 저장길이를 설정한다
     * @param size 상품저장길이
     */
    public ProductDAOArray (int size) {
        products = new Product[size];
    }

    /**
     * 매개변수로 전달된 상품을 저장소에 추가한다
     * 단, 이미 저장된 상품이라면 "이미 존재하는 상품입니다"메시지를 출력하고 저장하지 않는다
     * @param p 상품
     */
    @Override
    public void add(Product p) {
        for (int i = 0; i < totalCnt; i++) {
            Product oldP = products[i];
            if (p.getProdNo().equals(oldP.getProdNo())) {
                System.out.println("이미 존재하는 상품입니다");
                return;
            }
        }
        products[totalCnt] = p;
        totalCnt++;
    }

    /**
     * 저장소에 저장된 상품들을 모두 반환한다
     * @return
     */
    @Override
    public Product[] findAll() {
        Product[] existingProducts = new Product[totalCnt];

        System.arraycopy(products, 0, existingProducts, 0, totalCnt);

        return existingProducts;
    }
}
