package cput.ac.za.domain.admin;


public class Item {

    private String itemNum;

    private Item(){}

    private Item(Builder builder){
        this.itemNum = builder.itemNum;

    }

    public String getItemNum() {
        return itemNum;
    }

    public static class Builder{

        private String itemNum;

        public Builder Item(String itemNum){
            this.itemNum = itemNum;
            return this;
        }

        public Item.Builder copy(Item item){
            this.itemNum = item.itemNum;
            return this;
        }

        public Item build() {
            return new Item(this);
        }

    }

    @Override
    public String toString() {
        return "Item :" + itemNum;
    }
}