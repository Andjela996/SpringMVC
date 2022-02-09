package com.example.demo2.services;

import com.example.demo2.domain.Product;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.*;

@Service
public class ProductServiceImpl implements  ProductService {
    private Map<Integer, Product> products;

    public ProductServiceImpl(){
        loadProducts();
    }

    @Override
    public List<Product> listAllProducts() {
        return new ArrayList<>(products.values());
    }

    @Override
    public Product getProductById(Integer id) {
        return products.get(id);
    }

    @Override
    public Product saveOrUpdateProduct(Product p) {
        if(p!=null){
            if(p.getId()==null){
                p.setId(getNextKey());

            }
            products.put(p.getId(), p);
            return p;
        }
        else{
            throw new RuntimeException("Product can't be null");
        }
    }

    @Override
    public void deleteProduct(Integer id) {
        products.remove(id);
    }

    private Integer getNextKey() {
        return Collections.max(products.keySet())+1;

    }

    private void loadProducts(){
        products = new HashMap<>();

        Product p1= new Product();
        p1.setId(1);
        p1.setDescription("Product 1");
        p1.setPrice((float) 2.99);
        //p1.setImageUrl();

        Product p2= new Product();
        p2.setId(2);
        p2.setDescription("Product 2");
        p2.setPrice((float) 14.99);

        Product p3= new Product();
        p3.setId(3);
        p3.setDescription("Product 3");
        p3.setPrice((float) 8.99);

        Product p4= new Product();
        p4.setId(4);
        p4.setDescription("Product 4");
        p4.setPrice((float) 21.99);
        products.put(1, p1);
        products.put(2, p2);
        products.put(3, p3);
        products.put(4, p4);


    }
}
