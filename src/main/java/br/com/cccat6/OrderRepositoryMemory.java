package br.com.cccat6;

import java.util.ArrayList;
import java.util.List;

public class OrderRepositoryMemory implements OrderRepository {

    List<Order> orders;

    public OrderRepositoryMemory(){
        this.orders = new ArrayList<>();
    }

    @Override
    public void save(Order order) {
        this.orders.add(order);
    }
}
