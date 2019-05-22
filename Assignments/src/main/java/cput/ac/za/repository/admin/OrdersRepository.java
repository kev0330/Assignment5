package cput.ac.za.repository.admin;

import cput.ac.za.domain.admin.Orders;
import cput.ac.za.repository.IRepository;

import java.util.Set;

public interface OrdersRepository  extends IRepository<Orders, String> {
    Set<Orders> getAll();
}
