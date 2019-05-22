package cput.ac.za.services.admin.impl;

import cput.ac.za.domain.admin.Orders;
import cput.ac.za.repository.admin.OrdersRepository;
import cput.ac.za.repository.admin.impl.OrdersRepImpl;
import cput.ac.za.services.admin.OrdersService;

import java.util.Set;

public class OrdersServiceImpl implements OrdersService {

    private static OrdersServiceImpl service = null;
    private OrdersRepository repository;

    private OrdersServiceImpl() {
        this.repository = OrdersRepImpl.getRepository();
    }

    public static OrdersServiceImpl getService(){
        if (service == null) service = new OrdersServiceImpl();
        return service;
    }

    @Override
    public Orders create(Orders order) {
        return this.repository.create(order);
    }

    @Override
    public Orders update(Orders order) {
        return this.repository.update(order);
    }

    @Override
    public void delete(String s) {
        this.repository.delete(s);
    }

    @Override
    public Orders read(String s) {
        return this.repository.read(s);
    }

    @Override
    public Set<Orders> getAll() {
        return this.repository.getAll();
    }
}
