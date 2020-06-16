package nl.vanrsmln.wilkin.hci2020.models.orders;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class FoodOrder {
    private Date date;
    private List<FoodItem> items;
    private int totalPrice = 0;

    FoodOrder(List<FoodItem> items) {
        this.items = items;

        for(FoodItem item : items) {
            this.totalPrice += item.getPrice();
        }

        this.date = Calendar.getInstance().getTime();
    }

    FoodOrder(List<FoodItem> items, String dateString) {
        this.items = items;

        for(FoodItem item : items) {
            this.totalPrice += item.getPrice();
        }

        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'");
        try {
            date = format.parse(dateString);
            System.out.println(date);
        } catch (ParseException e) {
            e.printStackTrace();
            date = Calendar.getInstance().getTime();
        }
    }
}
