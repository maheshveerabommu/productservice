package com.example.productservice.services;

import com.example.productservice.models.Product;
import com.example.productservice.repos.ProductRepo;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.awt.print.Pageable;
import java.util.List;

@Service
public class SearchService {

    ProductRepo productRepo;

    public SearchService (ProductRepo productRepo){
        this.productRepo=productRepo;
    }

    public List<Product> search(String keyword, int pageNumber, int pageSize){
        return productRepo.findByTitleContains(keyword, PageRequest.of(pageNumber,pageSize, Sort.by(Sort.Direction.DESC,"id")));
        //return null;
    }
}
