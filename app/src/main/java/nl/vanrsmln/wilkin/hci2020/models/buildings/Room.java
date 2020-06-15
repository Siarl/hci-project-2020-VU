package nl.vanrsmln.wilkin.hci2020.models.buildings;

import androidx.annotation.NonNull;

public class Room {
    public String name;

    public Room(String name) {
        this.name = name;
    }

    @NonNull
    @Override
    public String toString() {
        return name;
    }
}
