package com.test.shopping;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * @since 22/03/2017.
 */
public class Basket {
    private static final Logger logger = LoggerFactory.getLogger(Basket.class);

    private final String basketId;

    private final Map<Item, Integer> items = new HashMap<>();


    public Basket() {
        this.basketId = "Basket_" + System.nanoTime();
    }

    public void addItem(Item item, int quantity) {
        if (quantity <= 0) {
            throw new IllegalArgumentException("Invalid quantity");
        }
        int itemCount = quantity;

        if (items.containsKey(item)) {
            itemCount = itemCount + items.get(item);
        }

        items.put(item, itemCount);
    }

    public void removeItem(Item item, int quantity) {
        if (quantity <= 0) {
            throw new IllegalArgumentException("Invalid quantity");
        }
        if (items.containsKey(item)) {
            int itemCount = items.get(item);

            if (itemCount < quantity) {
                throw new IllegalArgumentException("Invalid quantity");
            }

            itemCount = itemCount - quantity;

            if (itemCount == 0) {
                items.remove(item);
            } else {
                items.put(item, itemCount);
            }

        }

    }

    public double getPrice() {
        double totalPrice = 0d;
        for (Map.Entry<Item, Integer> basketEntry : items.entrySet()) {
            totalPrice = totalPrice + basketEntry.getValue() * basketEntry.getKey().getPrice();
        }
        return totalPrice;
    }

    public Map<Item, Integer> getItems() {
        return Collections.unmodifiableMap(items);
    }

    public void printItems() {
        for (Map.Entry<Item, Integer> basketEntry : items.entrySet()) {
            logger.info(basketEntry.getKey().name() + "[@" + basketEntry.getKey().getPrice() + "] X " + basketEntry.getValue());
        }
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Basket)) return false;

        Basket basket = (Basket) o;

        return basketId.equals(basket.basketId);
    }

    @Override
    public int hashCode() {
        return basketId.hashCode();
    }
}
