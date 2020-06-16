package nl.vanrsmln.wilkin.hci2020;

import nl.vanrsmln.wilkin.hci2020.models.buildings.Building;
import nl.vanrsmln.wilkin.hci2020.models.buildings.Room;
import nl.vanrsmln.wilkin.hci2020.models.buildings.Wing;
import nl.vanrsmln.wilkin.hci2020.models.orders.FoodItem;
import nl.vanrsmln.wilkin.hci2020.models.orders.FoodOrder;
import nl.vanrsmln.wilkin.hci2020.models.orders.FoodStore;
import nl.vanrsmln.wilkin.hci2020.models.repairs.RepairRequest;

import java.util.*;

public class Constants {

    public static final List<Building> CAMPUS_BUILDINGS;
    static {
        List<Building> temp = new ArrayList<>();

        List<Wing> wings1 = new ArrayList<>();

        List<Room> roomsA = new ArrayList<>();
        Room roomA1 = new Room("A-1"); roomsA.add(roomA1);
        Room roomA2 = new Room("A-2"); roomsA.add(roomA2);
        Room roomA3 = new Room("A-3"); roomsA.add(roomA3);
        Room roomA4 = new Room("A-4"); roomsA.add(roomA4);
        Room roomA5 = new Room("A-5"); roomsA.add(roomA5);
        Room roomA6 = new Room("A-6"); roomsA.add(roomA6);
        Room roomA7 = new Room("A-7"); roomsA.add(roomA7);
        Room roomA8 = new Room("A-8"); roomsA.add(roomA8);
        Room roomA9 = new Room("A-9"); roomsA.add(roomA9);
        Wing wingA = new Wing("Wing A", roomsA); wings1.add(wingA);

        List<Room> roomsB = new ArrayList<>();
        Room roomB1 = new Room("B-1"); roomsB.add(roomB1);
        Room roomB2 = new Room("B-2"); roomsB.add(roomB2);
        Room roomB3 = new Room("B-3"); roomsB.add(roomB3);
        Room roomB4 = new Room("B-4"); roomsB.add(roomB4);
        Room roomB5 = new Room("B-5"); roomsB.add(roomB5);
        Room roomB6 = new Room("B-6"); roomsB.add(roomB6);
        Room roomB7 = new Room("B-7"); roomsB.add(roomB7);
        Room roomB8 = new Room("B-8"); roomsB.add(roomB8);
        Room roomB9 = new Room("B-9"); roomsB.add(roomB9);
        Wing wingB = new Wing("Wing B", roomsB); wings1.add(wingB);

        Building b1 = new Building("HG", wings1); temp.add(b1);
        Building b2 = new Building("WN", wings1); temp.add(b2);
        Building b3 = new Building("MF", wings1); temp.add(b3);
        
        CAMPUS_BUILDINGS = Collections.unmodifiableList(temp);
    }

    public static final List<RepairRequest> PUBLIC_REPAIR_REQUESTS;
    static {
        List<RepairRequest> temp = new ArrayList<>();

        temp.add(new RepairRequest(
                CAMPUS_BUILDINGS.get(0),
                CAMPUS_BUILDINGS.get(0).wings.get(0),
                CAMPUS_BUILDINGS.get(0).wings.get(0).rooms.get(0),
                "Toilet doesn't flush :/",
                RepairRequest.Status.COMPLETED,
                "2020-5-15T09:27:37Z"
        ));

        temp.add(new RepairRequest(
                CAMPUS_BUILDINGS.get(1),
                CAMPUS_BUILDINGS.get(1).wings.get(1),
                CAMPUS_BUILDINGS.get(1).wings.get(1).rooms.get(0),
                "Looks like someone punched a hole in the wall.",
                RepairRequest.Status.COMPLETED,
                "2020-5-19T09:27:37Z"
        ));

        temp.add(new RepairRequest(
                CAMPUS_BUILDINGS.get(2),
                CAMPUS_BUILDINGS.get(2).wings.get(0),
                CAMPUS_BUILDINGS.get(2).wings.get(0).rooms.get(4),
                "Light is flickering",
                RepairRequest.Status.COMPLETED,
                "2020-5-23T09:27:37Z"
        ));

        temp.add(new RepairRequest(
                CAMPUS_BUILDINGS.get(0),
                CAMPUS_BUILDINGS.get(0).wings.get(0),
                CAMPUS_BUILDINGS.get(0).wings.get(0).rooms.get(7),
                "The radiator is broken",
                RepairRequest.Status.COMPLETED,
                "2020-6-1T09:27:37Z"
        ));

        temp.add(new RepairRequest(
                CAMPUS_BUILDINGS.get(1),
                CAMPUS_BUILDINGS.get(1).wings.get(0),
                CAMPUS_BUILDINGS.get(1).wings.get(0).rooms.get(3),
                "Hi, the toilet here does not flush.",
                RepairRequest.Status.IN_PROGRESS,
                "2020-6-6T09:27:37Z"
        ));

        temp.add(new RepairRequest(
                CAMPUS_BUILDINGS.get(0),
                CAMPUS_BUILDINGS.get(0).wings.get(1),
                CAMPUS_BUILDINGS.get(0).wings.get(1).rooms.get(4),
                "Toilet is clogged",
                RepairRequest.Status.IN_PROGRESS,
                "2020-6-12T09:27:37Z"
        ));

        Collections.sort(temp, (t1, t2) -> t2.date.compareTo(t1.date));

        PUBLIC_REPAIR_REQUESTS = Collections.unmodifiableList(temp);
    }

    public static final List<FoodStore> FOOD_STORES;
    static {
        List<FoodStore> temp = new ArrayList<>();

        List<FoodItem> menu = new ArrayList<>();
        menu.add(new FoodItem("Pepperoni Pizza", "Pizza with tomato sauce, mozzarella and pepperoni", 300));
        menu.add(new FoodItem("Cheese Pizza", "Pizza with tomato sauce, crème fraîche, mozzarella, Cheddar, Gouda and Gorgonzola", 300));
        menu.add(new FoodItem("Pizza Hawaii", "Pizza with tomato sauce, mozzarella, ham and pineapple", 300));
        menu.add(new FoodItem("Margherita Pizza", "Pizza with tomato sauce and mozzarella", 250));

        menu.add(new FoodItem("Smoothie Pineapple", "25cl", 200));
        menu.add(new FoodItem("Smoothie Banana", "25cl", 200));
        menu.add(new FoodItem("Coca Cola", "Can, 33cl", 100));
        menu.add(new FoodItem("Coca Cola Light", "Can, 33cl", 100));

        menu.add(new FoodItem("Fruit salad", "", 125));

        temp.add(new FoodStore("FoodPlaza HG", CAMPUS_BUILDINGS.get(0), "https://www.gispen.com/media/link/image/g/i/gispen_vrije_universiteit_amsterdam_k5b9453.jpg", menu));
        temp.add(new FoodStore("M•Foodcourt", CAMPUS_BUILDINGS.get(2), "http://www.vu-horeca.nl/wp-content/uploads/2018/10/mf-restaurant.jpg", menu));

        FOOD_STORES = Collections.unmodifiableList(temp);
    }

    public static final List<FoodOrder> PREVIOUS_ORDERS;
    static {
        List<FoodOrder> temp = new ArrayList<>();

        List<FoodItem> o1 = new ArrayList<>();
        o1.add(FOOD_STORES.get(0).getMenu().get(1));
        o1.add(FOOD_STORES.get(0).getMenu().get(4));
        temp.add(new FoodOrder(o1, FOOD_STORES.get(0),"2020-6-12T12:27:37Z", FoodOrder.Status.FINISHED));

        List<FoodItem> o2 = new ArrayList<>();
        o2.add(FOOD_STORES.get(1).getMenu().get(7));
        o2.add(FOOD_STORES.get(1).getMenu().get(8));
        temp.add(new FoodOrder(o2, FOOD_STORES.get(1),"2020-6-15T12:03:37Z", FoodOrder.Status.FINISHED));

        List<FoodItem> o3 = new ArrayList<>();
        o3.add(FOOD_STORES.get(0).getMenu().get(3));
        o3.add(FOOD_STORES.get(0).getMenu().get(4));
        temp.add(new FoodOrder(o3, FOOD_STORES.get(0),"2020-6-16T14:14:37Z", FoodOrder.Status.FINISHED));

        PREVIOUS_ORDERS = Collections.unmodifiableList(temp);
    }

}
