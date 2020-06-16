package nl.vanrsmln.wilkin.hci2020.ui.orders;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.widget.Button;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.google.android.material.card.MaterialCardView;
import nl.vanrsmln.wilkin.hci2020.R;
import nl.vanrsmln.wilkin.hci2020.models.orders.FoodItem;

public class MenuItemView extends MaterialCardView {
    private static final String TAG = "MenuItemView";

    public static final String BROADCAST_COUNT_CHANGED = "BROADCAST_COUNT_CHANGED";
    public static final String EXTRA_IS_ADD = "EXTRA_COUNT";
    public static final String EXTRA_FOOD_ITEM = "EXTRA_FOOD_ITEM";

    private TextView title, subtitle, description, countView;
    private Button buttonMinus, buttonPlus;

    private FoodItem foodItem;
    private Activity activity;

    private int count = 0;

    public MenuItemView(@NonNull Activity activity, FoodItem foodItem) {
        super(activity);
        this.foodItem = foodItem;
        this.activity = activity;
        init(activity);
    }

    private void init(Context context) {
        inflate(context, R.layout.view_menu_item, this);

        title = findViewById(R.id.title);
        title.setText(foodItem.getName());

        subtitle = findViewById(R.id.subtitle);
        subtitle.setText(priceToString(foodItem.getPrice()));

        description = findViewById(R.id.description);
        description.setText(foodItem.getDescription());

        countView = findViewById(R.id.count);

        buttonMinus = findViewById(R.id.buttonMinus);
        buttonMinus.setOnClickListener(view -> {
            if (count > 0) {
                count--;

                countView.setText(" " + count + " ");

                Intent intent = new Intent();
                intent.setAction(BROADCAST_COUNT_CHANGED);
                intent.putExtra(EXTRA_IS_ADD, false);
                intent.putExtra(EXTRA_FOOD_ITEM, foodItem);
                activity.sendBroadcast(intent);
            }
        });

        buttonPlus = findViewById(R.id.buttonPlus);
        buttonPlus.setOnClickListener(view -> {
            count++;

            countView.setText(" " + count + " ");

            Intent intent = new Intent();
            intent.setAction(BROADCAST_COUNT_CHANGED);
            intent.putExtra(EXTRA_IS_ADD, true);
            intent.putExtra(EXTRA_FOOD_ITEM, foodItem);
            activity.sendBroadcast(intent);
        });


    }

    public String priceToString(int price) {
        int euro = (int) Math.floor( ((double) price) / 100);
        int cents = price % 100;
        String centString = cents == 0 ? "00" : Integer.toString(cents);
        return "€"+euro+","+centString;
    }

}