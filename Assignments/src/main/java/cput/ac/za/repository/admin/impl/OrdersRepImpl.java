package cput.ac.za.repository.admin.impl;


import cput.ac.za.domain.admin.Orders;
import cput.ac.za.repository.admin.OrdersRepository;

import java.util.HashSet;
import java.util.Set;

public class OrdersRepImpl implements OrdersRepository {
    private static OrdersRepImpl repository = null;
    private Set<Orders> orders;

    private OrdersRepImpl(){
        this.orders = new HashSet<>();
    }

    private Orders find(String order) {
        return this.orders.stream()
                .filter(orders -> orders.getOrderNum().equals(order))
                .findAny()
                .orElse(null);
    }

    public static OrdersRepImpl getRepository(){
        if(repository == null) repository = new OrdersRepImpl();
        return repository;
    }

    public Orders create(Orders order){
        this.orders.add(order);
        return order;
    }

    public Orders read(final String order){
        Orders orders = find(order);
        return orders;
    }

    public void delete(String orderNum) {
        Orders order = find(orderNum);
        if(order != null) this.orders.remove(order);
    }

    public Orders update(Orders orders) {
        Orders delete = find(orders.getOrderNum());
        if(delete != null){
            this.orders.remove(delete);
            return create(orders);
        }
        return orders;
    }

    public Set<Orders> getAll(){
        return this.orders;
    }
}
