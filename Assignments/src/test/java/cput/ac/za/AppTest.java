package cput.ac.za;

import static org.junit.Assert.assertTrue;

import cput.ac.za.factory.*;
import cput.ac.za.model.*;
import org.junit.Assert;
import org.junit.Test;

public class AppTest 
{

    @Test
    public void getMarket()
    {
        int number = 123;
        Market x = MarketFactory.getMarketNum(number);
        System.out.println(x);
        Assert.assertNotNull(x.getMarketNum());
    }
    
    @Test
    public void getCity(){
        String city = "ABC";
        City x = CityFactory.getCityName(city);
        System.out.println(x);
        Assert.assertNotNull(x.getCityName());
    }
    
    @Test
    public void getCustomer(){
        int number = 123;
        Customer x = CustomerFactory.getCustomerID(number);
        System.out.println(x);
        Assert.assertNotNull(x.getCustomerID());
    }
    
    @Test
    public void getEmployee(){
        int number = 123;
        Employee x = EmployeeFactory.getEmployeeID(number);
        System.out.println(x);
        Assert.assertNotNull(x.getEmployeeID());
    }
    
    @Test
    public void getItem(){
        int number = 123;
        Item x = CityFactory.getItemNum(number);
        System.out.println(x);
        Assert.assertNotNull(x.getItemNum());
    }
    
    @Test
    public void getMarketOwner(){
        int number = 123;
        MarketOwner x = CityFactory.getMarketOwnerID(number);
        System.out.println(x);
        Assert.assertNotNull(x.getMarketOwnerID());
    }
    
    @Test
    public void getOrders(){
        int number = 123;
        Orders x = CityFactory.getOrderNum(number);
        System.out.println(x);
        Assert.assertNotNull(x.getOrderNum());
    }
    
    @Test
    public void getStock(){
        int number = 123;
        Stock x = CityFactory.getStockNum(number);
        System.out.println(x);
        Assert.assertNotNull(x.getStockNum());
    }
    
    @Test
    public void getStorage(){
        int number = 123;
        Storage x = CityFactory.getStorageNum(number);
        System.out.println(x);
        Assert.assertNotNull(x.getStorageNum());
    }
    
    @Test
    public void getStore(){
        int number = 123;
        Store x = CityFactory.getStoreNum(number);
        System.out.println(x);
        Assert.assertNotNull(x.getStoreNum());
    }
    
    @Test
    public void getStoreOwner(){
        int number = 123;
        StoreOwner x = CityFactory.getStoreOwnerID(number);
        System.out.println(x);
        Assert.assertNotNull(x.getStoreOwnerID());
    }
    
    @Test
    public void Supplier(){
        int number = 123;
        Supplier x = CityFactory.getSupplierID(number);
        System.out.println(x);
        Assert.assertNotNull(x.getSupplierID());
    }
    
    @Test
    public void Street(){
        int number = 123;
        Street x = CityFactory.getStreetNum(number);
        System.out.println(x);
        Assert.assertNotNull(x.getStreetNum());
    }
    
    @Test
    public void Town(){
        String town = "ABC";
        Town x = CityFactory.getTownName(number);
        System.out.println(x);
        Assert.assertNotNull(x.getTownName());
    }
    
    
}
