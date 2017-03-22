package com.test.shopping;

/**
 * Enum represents shopping item and price.
 *
 * @since 22/03/2017.
 */
public enum Item {

    BANANA(0.25),ORANGE(0.15),APPLE(.50),LEMON(.10),PEACH(.35);

    private final double price;

    Item(double price) {
        this.price = price;
    }

    public double getPrice() {
        return price;
    }
}
