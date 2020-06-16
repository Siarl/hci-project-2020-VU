package nl.vanrsmln.wilkin.hci2020.models.orders;

import com.kofigyan.stateprogressbar.StateProgressBar;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class FoodOrder {

    public enum Status {
        PLACED("placed", StateProgressBar.StateNumber.ONE),
        IN_PROGRESS("in progress", StateProgressBar.StateNumber.TWO),
        READY("ready", StateProgressBar.StateNumber.THREE),
        FINISHED("finished", StateProgressBar.StateNumber.FOUR);

        private String name;
        private StateProgressBar.StateNumber stateNumber;

        Status(String name, StateProgressBar.StateNumber stateNumber) {
            this.name = name;
            this.stateNumber = stateNumber;
        }

        public String getName() {
            return name;
        }

        public StateProgressBar.StateNumber getStateNumber() {
            return stateNumber;
        }
    }

    private Date date;
    private FoodStore location;
    private List<FoodItem> items;
    private int totalPrice = 0;
    private Status status;

    public FoodOrder(List<FoodItem> items, FoodStore location) {
        this.items = items;
        this.location = location;

        for(FoodItem item : items) {
            this.totalPrice += item.getPrice();
        }

        this.date = Calendar.getInstance().getTime();
        this.status = Status.PLACED;
    }

    public FoodOrder(List<FoodItem> items, FoodStore location, String dateString, Status status) {
        this.items = items;
        this.location = location;
        this.status = status;

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

    public Date getDate() {
        return date;
    }

    public FoodStore getLocation() {
        return location;
    }

    public List<FoodItem> getItems() {
        return items;
    }

    public int getTotalPrice() {
        return totalPrice;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}
