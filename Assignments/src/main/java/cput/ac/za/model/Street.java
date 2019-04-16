package cput.ac.za.model;


public class Street {

    private int streetNum;

    private Street(){}

    private Street(Builder builder){
        this.streetNum = builder.streetNum;

    }

    public int getStreetNum() {
        return streetNum;
    }

    public static class Builder{

        private int streetNum;

        public Builder streetNum(int streetNum){
            this.streetNum = streetNum;
            return this;
        }

        public Street build() {
            return new Street(this);
        }

        @Override
        public String toString() {
            return "Street Number :" + streetNum;
        }




    }
}
