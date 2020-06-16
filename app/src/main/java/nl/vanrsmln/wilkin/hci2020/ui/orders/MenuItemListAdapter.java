package nl.vanrsmln.wilkin.hci2020.ui.orders;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import nl.vanrsmln.wilkin.hci2020.models.orders.FoodItem;
import nl.vanrsmln.wilkin.hci2020.models.orders.FoodStore;

import java.util.List;

public class MenuItemListAdapter extends BaseAdapter {

    private List<FoodItem> foodItems;
    private Activity activity;

    public MenuItemListAdapter(List<FoodItem> foodItems, Activity activity) {
        this.foodItems = foodItems;
        this.activity = activity;
    }

    @Override
    public int getCount() {
        return foodItems.size();
    }

    @Override
    public Object getItem(int i) {
        return foodItems.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        MenuItemView menuItemView =  new MenuItemView(this.activity, (FoodItem) getItem(i));

        return menuItemView;
    }
}