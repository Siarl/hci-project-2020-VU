package nl.vanrsmln.wilkin.hci2020.models.orders;

import nl.vanrsmln.wilkin.hci2020.models.buildings.Building;

import java.util.List;

public class FoodStore {
    private String name;
    private Building location;
    private String picUrl;
    private List<FoodItem> menu;

    public FoodStore(String name, Building location, String picUrl, List<FoodItem> menu) {
        this.name = name;
        this.location = location;
        this.picUrl = picUrl;
        this.menu = menu;
    }

    public String getName() {
        return name;
    }

    public Building getLocation() {
        return location;
    }

    public String getPicUrl() {
        return picUrl;
    }

    public List<FoodItem> getMenu() {
        return menu;
    }
}
