package cput.ac.za.factory.admin;

import cput.ac.za.domain.admin.Orders;


public class OrdersFactory {
    
    
        public static Orders getOrderNum(String orderNum) {
        return new Orders.Builder().Orders(orderNum)
                .build();
    }


}  