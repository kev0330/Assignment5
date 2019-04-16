package cput.ac.za.model;


public class Item {

    private int itemNum;

    private Item(){}

    private Item(Builder builder){
        this.itemNum = builder.itemNum;

    }

    public int getItemNum() {
        return itemNum;
    }

    public static class Builder{

        private int itemNum;

        public Builder Item(int itemNum){
            this.itemNum = itemNum;
            return this;
        }

        public Item build() {
            return new Item(this);
        }

        @Override
        public String toString() {
            return "Item :" + itemNum;
        }




    }
}