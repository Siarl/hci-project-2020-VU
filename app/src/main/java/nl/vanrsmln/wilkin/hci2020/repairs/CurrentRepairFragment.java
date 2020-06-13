package nl.vanrsmln.wilkin.hci2020.repairs;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import nl.vanrsmln.wilkin.hci2020.R;


public class CurrentRepairFragment extends Fragment {

	public View onCreateView(@NonNull LayoutInflater inflater,
							 ViewGroup container, Bundle savedInstanceState) {
		View root = inflater.inflate(R.layout.fragment_current_repair, container,
				false);

		return root;
	}
}
