package nl.vanrsmln.wilkin.hci2020.repairs;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


public class NewRepairFragment extends Fragment {

	public View onCreateView(@NonNull LayoutInflater inflater,
							 ViewGroup container, Bundle savedInstanceState) {
		View root = inflater.inflate(R.layout.fragment_new_repair, container,
				false);

		return root;
	}
}
