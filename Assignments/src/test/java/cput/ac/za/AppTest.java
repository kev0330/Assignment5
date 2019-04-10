package cput.ac.za;

import static org.junit.Assert.assertTrue;

import cput.ac.za.factory.MarketFactory;
import cput.ac.za.model.Market;
import org.junit.Assert;
import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    /**
     * Rigorous Test :-)
     */
    @Test
    public void getMarketID()
    {
        String name = "ABC";
        Market c = MarketFactory.getMarket(name);
        System.out.println(c);
        Assert.assertNotNull(c.getMarketID());
    }

}
