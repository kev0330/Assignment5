package cput.ac.za.domain.admin;


public class Town {

    private String townName;
    
    private Town(){}

    private Town(Builder builder){
        this.townName = builder.townName;
        
    }

    public String getTownName() {
        return townName;
    }

    public static class Builder{

        private String townName;

        public Builder townName(String townName){
            this.townName = townName;
            return this;
        }

        public Town.Builder copy(Town town){
            this.townName = town.townName;
            return this;
        }

        public Town build() {
            return new Town(this);
        }






    }

    @Override
    public String toString() {
        return "Town Name :" + townName;
    }
}
