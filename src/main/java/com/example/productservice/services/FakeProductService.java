package com.example.productservice.services;

import com.example.productservice.configs.RedisConfig;
import com.example.productservice.dtos.FakeStoreProductDto;
import com.example.productservice.exceptions.ProductNotFoundException;
import com.example.productservice.models.Category;
import com.example.productservice.models.Product;
import org.springframework.context.annotation.Primary;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RequestCallback;
import org.springframework.web.client.ResponseExtractor;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
@Primary
public class FakeProductService implements ProductService {

    RestTemplate restTemplate;
    RedisTemplate<String, Object> redisTemplate;

    public FakeProductService(RestTemplate restTemplate,
                              RedisTemplate redisTemplate){

        this.restTemplate = restTemplate;
        this.redisTemplate = redisTemplate;
    }
    @Override
    public Product getProductByID(Long id) throws  ProductNotFoundException {
        Product product=(Product) redisTemplate.opsForHash().get("PRODUCTS","PRODUCT_"+id);
        if (product!=null){
            System.out.println(product.getPrice());
            return product;
        }

        FakeStoreProductDto fakeStoreProductDto=restTemplate.getForObject("https://fakestoreapi.com/products/"+id,
                FakeStoreProductDto.class);
        if (fakeStoreProductDto==null){
            throw new ProductNotFoundException(1000,"Product not found"+id);
        }
        product= convertFakeStoreProductDtoToProduct(fakeStoreProductDto);
        redisTemplate.opsForHash().put("PRODUCTS","PRODUCT_"+id,product);
        return product;
    }

    public List<Product> getAllProducts(){
        FakeStoreProductDto[] fakeStoreProductDtoList=
                restTemplate.getForObject("https://fakestoreapi.com/products", FakeStoreProductDto[].class);

        return convertFakeStoreProductDtoListToProductList(fakeStoreProductDtoList);
    }

    @Override
    public Product replaceProduct(Long id, Product product){
        FakeStoreProductDto fakeStoreProductDto= new FakeStoreProductDto();
        fakeStoreProductDto.setId(product.getId());
        fakeStoreProductDto.setTitle(product.getTitle());
        fakeStoreProductDto.setDescription(product.getDescription());
        fakeStoreProductDto.setPrice(product.getPrice());

        RequestCallback requestCallback=restTemplate.httpEntityCallback(fakeStoreProductDto,FakeStoreProductDto.class);
        ResponseExtractor<ResponseEntity<FakeStoreProductDto>> responseExtractor=restTemplate.responseEntityExtractor(FakeStoreProductDto.class);
        FakeStoreProductDto fakeStoreProductDto1=restTemplate
                .execute("https://fakestoreapi.com/products/"+id, HttpMethod.PUT, requestCallback, responseExtractor)
                .getBody();
        return convertFakeStoreProductDtoToProduct(fakeStoreProductDto1);
    }

    public Product deleteProduct(Long id){

        ResponseExtractor<ResponseEntity<FakeStoreProductDto>> responseExtractor=restTemplate.responseEntityExtractor(FakeStoreProductDto.class);
        FakeStoreProductDto fakeStoreProductDto1=restTemplate
                .execute("https://fakestoreapi.com/products/"+id, HttpMethod.DELETE, null,responseExtractor)
                .getBody();
        return convertFakeStoreProductDtoToProduct(fakeStoreProductDto1);
    }

    @Override
    public Product createProduct(Product product) {
        return null;
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
