package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ShopTest {
    private final Shop shop = new Shop();

    @Test
    public void UpdateTest_DESC_SellIn_Simple()
    {
        Product product = new Product("s","name",10,10);

        shop.Update(product);

        Assertions.assertEquals(9, product.sellIn);
    }

    @Test
    public void UpdateTest_DESC_SellIn_0()
    {
        Product product = new Product("s","name",0,10);

        shop.Update(product);

        Assertions.assertEquals(0, product.sellIn);
    }

    @Test
    public void UpdateTest_DESC_Quality_Simple_Product()
    {
        Product product = new Product("s","name",10,10);

        shop.Update(product);

        Assertions.assertEquals(9, product.quality);
    }

    @Test
    public void UpdateTest_DESC_Quality_Simple_Product_SellIn_0()
    {
        Product product = new Product("s","name",0,10);

        shop.Update(product);

        Assertions.assertEquals(8, product.quality);
    }

    @Test
    public void UpdateTest_DESC_Quality_La_Product_Not_Brie()
    {
        Product product = new Product("l","name",10,10);

        shop.Update(product);

        Assertions.assertEquals(8, product.quality);
    }

    @Test
    public void UpdateTest_DESC_Quality_La_Product_Not_Brie_SellIn_0()
    {
        Product product = new Product("l","name",0,10);

        shop.Update(product);

        Assertions.assertEquals(6, product.quality);
    }
        @Test
    public void UpdateTest_DESC_Quality_0_Not_Brie()
    {
        Product product = new Product("s","name",10,-1);

        shop.Update(product);

        Assertions.assertEquals(0, product.quality);
    }

    @Test
    public void UpdateTest_ASC_Quality_50()
    {
        Product product = new Product("s","name",10,51);


        shop.Update(product);

        Assertions.assertEquals(50, product.quality);
    }

    @Test
    public void UpdateTest_Quality_Brie()
    {

        Product product = new Product("l","Brie",10,10);

        shop.Update(product);

        Assertions.assertEquals(11, product.quality);
    }
}
