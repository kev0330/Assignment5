package cput.ac.za.model;


public class Storage {

    private int storageNum;

    private Storage(){}

    private Storage(Builder builder){
        this.storageNum = builder.storageNum;

    }

    public int getStorageNum() {
        return storageNum;
    }

    public static class Builder{

        private int storageNum;

        public Builder Storage(int storageNum){
            this.storageNum = storageNum;
            return this;
        }

        public Storage build() {
            return new Storage(this);
        }

        @Override
        public String toString() {
            return "Storage :" + storageNum;
        }




    }
}