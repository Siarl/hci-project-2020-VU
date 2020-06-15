package nl.vanrsmln.wilkin.hci2020.models.buildings;

import androidx.annotation.NonNull;

import java.util.ArrayList;
import java.util.List;

public class Wing {
    public String name;
    public List<Room> rooms;

    public Wing(String name, List<Room> rooms) {
        this.name = name;
        this.rooms = rooms;
    }

    @NonNull
    @Override
    public String toString() {
        return name;
    }
}
