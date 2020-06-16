package nl.vanrsmln.wilkin.hci2020.models.orders;

import nl.vanrsmln.wilkin.hci2020.Constants;

import java.util.List;

public class FoodRepository {

    private List<FoodOrder> previousOrders;

    private static FoodRepository instance = new FoodRepository();

    public static FoodRepository getInstance() {
        return instance;
    }

    private FoodRepository() {
        this.previousOrders = Constants.PREVIOUS_ORDERS;
    }
}
