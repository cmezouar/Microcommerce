package com.ecommerce.microcommerce.web.controller;
import com.ecommerce.microcommerce.model.Product;
import com.ecommerce.microcommerce.dao.ProductDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.RequestEntity;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
public class ProductController {

    /*@Autowired annotates a var of type ProductDao so that Spring creates an instance
    of it. ProductDao has now access to all the methods of the controller */
    @Autowired
    private ProductDao productDao;

    //Get all the products
    @RequestMapping(value="/Products", method = RequestMethod.GET)
    public List<Product> listOfProducts(){
        return productDao.findAll();
    }

    //Get a product by id
    @GetMapping(value="/Products/{id}")
    public Product displayAProduct(@PathVariable int id){
        return productDao.findById(id);
    }

    //Add a product
    @PostMapping(value="/Products")
    //the type ResponseEntity allows to define the HTTP code to return
    public ResponseEntity<Void> addAProduct(@RequestBody Product product){
        Product productAdded = productDao.save(product);

        //if the product added is empty or does not exist, we return code 204 (No Content)
        //build() is used to build the header and add the chosen code to it
        if(productAdded == null){
            return ResponseEntity.noContent().build();
        }

        /*If the product added is valid we need the code 201( Created)
        and to add the URI for the newly created resource, in order to be conform to HTTP code */
        URI location = ServletUriComponentsBuilder //here we create a new instance of URI
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(productAdded.getId())//adds the id of the product to the URI
                .toUri();

        return ResponseEntity.created(location).build();
        /*created() takes the URI of the new resource as argument and
        sends the status code 201*/
    }
}
