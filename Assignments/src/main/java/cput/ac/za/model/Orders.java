package cput.ac.za.model;


public class Orders {

    private int orderNum;

    private Orders(){}

    private Orders(Builder builder){
        this.orderNum = builder.orderNum;

    }

    public int getOrderNum() {
        return orderNum;
    }

    public static class Builder{

        private int orderNum;

        public Builder Orders(int orderNum){
            this.orderNum = orderNum;
            return this;
        }

        public Orders build() {
            return new Orders(this);
        }

        @Override
        public String toString() {
            return "Order :" + orderNum;
        }




    }
}
