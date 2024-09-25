package org.example;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

public class Shop {
    public Shop() {
    }
    public void Update(Product product)
    {
        if(product.quality <= 0)
        {
            product.quality = 0;
        }
        else if(product.quality >= 50)
        {
            product.quality = 50;
        }
        else
        {
            if (product.type.equals("l") )
            {
                if(product.name.equals("Brie") )
                {
                    product.quality++;
                }else
                {
                    if (product.sellIn == 0)
                        product.quality -= 4;
                    else
                        product.quality -= 2;
                }

            }
            else
            {
                if (product.sellIn == 0)
                    product.quality -= 2;
                else
                    product.quality -= 1;
            }
        }

        if(product.sellIn > 0)
        {
            product.sellIn--;
        }
    }
}
