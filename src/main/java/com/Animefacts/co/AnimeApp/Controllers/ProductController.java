package com.Animefacts.co.AnimeApp.Controllers;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.Animefacts.co.AnimeApp.Model.Product;
import com.Animefacts.co.AnimeApp.Repository.ProductRepository;

@RestController
public class ProductController {

    ProductRepository repo;

    public ProductController(ProductRepository repo) {
        this.repo = repo;
    }

    //http://127.0.0.1/products
    //Get all Products
    @GetMapping("/products")
    public List<Product> getProducts(){
        return repo.findAll();
    }

    /*public Product getProduct(Long id){
        return repo.findById(id);
    }*/


//http:127.0.0.1:8080/product/new
@PostMapping("/product/new")
    public String addProduct(@RequestBody Product newProduct){
        repo.save(newProduct);
        return "A new Product is Added. mwehehehehe!";

    }

}
