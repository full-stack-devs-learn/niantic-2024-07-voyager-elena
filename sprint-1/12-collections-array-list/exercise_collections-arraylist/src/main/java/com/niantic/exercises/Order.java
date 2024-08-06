package com.niantic.exercises;

import com.niantic.models.OrderLineItem;

import java.util.ArrayList;


/*
The exercises in this class are optional - this is the challenge exercise
 */
public class Order {
    // this ArrayList is the container (shopping cart) for all items that are being ordered
    private ArrayList<OrderLineItem> shoppingCart = new ArrayList<>();

    public ArrayList<OrderLineItem> getShoppingCart() {
        return shoppingCart;
    }

    /*
    1. Add logic to allow a user to add an Item to a shopping cart
        - if the item already exists in the cart, update the quantity
        - search for a line item by name, and add the new quantity to the original quantity
     */
    public void addItem(OrderLineItem item) {
        // check if this item already exists
        for (int i = 0; i < shoppingCart.size(); i++) {
            OrderLineItem line = shoppingCart.get(i);
            if (line.getProduct().equals(item.getProduct())) {
                // update line
                line.setQuantity(line.getQuantity() + item.getQuantity());
                shoppingCart.set(i, line);
                return;
            }
        }

        // if we reached this line tat means there is now such product in the shopping card
        // and we need just add it
        shoppingCart.add(item);
    }

    /*
    2. Add logic to allow a user to add an Item to a shopping cart
        - search for a line item by name, and remove it from the list
     */
    public void removeItem(OrderLineItem item) {
        // do we really need to search?

        shoppingCart.remove(item);
    }

    /*
    3. Search for the highest priced item in the shopping cart and return the
        line item that contains that item.

        If the shopping cart is empty return null
     */
    public OrderLineItem findHighestPriceProduct() {
        double highestPrice = -1;
        OrderLineItem itemWithTheHighestPrice = null;

        for (var item : shoppingCart) {
            if(item.getPrice() > highestPrice) {
                highestPrice = item.getPrice();
                itemWithTheHighestPrice = item;
            }
        }

        return itemWithTheHighestPrice;
    }

    /*
    4. Search for the most expensive line item in the shopping cart
        and return it

        If the shopping cart is empty return null
     */
    public OrderLineItem findMostExpensiveLineItem() {
        double highestLineTotal = -1;
        OrderLineItem mostExpensiveLine = null;

        for (var item : shoppingCart) {
            double lineTotal = item.getLineTotal();
            if(lineTotal > highestLineTotal) {
                highestLineTotal = lineTotal;
                mostExpensiveLine = item;
            }
        }

        return mostExpensiveLine;
    }

    /*
    5. Calculate and return the order total
     */
    public double getOrderTotal() {
        double orderTotal = 0;

        for (var item : shoppingCart) {
            orderTotal += item.getLineTotal();
        }

        return orderTotal;
    }

    /*
    6. Return the total number of items in the cart
     */
    public int getTotalItemCount() {
        int totalItemCount = 0;

        for (var item : shoppingCart) {
            totalItemCount += item.getQuantity();
        }

        return totalItemCount;
    }

    /*
    7. Calculate the average price for all items in the shopping cart
     */
    public double getAveragePricePerItem() {
        return getOrderTotal() / getTotalItemCount();
    }
}
