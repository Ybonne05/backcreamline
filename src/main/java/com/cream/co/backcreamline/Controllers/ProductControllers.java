package com.cream.co.backcreamline.Controllers;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cream.co.backcreamline.Model.Product;
import com.cream.co.backcreamline.NotFoundException.ProductNotFoundException;
import com.cream.co.backcreamline.Repository.ProductRepository;




@RestController
@RequestMapping("/api/v1/product")
public class ProductControllers {

    ProductRepository repo;

    public ProductControllers(ProductRepository repo) {
        this.repo = repo;
    }

    //http://127.0.0.1:8080/products
    @GetMapping("/all")
    public List<Product> getProducts(){
        return repo.findAll();
    }

    //http://127.0.0.1:8080/product/2
    @GetMapping("/{id}")
    public Product getProduct(@PathVariable Long id){
        return repo.findById(id)
        .orElseThrow(()-> new ProductNotFoundException(id));
    
    }


    // public Product geProduct(Long id){
    //     return repo.findById(id);
    // }

    //http://127.0.0.1:8080/product/new
    @PostMapping("/new")
    public String addProduct(@RequestBody Product newProdcut){
        repo.save(newProdcut);
        return "A new product is added. YEY!";
    }
    
    //http://127.0.0.1:8080/product/edit/2
    @PutMapping("/edit/{id}")
    public Product updateProduct(@PathVariable Long id, @RequestBody Product newProduct){
        return repo.findById(id)
        .map(product -> {
            product.setProductName(newProduct.getProductName());
            product.setDescription(newProduct.getDescription());
            product.setPrice(newProduct.getPrice());
            return repo.save(product);
        }).orElseGet(()->{
            return repo.save(newProduct);
        });
    }

    //http://127.0.0.1:8080/product/delete/1
    @DeleteMapping("/delete/{id}")
    public String deleteProduct(@PathVariable Long id){
        repo.deleteById(id);
        return "A product has been deleted!";
    }


}
