package nl.vanrsmln.wilkin.hci2020;

import android.view.View;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import nl.vanrsmln.wilkin.hci2020.Constants;
import nl.vanrsmln.wilkin.hci2020.R;
import nl.vanrsmln.wilkin.hci2020.models.buildings.Building;
import nl.vanrsmln.wilkin.hci2020.models.buildings.Room;
import nl.vanrsmln.wilkin.hci2020.models.buildings.Wing;
import nl.vanrsmln.wilkin.hci2020.models.repairs.RepairRequest;
import nl.vanrsmln.wilkin.hci2020.models.repairs.RepairRequestRepository;

import java.util.ArrayList;

public class NewRepairRequestActivity extends AppCompatActivity {
    private static final String TAG = "NewRepairRequestActivit";

    private Spinner spinner1, spinner2, spinner3;
    private EditText editText;
    private Button submitButton;

    private Room room;
    private Wing wing;
    private Building building;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_repair_request);

        spinner3 = findViewById(R.id.spinner3);
        ArrayAdapter<Room> buildingAdapter3 = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, new ArrayList<>());
        buildingAdapter3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner3.setAdapter(buildingAdapter3);
        spinner3.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                room = (Room) adapterView.getItemAtPosition(i);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        spinner2 = findViewById(R.id.spinner2);
        ArrayAdapter<Wing> buildingAdapter2 = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, new ArrayList<>());
        buildingAdapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner2.setAdapter(buildingAdapter2);
        spinner2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                wing = (Wing) adapterView.getItemAtPosition(i);
                buildingAdapter3.clear();
                buildingAdapter3.addAll(wing.rooms);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });


        spinner1 = findViewById(R.id.spinner1);
        ArrayAdapter<Building> buildingAdapter1 = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, Constants.buildings);
        buildingAdapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner1.setAdapter(buildingAdapter1);
        spinner1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                building = (Building) adapterView.getItemAtPosition(i);
                buildingAdapter2.clear();
                buildingAdapter2.addAll(building.wings);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        editText = findViewById(R.id.editText);
        submitButton = findViewById(R.id.submitButton);
        submitButton.setOnClickListener((v) -> submit());

        findViewById(R.id.backButton).setOnClickListener((v) -> finish());

    }

    private void submit() {
        String desc = editText.getText().toString();
        if (desc == null || desc.isEmpty()) {
            Toast.makeText(this, "Please provide a description.", Toast.LENGTH_LONG).show();
            return;
        }

        RepairRequest repairRequest = new RepairRequest(building, wing, room, desc);

        RepairRequestRepository.getInstance().getMyRequests().add(repairRequest);

        finish();
    }
}
