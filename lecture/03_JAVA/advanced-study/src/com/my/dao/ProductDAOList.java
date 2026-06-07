package com.my.dao;

import com.my.dto.Product;

import java.util.ArrayList;
import java.util.List;

public class ProductDAOList implements ProductDAO {
    private List<Product> products;

    public ProductDAOList() {
        this.products = new ArrayList<>();
    }

    @Override
    public void add(Product p) {
        for (Product oldP: products) {
//            if (oldP.getProdNo().equals(p.getProdNo())) {
//                System.out.println("이미 저장된 상품입니다");
//                return;
//            }
            if (oldP.equals(p)) {
                System.out.println("이미 저장된 상품입니다");
                return;
            }
        }
        products.add(p);
    }

    @Override
    public Product[] findAll() {
        //Product[] all = (Product[]) products.toArray(); //ClassCastException
        //toArray()의 반환형은 무조건 Object[] 이다

        //추후에는 stream()을 사용해서 처리
        Product[] all = new Product[products.size()];

        for (int i = 0; i < products.size(); i++) {
            all[i] = products.get(i);
        }

        return all;
    }
}
