package com.cream.co.backcreamline.NotFoundException;

public class OrderNotFoundException extends RuntimeException {
    public OrderNotFoundException(Long orderId) {
        super("Could not Found an Order with " + orderId);
    }

}
