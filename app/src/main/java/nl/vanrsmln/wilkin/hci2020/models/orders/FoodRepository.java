package nl.vanrsmln.wilkin.hci2020.models.orders;

import nl.vanrsmln.wilkin.hci2020.Constants;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class FoodRepository {

    private List<FoodOrder> previousOrders;

    private static FoodRepository instance = new FoodRepository();

    public static FoodRepository getInstance() {
        return instance;
    }

    private FoodRepository() {
        this.previousOrders = new ArrayList<>(Constants.PREVIOUS_ORDERS);
    }

    public List<FoodOrder> getPreviousOrders() {
        return previousOrders;
    }

    public void placeOrder(FoodOrder order) {
        previousOrders.add(order);
    }
}
