package cput.ac.za.factory;

import cput.ac.za.model.Orders;


public class OrdersFactory {
    
    
        public static Orders getOrderNum(int orderNum) {
        return new Orders.Builder().orderNum(orderNum)
                .build();
    }


}  