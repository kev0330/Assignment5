package cput.ac.za.model;


public class City {

    private String cityName;

    private City(){}

    private City(Builder builder){
        this.cityName = builder.cityName;

    }

    public String getCityName() {
        return cityName;
    }

    public static class Builder{

        private String cityName;

        public Builder marketID(String cityName){
            this.cityName = cityName;
            return this;
        }

        public Market build() {
            return new Market(this);
        }

        @Override
        public String toString() {
            return "City Name :" + cityName;
        }




    }
}
