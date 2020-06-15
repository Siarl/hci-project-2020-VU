package nl.vanrsmln.wilkin.hci2020.models.buildings;

import androidx.annotation.NonNull;

import java.util.ArrayList;
import java.util.List;

public class Building {
    public String name;
    public List<Wing> wings;

    public Building(String name, List<Wing> wings) {
        this.name = name;
        this.wings = wings;
    }

    @NonNull
    @Override
    public String toString() {
        return name;
    }
}
