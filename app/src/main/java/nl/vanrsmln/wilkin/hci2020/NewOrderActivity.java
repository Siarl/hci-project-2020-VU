package nl.vanrsmln.wilkin.hci2020;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import nl.vanrsmln.wilkin.hci2020.models.orders.FoodItem;
import nl.vanrsmln.wilkin.hci2020.models.orders.FoodOrder;
import nl.vanrsmln.wilkin.hci2020.models.orders.FoodRepository;
import nl.vanrsmln.wilkin.hci2020.models.orders.FoodStore;
import nl.vanrsmln.wilkin.hci2020.ui.orders.FoodStoreListAdapter;
import nl.vanrsmln.wilkin.hci2020.ui.orders.MenuItemListAdapter;
import nl.vanrsmln.wilkin.hci2020.ui.orders.MenuItemView;

import java.util.ArrayList;
import java.util.List;

public class NewOrderActivity extends AppCompatActivity {

    private ListView listView;
    private Button buttonPrevious, buttonNext;
    private View buttonContainer;
    private TextView itemsTextView;

    private Step step;

    private FoodStore foodStore;

    private List<FoodItem> items;

    private BroadcastReceiver broadcastReceiver;

    private enum Step {
        SHOP, MENU
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_order);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        listView = findViewById(R.id.listView);
        buttonPrevious = findViewById(R.id.buttonNext);
        buttonNext = findViewById(R.id.buttonNext);
        buttonContainer = findViewById(R.id.buttonContainer);
        itemsTextView = findViewById(R.id.orderListText);

        broadcastReceiver = new BroadcastReceiver() {
            @Override
            public void onReceive(Context context, Intent intent) {
                FoodItem item = (FoodItem) intent.getSerializableExtra(MenuItemView.EXTRA_FOOD_ITEM);
                boolean isAdd = intent.getBooleanExtra(MenuItemView.EXTRA_IS_ADD, true);

                if (isAdd) {
                    items.add(item);
                } else {
                    for (FoodItem item1 : items) {
                        if (item1.getName().equals(item.getName())) {
                            items.remove(item1);
                            break;
                        }
                    }
                }

                setItemsTextViewText();
            }
        };
        registerReceiver(broadcastReceiver, new IntentFilter(MenuItemView.BROADCAST_COUNT_CHANGED));

        setStep(Step.SHOP);
    }

    private void setStep(Step step) {
        this.step = step;

        switch (step) {
            case SHOP:
                buttonPrevious.setVisibility(View.INVISIBLE);
                buttonNext.setVisibility(View.INVISIBLE);
                buttonContainer.setVisibility(View.GONE);

                listView.setAdapter(new FoodStoreListAdapter(Constants.FOOD_STORES, this));
                listView.setOnItemClickListener((adapterView, view, i, l) -> {
                    foodStore = (FoodStore) adapterView.getItemAtPosition(i);
                    setStep(Step.MENU);
                });

                items = new ArrayList<>();

                break;
            case MENU:
                buttonContainer.setVisibility(View.VISIBLE);

                buttonPrevious.setVisibility(View.VISIBLE);
                buttonContainer.setOnClickListener(view -> setStep(Step.SHOP));

                buttonNext.setVisibility(View.VISIBLE);
                buttonNext.setOnClickListener(view -> {
                    FoodRepository.getInstance().placeOrder(new FoodOrder(items, foodStore));
                    Toast.makeText(this, "Order placed!", Toast.LENGTH_LONG).show();
                    finish();
                });

                listView.setAdapter(new MenuItemListAdapter(foodStore.getMenu(), this));

                break;
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (broadcastReceiver != null) {
            unregisterReceiver(broadcastReceiver);
        }
    }

    private void setItemsTextViewText() {
        String text = "";
        for (FoodItem foodItem : items) {
            text += "\t- " + foodItem.getName() + " (" + priceToString(foodItem.getPrice()) +")\n";
        }
        itemsTextView.setText(text);
    }

    public String priceToString(int price) {
        int euro = (int) Math.floor( ((double) price) / 100);
        int cents = price % 100;
        String centString = cents == 0 ? "00" : Integer.toString(cents);
        return "€"+euro+","+centString;
    }
}
