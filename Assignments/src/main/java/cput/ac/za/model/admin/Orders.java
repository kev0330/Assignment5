package cput.ac.za.domain.admin;


public class Orders {

    private String orderNum;

    private Orders(){}

    private Orders(Builder builder){
        this.orderNum = builder.orderNum;

    }

    public String getOrderNum() {
        return orderNum;
    }

    public static class Builder{

        private String orderNum;

        public Builder Orders(String orderNum){
            this.orderNum = orderNum;
            return this;
        }

        public Orders.Builder copy(Orders orders){
            this.orderNum = orders.orderNum;
            return this;
        }

        public Orders build() {
            return new Orders(this);
        }





    }
    @Override
    public String toString() {
        return "Order :" + orderNum;
    }

}
