package nl.vanrsmln.wilkin.hci2020;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;
import android.widget.TextView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import android.view.View;
import nl.vanrsmln.wilkin.hci2020.models.orders.FoodOrder;
import nl.vanrsmln.wilkin.hci2020.models.orders.FoodRepository;
import nl.vanrsmln.wilkin.hci2020.ui.orders.OrderListAdapter;
import nl.vanrsmln.wilkin.hci2020.ui.repairs.RepairListAdapter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class OrderActivity extends AppCompatActivity {

    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(view -> startActivity(new Intent(this, NewOrderActivity.class)));

        listView = findViewById(R.id.listView);


    }

    @Override
    protected void onResume() {
        super.onResume();

        List<FoodOrder> orders = new ArrayList<>(FoodRepository.getInstance().getPreviousOrders());
        Log.d("ORDERVIEW", "onResume: ordres = " + orders.toString());
        Collections.sort(orders, (t1, t2) -> t2.getDate().compareTo(t1.getDate()));
        listView.setAdapter(new OrderListAdapter(orders, this));
    }
}
