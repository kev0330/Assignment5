package cput.ac.za.factory;

import cput.ac.za.model.Item;


public class ItemFactory {
    
     public static Item getItemNum(String itemNum) {
        return new Item.Builder().itemNum(itemNum)
                .build();
    }


}
    