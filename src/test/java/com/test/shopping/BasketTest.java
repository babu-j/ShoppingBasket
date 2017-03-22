package com.test.shopping;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @since  22/03/2017.
 */
public class BasketTest {

    @Test
    public void testEmptyBasket(){
        Basket basket = new Basket();
        assertNotNull(basket);
       assertEquals(0,basket.getItems().size());
    }
    @Test
    public void test_addItem(){
        Basket basket = new Basket();
        basket.addItem(Item.APPLE,1);
        assertFalse(basket.getItems().isEmpty());
    }

    @Test(expected = IllegalArgumentException.class)
    public void test_addItem_with_invalid_qty(){
        Basket basket = new Basket();
        basket.addItem(Item.APPLE,0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void test_removeItem_with_invalid_qty(){
        Basket basket = new Basket();
        basket.addItem(Item.APPLE,1);
        basket.removeItem(Item.APPLE,0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void test_removeItem_if_qty_greater_than_num_of_tems_in_basket(){
        Basket basket = new Basket();
        basket.addItem(Item.APPLE,1);
        assertFalse(basket.getItems().isEmpty());
        basket.removeItem(Item.APPLE,2);

    }

    @Test
    public void test_removeItem(){
        Basket basket = new Basket();
        basket.addItem(Item.APPLE,1);
        assertFalse(basket.getItems().isEmpty());
        basket.removeItem(Item.APPLE,1);
        assertTrue(basket.getItems().isEmpty());
    }

    @Test
    public void test_getTotalPrice(){
        Basket basket = new Basket();
        basket.addItem(Item.APPLE,5); //2.50
        basket.addItem(Item.BANANA,2); //.50

        basket.addItem(Item.PEACH,3); //1.05
        basket.addItem(Item.ORANGE,2); // .30
        basket.addItem(Item.LEMON,4); //.40

        assertEquals(4.75,basket.getPrice(),0.00001d);


    }
}