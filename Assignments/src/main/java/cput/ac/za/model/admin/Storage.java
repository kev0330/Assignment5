package cput.ac.za.domain.admin;


public class Storage {

    private String storageNum;

    private Storage(){}

    private Storage(Builder builder){
        this.storageNum = builder.storageNum;

    }

    public String getStorageNum() {
        return storageNum;
    }

    public static class Builder{

        private String storageNum;

        public Builder Storage(String storageNum){
            this.storageNum = storageNum;
            return this;
        }

        public Storage.Builder copy(Storage storage){
            this.storageNum = storage.storageNum;
            return this;
        }

        public Storage build() {
            return new Storage(this);
        }





    }
    @Override
    public String toString() {
        return "Storage :" + storageNum;
    }

}