package com.cream.co.backcreamline.Controllers;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cream.co.backcreamline.Model.OrderItem;
import com.cream.co.backcreamline.NotFoundException.OrderItemNotFoundException;
import com.cream.co.backcreamline.Repository.OrderItemRepository;


@RestController
public class OrderItemControllers {

    OrderItemRepository repo;

    public OrderItemControllers(OrderItemRepository repo) {
        this.repo = repo;
    }

    @GetMapping("/OrderItems")
    public List<OrderItem> getOrderItem(){
        return repo.findAll();
    }

    @GetMapping("/OrderItem/{id}")
    public OrderItem getOrderItem(@PathVariable Long id) {
        return repo.findById(id)
        .orElseThrow(()-> new OrderItemNotFoundException(id));
    }

    @PostMapping("/OrderItem/new")
    public String addOrderItem(@RequestBody OrderItem newOrderItem) {
        repo.save(newOrderItem);
        return "A new order item has been added!";
    }

    @DeleteMapping("/OrderItem/delete/{id}")
    public String deleteOrderItem(@PathVariable Long id) {
        repo.deleteById(id);
        return "An Order Item has been deleted!";
    }


}
