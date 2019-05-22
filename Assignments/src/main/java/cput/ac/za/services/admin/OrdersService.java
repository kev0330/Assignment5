package cput.ac.za.services.admin;

import cput.ac.za.domain.admin.Orders;
import cput.ac.za.services.IService;

import java.util.Set;

public interface OrdersService extends IService<Orders, String> {
    Set<Orders> getAll();
}
