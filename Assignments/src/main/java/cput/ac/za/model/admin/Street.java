package cput.ac.za.domain.admin;


public class Street {

    private String streetNum;

    private Street(){}

    private Street(Builder builder){
        this.streetNum = builder.streetNum;

    }

    public String getStreetNum() {
        return streetNum;
    }

    public static class Builder{

        private String streetNum;

        public Builder streetNum(String streetNum){
            this.streetNum = streetNum;
            return this;
        }

        public Street.Builder copy(Street street){
            this.streetNum = street.streetNum;
            return this;
        }

        public Street build() {
            return new Street(this);
        }






    }

    @Override
    public String toString() {
        return "Street Number :" + streetNum;
    }
}
