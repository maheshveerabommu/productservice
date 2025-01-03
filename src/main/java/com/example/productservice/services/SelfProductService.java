package com.example.productservice.services;

import com.example.productservice.models.Category;
import com.example.productservice.models.Product;
import com.example.productservice.repos.CategoryRepo;
import com.example.productservice.repos.ProductRepo;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("SelfProductService")
public class SelfProductService implements ProductService {
    ProductRepo productRepo;
    CategoryRepo categoryRepo;

    public SelfProductService(ProductRepo productRepo, CategoryRepo categoryRepo){
        this.productRepo = productRepo;
        this.categoryRepo = categoryRepo;
    }

    @Override
    public Product getProductByID(Long id) {
        //productRepo.findAllById(id);
        return productRepo.findProductById(id);
    }

    @Override
    public List<Product> getAllProducts() {
        return productRepo.findAll();
    }

    @Override
    public Product replaceProduct(Long id, Product product) {
        return null;
    }

    @Override
    public Product deleteProduct(Long id) {
        Product product=productRepo.findAllById(id);
        productRepo.deleteById(id);
        return product;
    }

    @Override
    public Product createProduct(Product product) {
        Category category=product.getCategory();
        if (category.getId()==null){
            Category savedcategory=categoryRepo.save(category);
            product.setCategory(savedcategory);
        }
        return productRepo.save(product);
    }
}
