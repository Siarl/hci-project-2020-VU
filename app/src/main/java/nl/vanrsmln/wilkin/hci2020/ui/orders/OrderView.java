package nl.vanrsmln.wilkin.hci2020.ui.orders;

import android.content.Context;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.google.android.material.card.MaterialCardView;
import com.kofigyan.stateprogressbar.StateProgressBar;
import nl.vanrsmln.wilkin.hci2020.R;
import nl.vanrsmln.wilkin.hci2020.models.orders.FoodItem;
import nl.vanrsmln.wilkin.hci2020.models.orders.FoodOrder;

import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class OrderView extends MaterialCardView {

    private ImageView image;
    private TextView title, subtitle, description;
    private StateProgressBar progressBar;

    private FoodOrder foodOrder;

    public OrderView(@NonNull Context context, FoodOrder foodOrder) {
        super(context);
        this.foodOrder = foodOrder;
        init(context);
    }

    private void init(Context context) {
        inflate(context, R.layout.view_order, this);

        image = findViewById(R.id.image);
        image.setVisibility(GONE);

        title = findViewById(R.id.title);
        SimpleDateFormat df1 = new SimpleDateFormat("dd MMMM");
        title.setText(foodOrder.getLocation().getName() + " " + df1.format(foodOrder.getDate()));

        subtitle = findViewById(R.id.subtitle);
        SimpleDateFormat df2 = new SimpleDateFormat("HH:mm");
        subtitle.setText(df2.format(foodOrder.getDate() ) + " | " + priceToString(foodOrder.getTotalPrice()));

        description = findViewById(R.id.description);
        String text = "";
        for (FoodItem item : foodOrder.getItems()) {
            text += "\t- " + item.getName() + ": " + priceToString(item.getPrice()) + "\n";
        }
        description.setText(text);

        progressBar = findViewById(R.id.progressBar);
        progressBar.setStateDescriptionData(new ArrayList<>(FoodOrder.Status.getNames()));
        progressBar.setCurrentStateNumber(foodOrder.getStatus().getStateNumber());
    }

    public String priceToString(int price) {
        int euro = (int) Math.floor( ((double) price) / 100);
        int cents = price % 100;
        String centString = cents == 0 ? "00" : Integer.toString(cents);
        return "€"+euro+","+centString;
    }
}
