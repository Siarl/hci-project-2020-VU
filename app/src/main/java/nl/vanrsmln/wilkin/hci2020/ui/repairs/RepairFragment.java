package nl.vanrsmln.wilkin.hci2020.ui.repairs;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import nl.vanrsmln.wilkin.hci2020.R;
import nl.vanrsmln.wilkin.hci2020.models.repairs.RepairRequest;
import nl.vanrsmln.wilkin.hci2020.models.repairs.RepairRequestRepository;

import java.util.ArrayList;
import java.util.List;


public class RepairFragment extends Fragment {
    private static final String TAG = "RepairFragment";

    private static final String ARG_SECTION_NUMBER = "section_number";

    private ListView listView;
    private TextView textView;
    private int index = 1;

    public static RepairFragment newInstance(int index) {
        RepairFragment fragment = new RepairFragment();
        Bundle bundle = new Bundle();
        bundle.putInt(ARG_SECTION_NUMBER, index);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            index = getArguments().getInt(ARG_SECTION_NUMBER);
        }
        Log.d(TAG, "onCreate: INDEX = " + index);
    }

    @Override
    public View onCreateView(
            @NonNull LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_repair, container, false);

        listView = root.findViewById(R.id.listView);
        textView = root.findViewById(R.id.textView);

        return root;
    }

    @Override
    public void onResume() {
        super.onResume();

        List<RepairRequest> requests = new ArrayList<>();
        if (index == 1) {
            requests = RepairRequestRepository.getInstance().getAcceptedRequests();
        } else if (index == 2) {
            requests = RepairRequestRepository.getInstance().getMyRequests();
        } else {
            Log.e(TAG, "INVALID INDEX????");
        }

        listView.setAdapter(new RepairListAdapter(getContext(), requests));

        if (listView.getAdapter().getCount() > 0) {
            textView.setVisibility(View.GONE);
        }
    }
}