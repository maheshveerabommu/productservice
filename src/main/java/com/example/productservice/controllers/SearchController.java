package com.example.productservice.controllers;

import com.example.productservice.models.Product;
import com.example.productservice.services.SearchService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/search")
public class SearchController {

    SearchService serachService;

    public SearchController( SearchService searchService ){
        this.serachService=searchService;
    }

    @GetMapping
    public List<Product> search (
        @RequestParam("keyword") String keyword,
        @RequestParam(value= "pageNumber", defaultValue = "0") int pageNumber,
        @RequestParam(value = "pageSize", defaultValue = "3") int pageSize) {
        return serachService.search(keyword,pageNumber,pageSize);
    }

}
