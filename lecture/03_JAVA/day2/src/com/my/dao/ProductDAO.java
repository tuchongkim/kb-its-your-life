package com.my.dao;

import com.my.dto.Product;

public interface ProductDAO {
    /**
     * 상품을 저장소에 저장한다
     * 상품번호가 중복되면 저장하지 않는다
     * @param p
     */
    void add(Product p);

    /**
     * 저장소의 모든 상품을 반환한다
     * @return 저장소가 비어있다면 null을 반환한다
     */
    Product[] findAll();
}
