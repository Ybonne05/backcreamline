package com.cream.co.backcreamline.Controllers;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cream.co.backcreamline.Model.Product;
import com.cream.co.backcreamline.Repository.ProductRepository;




@RestController
public class ProductControllers {

    ProductRepository repo;

    public ProductControllers(ProductRepository repo) {
        this.repo = repo;
    }

    @GetMapping("/products")
    public List<Product> getProducts(){
        return repo.findAll();
    }

    // public Product geProduct(Long id){
    //     return repo.findById(id);
    // }

    //http://127.0.0.1:8080/product/new
    @PostMapping("/product/new")
    public String addProduct(@RequestBody Product newProdcut){
        repo.save(newProdcut);
        return "A new product is added. YEY!";
    }
}
