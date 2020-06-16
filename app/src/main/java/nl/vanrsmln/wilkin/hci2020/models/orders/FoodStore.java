package nl.vanrsmln.wilkin.hci2020.models.orders;

import nl.vanrsmln.wilkin.hci2020.models.buildings.Building;

import java.util.List;

public class FoodStore {
    private String name;
    private Building location;
    private int imgId;
    private List<FoodItem> menu;

    public FoodStore(String name, Building location, int imgId, List<FoodItem> menu) {
        this.name = name;
        this.location = location;
        this.imgId = imgId;
        this.menu = menu;
    }

    public String getName() {
        return name;
    }

    public Building getLocation() {
        return location;
    }

    public int getImgId() {
        return imgId;
    }

    public List<FoodItem> getMenu() {
        return menu;
    }

    public String getOpeningHours() {
        return "09:00 - 20:00";
    }
}
