package nl.vanrsmln.wilkin.hci2020.ui.orders;

import android.app.Activity;
import android.content.Context;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.google.android.material.card.MaterialCardView;
import nl.vanrsmln.wilkin.hci2020.R;
import nl.vanrsmln.wilkin.hci2020.models.orders.FoodStore;

public class FoodStoreView extends MaterialCardView {
    private static final String TAG = "FoodStoreView";

    private ImageView image;
    private TextView title, subtitle;

    private FoodStore foodStore;
    private Activity activity;

    public FoodStoreView(@NonNull Activity activity, FoodStore foodStore) {
        super(activity);
        this.foodStore = foodStore;
        this.activity = activity;
        init(activity);
    }

    private void init(Context context) {
        inflate(context, R.layout.view_foodstore, this);

        image = findViewById(R.id.image);
        image.setImageResource(foodStore.getImgId());

        title = findViewById(R.id.title);
        title.setText(foodStore.getName());

        subtitle = findViewById(R.id.subtitle);
        subtitle.setText(foodStore.getLocation().name + " " + foodStore.getOpeningHours());
    }
}
