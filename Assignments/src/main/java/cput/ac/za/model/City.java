package cput.ac.za.domain.admin;


import java.util.Objects;

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

        public Builder cityName(String cityName){
            this.cityName = cityName;
            return this;
        }

        public Builder copy(City city){
            this.cityName = city.cityName;
            return this;
        }

        public City build() {
            return new City(this);
        }


    }

    @Override
    public String toString() {
        return "City Name :" + cityName;
    }

}

