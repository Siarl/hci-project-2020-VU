package nl.vanrsmln.wilkin.hci2020;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.cardview.widget.CardView;
import androidx.appcompat.app.AppCompatActivity;
import com.google.android.material.snackbar.Snackbar;
import nl.vanrsmln.wilkin.hci2020.ui.orders.OrderView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        CardView card = findViewById(R.id.associations_button);
        CardView schedule = findViewById(R.id.schedule_button);
        CardView lunch = findViewById(R.id.lunch_button);
        CardView navigation = findViewById(R.id.navigation_button);
        CardView repair = findViewById(R.id.repair_button);
        CardView security = findViewById(R.id.security_button);

        card.setOnClickListener(this);
        schedule.setOnClickListener(this);
        security.setOnClickListener(this);
        navigation.setOnClickListener(this);
        repair.setOnClickListener(this);
        lunch.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()) {
            case R.id.associations_button:
                startActivity(new Intent(this, AssociationsActivity.class));
                break;
            case R.id.security_button:
                startActivity(new Intent(this, SecurityActivity.class));
                break;
            case R.id.repair_button:
                startActivity(new Intent(this, RepairActivity.class));
                break;
            case R.id.lunch_button:
                startActivity(new Intent(this, OrderActivity.class));
                break;
            default:
                Snackbar.make(v, "Unavailable in this version...stay tuned!", Snackbar.LENGTH_LONG).setAction("Action", null).show();
                break;
        }
    }

}
