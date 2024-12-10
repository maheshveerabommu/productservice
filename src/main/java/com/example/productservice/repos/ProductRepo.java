package com.example.productservice.repos;

import com.example.productservice.models.Product;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface ProductRepo extends JpaRepository<Product, Long> {

    Product findAllById(Long id);

    //@Query(value = "SELECT p.* FROM Product p JOIN Category c ON p.category_id = c.id WHERE p.id = :id", nativeQuery = true)
    //@Query(value= "select * from product where id= :id", nativeQuery = true)
    @EntityGraph(type= EntityGraph.EntityGraphType.FETCH ,attributePaths = "category")
    Product findProductById(Long id);

//
//    @Query("SELECT p FROM Product p WHERE p.id = :id")
//    Product findProductById(@Param("id") Long id);

    List<Product> findAll();

    @Override
    void deleteById(Long id);

    //    @Query("DELETE FROM Product p where p.id = :id RETURNING p")
//    Product deleteByIdAndReturn(Long id);

    //List<Product> findByTitleContains(String keyword, Pageable pageable);
    List<Product> findByTitleContains(String keyword, Pageable pageable);

}
