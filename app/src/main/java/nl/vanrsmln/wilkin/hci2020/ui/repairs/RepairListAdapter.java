package nl.vanrsmln.wilkin.hci2020.ui.repairs;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import nl.vanrsmln.wilkin.hci2020.models.repairs.RepairRequest;

import java.util.List;

public class RepairListAdapter extends BaseAdapter {

    List<RepairRequest> repairRequests;
    Context context;

    public RepairListAdapter(Context context, List<RepairRequest> repairRequests) {
        this.context = context;
        this.repairRequests = repairRequests;
    }

    @Override
    public int getCount() {
        return repairRequests.size();
    }

    @Override
    public Object getItem(int i) {
        return repairRequests.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        return new RepairRequestView(this.context, (RepairRequest) getItem(i));
    }
}
