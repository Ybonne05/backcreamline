package com.cream.co.backcreamline.NotFoundException;

public class OrderItemNotFoundException extends RuntimeException {
    public OrderItemNotFoundException(Long orderItemId) {
        super("Could not found an Order Item with " + orderItemId);
    }

}
