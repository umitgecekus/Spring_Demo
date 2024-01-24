package com.umit.repository;

import com.umit.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<Product,Long> {
    /*
    # Ürün ismine göre ürünü bulunuz.
# Ürün isminin içerdiği harf veya kelimeye göre ürünü bulunuz.
# Belirli fiyat aralığındaki ürünleri listeleyiniz.
     */
    //codeium
    Optional<Product> findByProductName(String productName);
    Optional<Product> findByProductNameIgnoreCase(String productName);

    List<Product> findAllByProductNameLikeIgnoreCase(String productName);
    List<Product> findAllByProductNameContainingIgnoreCase(String productName);
    List<Product> findAllByProductPriceBetween(Double start, Double end);
    List<Product> findAllByProductPriceGreaterThan(Double productPrice);     //1.soru
    List<Product> findAllByProductUnitInStockGreaterThan(Integer productUnitInStock);     //2.soru
    List<Product> findAllByProductPriceGreaterThanEqual(Double productPrice);   //3.soru
    List<Product> findAllByProductCategory(String productCategory);     //4.soru
    List<Product> findAllByProductName(String productName);     //5.soru
    boolean existsByProductCategory(String productCategory);    //6.soru
    List<Product> findAllByProductCategoryIsNull();     //7.soru
    List<Product> findAllByProductCategoryStartingWithIgnoreCase(String categoryPrefix);    //8.soru
}
