package com.example.productservice.services;

import com.example.productservice.dtos.FakeStoreProductDto;
import com.example.productservice.models.Category;
import com.example.productservice.models.Product;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
public class FakeProductService implements ProductService {

    RestTemplate restTemplate;
    public FakeProductService(RestTemplate restTemplate){
        this.restTemplate = restTemplate;
    }
    @Override
    public Product getProductByID(Long id) {
        FakeStoreProductDto fakeStoreProductDto=restTemplate.getForObject("https://fakestoreapi.com/products/"+id,
                FakeStoreProductDto.class);
        return convertFakeStoreProductDtoToProduct(fakeStoreProductDto);
    }

    public List<Product> getAllProducts(){
        FakeStoreProductDto[] fakeStoreProductDtoList=
                restTemplate.getForObject("https://fakestoreapi.com/products", FakeStoreProductDto[].class);

        return convertFakeStoreProductDtoListToProductList(fakeStoreProductDtoList);
    }
    private Product convertFakeStoreProductDtoToProduct(FakeStoreProductDto fakeStoreProductDto){

        if (fakeStoreProductDto==null){
            return null;
        }

        Product product=new Product();
        product.setId(fakeStoreProductDto.getId());
        product.setTitle(fakeStoreProductDto.getTitle());
        product.setDescription(fakeStoreProductDto.getDescription());
        product.setPrice(fakeStoreProductDto.getPrice());

        Category category=new Category();
        category.setTitle(fakeStoreProductDto.getCategory());
        product.setCategory(category);
        return product;
    }

    private List<Product> convertFakeStoreProductDtoListToProductList(FakeStoreProductDto[] fakeStoreProductDtoList){
        if (fakeStoreProductDtoList==null){
            return null;
        }
        List<Product> productList=new ArrayList<>();
        for (FakeStoreProductDto fakeStoreProductDto:fakeStoreProductDtoList){
            productList.add(convertFakeStoreProductDtoToProduct(fakeStoreProductDto));
        }
        return productList;
    }
}
