package com.umit.service;

import com.umit.entity.Product;
import com.umit.repository.ProductRepository;
import com.umit.utility.IService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductService implements IService<Product,Long> {

    private final ProductRepository productRepository;

    @Override
    public Product save(Product product) {
        return productRepository.save(Product.builder()
                .productName(product.getProductName())
                .productCategory(product.getProductCategory())
                .productPrice(product.getProductPrice())
                .productUnitInStock(product.getProductUnitInStock())
                .productDescription(product.getProductDescription())
                .build());
    }
    @Override
    public Product update(Product product) {
        Optional<Product> product1 = productRepository.findById(product.getId());

        if(product1.isEmpty()){
            //exception fırlatıyorum.
        }
        return productRepository.save(product);
    }

    @Override
    public Iterable<Product> saveAll(Iterable<Product> t) {
        return null;
    }

    @Override
    public void delete(Product product) {
        productRepository.delete(product);
    }

    @Override
    public void deleteById(Long id) {
        productRepository.deleteById(id);
    }

    @Override
    public Optional<Product> findById(Long id) {
        return productRepository.findById(id);
    }

    @Override
    public List<Product> findAll() {
        return productRepository.findAll();
    }

    public Optional<Product> findByProductName(String productName){
        if(productName.equalsIgnoreCase(productRepository.findByProductName(productName).get().getProductName())){
            return productRepository.findByProductName(productName);
        }
        return null;
    }

    public Optional<Product> findByProductNameIgnoreCase(String productName){
        return productRepository.findByProductNameIgnoreCase(productName);
    }
    public  List<Product> findAllByProductNameLikeIgnoreCase(String productName){
        return productRepository.findAllByProductNameLikeIgnoreCase(productName);
    }

    public List<Product> findAllByProductNameContainingIgnoreCase(String productName){
        return productRepository.findAllByProductNameContainingIgnoreCase(productName);
    }

    public List<Product> findAllByProductPriceBetween(Double start, Double end){
        return productRepository.findAllByProductPriceBetween(start,end);
    }

    public List<Product> findAllByProductPriceGreaterThan(Double productPrice) {
        return productRepository.findAllByProductPriceGreaterThan(productPrice);        //1.soru
    }
    public List<Product> findAllByProductUnitInStockGreaterThan(Integer productUnitInStock) {
        return productRepository.findAllByProductUnitInStockGreaterThan(productUnitInStock);    //2.soru
    }
    public List<Product> findAllByProductPriceGreaterThanEqual(Double productPrice) {
        return productRepository.findAllByProductPriceGreaterThanEqual(productPrice);       //3.soru
    }

    public List<Product> findAllByProductCategory(String productCategory) {
        return productRepository.findAllByProductCategory(productCategory);
    }
    //4.soru
    public int countProductsByCategory(String productCategory) {
        List<Product> products = findAllByProductCategory(productCategory);
        return products.size();
    }

    public List<Product> findAllByProductName(String productName) {
        return productRepository.findAllByProductName(productName);
    }                                                                          //5.sru
    public int countProductsByName(String productName) {
        List<Product> products = findAllByProductName(productName);
        return products.size();
    }

    public boolean doesCategoryExist(String productCategory) {
        return productRepository.existsByProductCategory(productCategory);      //6.soru
    }

    public List<Product> findProductsByNullCategory() {
        return productRepository.findAllByProductCategoryIsNull();  //7.soru
    }

    public List<Product> findProductsByCategoryStartingWith(String categoryPrefix) {
        return productRepository.findAllByProductCategoryStartingWithIgnoreCase(categoryPrefix);        //8.soru
    }

}