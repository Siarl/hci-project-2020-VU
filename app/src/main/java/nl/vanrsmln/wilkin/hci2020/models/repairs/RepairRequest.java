package nl.vanrsmln.wilkin.hci2020.models.repairs;

import com.kofigyan.stateprogressbar.StateProgressBar;
import nl.vanrsmln.wilkin.hci2020.models.buildings.Building;
import nl.vanrsmln.wilkin.hci2020.models.buildings.Room;
import nl.vanrsmln.wilkin.hci2020.models.buildings.Wing;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class RepairRequest {

    public enum Status {
        ARRIVED("arrived", StateProgressBar.StateNumber.ONE),
        ACCEPTED("accepted", StateProgressBar.StateNumber.TWO),
        IN_PROGRESS("in progress", StateProgressBar.StateNumber.THREE),
        COMPLETED("completed", StateProgressBar.StateNumber.FOUR);

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

        public boolean isAccepted() {
            return this == ACCEPTED || this == IN_PROGRESS || this == COMPLETED;
        }

        public static List<String> getNames() {
            List<String> result = new ArrayList<>();
            for (Status status : Status.values()) {
                result.add(status.getName());
            }
            return result;
        }
    }

    public Building building;
    public Wing wing;
    public Room room;
    public String description;
    public Status status;
    public Date date;

    public RepairRequest(Building building, Wing wing, Room room, String description, Status status, Date date) {
        this.building = building;
        this.wing = wing;
        this.room = room;
        this.description = description;
        this.status = status;
        this.date = date;
    }

    public RepairRequest(Building building, Wing wing, Room room, String description, Status status, String dateString) {
        this.building = building;
        this.wing = wing;
        this.room = room;
        this.description = description;
        this.status = status;
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'");
        try {
            date = format.parse(dateString);
            System.out.println(date);
        } catch (ParseException e) {
            e.printStackTrace();
            date = Calendar.getInstance().getTime();
        }
    }

    public RepairRequest(Building building, Wing wing, Room room, String description) {
        this(building, wing, room, description, Status.ARRIVED, Calendar.getInstance().getTime());
    }
}
