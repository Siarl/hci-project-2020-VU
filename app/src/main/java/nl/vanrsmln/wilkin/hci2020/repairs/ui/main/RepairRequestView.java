package nl.vanrsmln.wilkin.hci2020.repairs.ui.main;

import android.content.Context;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.google.android.material.card.MaterialCardView;
import com.kofigyan.stateprogressbar.StateProgressBar;
import nl.vanrsmln.wilkin.hci2020.R;
import nl.vanrsmln.wilkin.hci2020.repairs.RepairRequest;

import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class RepairRequestView extends MaterialCardView {

    private ImageView image;
    private TextView title, subtitle, description;
    private StateProgressBar progressBar;

    private RepairRequest repairRequest;

    public RepairRequestView(@NonNull Context context, RepairRequest repairRequest) {
        super(context);
        this.repairRequest = repairRequest;
        init(context);
    }

    private void init(Context context) {
        inflate(context, R.layout.view_repair_request, this);

        image = findViewById(R.id.image);
        title = findViewById(R.id.title);
        subtitle = findViewById(R.id.subtitle);
        description = findViewById(R.id.description);
        progressBar = findViewById(R.id.progressBar);

        title.setText("Repair: " + repairRequest.building.name + ", " + repairRequest.wing.name + ", " + repairRequest.room.name);

        SimpleDateFormat df = new SimpleDateFormat("dd MMMM yy");
        subtitle.setText(df.format(repairRequest.date));

        description.setText(repairRequest.description);

        progressBar.setStateDescriptionData(new ArrayList<>(RepairRequest.Status.getNames()));
        progressBar.setCurrentStateNumber(repairRequest.status.getStateNumber());
    }


}
