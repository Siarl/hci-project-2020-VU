package nl.vanrsmln.wilkin.hci2020.ui.orders;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import nl.vanrsmln.wilkin.hci2020.models.orders.FoodStore;

import java.util.List;

public class FoodStoreListAdapter extends BaseAdapter {

    private List<FoodStore> stores;
    private Context context;
    private Activity activity;
    private int selected;

    public FoodStoreListAdapter(List<FoodStore> stores, Activity activity) {
        this.stores = stores;
        this.activity = activity;
    }

    @Override
    public int getCount() {
        return stores.size();
    }

    @Override
    public Object getItem(int i) {
        return stores.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        FoodStoreView foodStoreView =  new FoodStoreView(this.activity, (FoodStore) getItem(i));

        return foodStoreView;
    }
}