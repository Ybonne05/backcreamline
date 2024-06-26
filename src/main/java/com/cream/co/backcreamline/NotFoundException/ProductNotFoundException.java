package com.cream.co.backcreamline.NotFoundException;



public class ProductNotFoundException extends RuntimeException {
    public ProductNotFoundException(Long id){
        super("Could not found product with" + id);
    }
}
