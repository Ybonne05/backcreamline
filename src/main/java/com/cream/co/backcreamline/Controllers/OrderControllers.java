package com.cream.co.backcreamline.Controllers;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cream.co.backcreamline.Model.Order;
import com.cream.co.backcreamline.NotFoundException.OrderNotFoundException;
import com.cream.co.backcreamline.Repository.OrderRepository;

@RestController
public class OrderControllers {

    OrderRepository repo;

    public OrderControllers(OrderRepository repo) {
        this.repo = repo;
    }

    @GetMapping("/Orders")
    public List<Order> getOrders(){
        return repo.findAll();
    }

    @GetMapping("/Order/{id}")
    public Order getOrder(@PathVariable Long id) {
        return repo.findById(id)
        .orElseThrow(()-> new OrderNotFoundException(id));
    }

    @PostMapping("/Order/new")
    public String addOrder(@RequestBody Order newOrder) {
        repo.save(newOrder);
        return "A new order has been added!";
    }



    @DeleteMapping("/Order/delete/{id}")
    public String deleteOrder(@PathVariable Long id) {
        repo.deleteById(id);
        return "An Order has been deleted!";
    }

}
