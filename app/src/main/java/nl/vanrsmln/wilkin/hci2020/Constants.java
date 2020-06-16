package nl.vanrsmln.wilkin.hci2020;

import nl.vanrsmln.wilkin.hci2020.models.buildings.Building;
import nl.vanrsmln.wilkin.hci2020.models.buildings.Room;
import nl.vanrsmln.wilkin.hci2020.models.buildings.Wing;
import nl.vanrsmln.wilkin.hci2020.models.repairs.RepairRequest;

import java.util.*;

public class Constants {

    public static final List<Building> buildings;
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
        
        buildings = Collections.unmodifiableList(temp);
    }

    public static final List<RepairRequest> repairRequests;
    static {
        List<RepairRequest> temp = new ArrayList<>();

        Random rand = new Random();

        temp.add(new RepairRequest(
                buildings.get(0),
                buildings.get(0).wings.get(0),
                buildings.get(0).wings.get(0).rooms.get(0),
                "Toilet doesn't flush :/",
                RepairRequest.Status.COMPLETED,
                "2020-5-15T09:27:37Z"
        ));

        temp.add(new RepairRequest(
                buildings.get(1),
                buildings.get(1).wings.get(1),
                buildings.get(1).wings.get(1).rooms.get(0),
                "Looks like someone punched a hole in the wall.",
                RepairRequest.Status.COMPLETED,
                "2020-5-19T09:27:37Z"
        ));

        temp.add(new RepairRequest(
                buildings.get(2),
                buildings.get(2).wings.get(0),
                buildings.get(2).wings.get(0).rooms.get(4),
                "Light is flickering",
                RepairRequest.Status.COMPLETED,
                "2020-5-23T09:27:37Z"
        ));

        temp.add(new RepairRequest(
                buildings.get(0),
                buildings.get(0).wings.get(0),
                buildings.get(0).wings.get(0).rooms.get(7),
                "The radiator is broken",
                RepairRequest.Status.COMPLETED,
                "2020-6-1T09:27:37Z"
        ));

        temp.add(new RepairRequest(
                buildings.get(1),
                buildings.get(1).wings.get(0),
                buildings.get(1).wings.get(0).rooms.get(3),
                "Hi, the toilet here does not flush.",
                RepairRequest.Status.IN_PROGRESS,
                "2020-6-6T09:27:37Z"
        ));

        temp.add(new RepairRequest(
                buildings.get(0),
                buildings.get(0).wings.get(1),
                buildings.get(0).wings.get(1).rooms.get(4),
                "Toilet is clogged",
                RepairRequest.Status.IN_PROGRESS,
                "2020-6-12T09:27:37Z"
        ));

        Collections.sort(temp, (t1, t2) -> t2.date.compareTo(t1.date));

        repairRequests = Collections.unmodifiableList(temp);
    }

}
