package nl.vanrsmln.wilkin.hci2020.ui.orders;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import nl.vanrsmln.wilkin.hci2020.models.orders.FoodOrder;

import java.util.Collections;
import java.util.List;

public class OrderListAdapter extends BaseAdapter {

    private List<FoodOrder> orders;
    private Context context;

    public OrderListAdapter(List<FoodOrder> orders, Context context) {
        this.orders = orders;
        this.context = context;
    }

    @Override
    public int getCount() {
        return orders.size();
    }

    @Override
    public Object getItem(int i) {
        return orders.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        return new OrderView(this.context, (FoodOrder) getItem(i));
    }
}
