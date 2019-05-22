package cput.ac.za.factory.admin;

import cput.ac.za.domain.admin.Item;


public class ItemFactory {
    
     public static Item getItemNum(String itemNum) {
        return new Item.Builder().Item(itemNum)
                .build();
    }


}
    