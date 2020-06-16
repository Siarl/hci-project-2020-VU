package nl.vanrsmln.wilkin.hci2020.models.orders;

public class FoodItem {
    private String name;
    private String description;
    private int price; // in cents

    public FoodItem(String name, String description, int price) {
        this.name = name;
        this.description = description;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public int getPrice() {
        return price;
    }
}
