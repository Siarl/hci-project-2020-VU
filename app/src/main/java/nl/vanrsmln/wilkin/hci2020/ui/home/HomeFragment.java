package nl.vanrsmln.wilkin.hci2020.ui.home;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridLayout;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import com.google.android.material.snackbar.Snackbar;
import nl.vanrsmln.wilkin.hci2020.AssociationsActivity;
import nl.vanrsmln.wilkin.hci2020.R;

public class HomeFragment extends Fragment implements View.OnClickListener {

	public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
		HomeViewModel homeViewModel = ViewModelProviders.of(this).get(HomeViewModel.class);
        View root = inflater.inflate(R.layout.fragment_home, container, false);
        final GridLayout gridLayout = root.findViewById(R.id.home_cards);
        homeViewModel.getText().observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {

            }
        });
        CardView card = root.findViewById(R.id.associations_button);
        card.setOnClickListener(this);
        CardView schedule = root.findViewById(R.id.schedule_button);
        schedule.setOnClickListener(this);
        return root;
    }

	@Override
	public void onClick(View v) {
		switch(v.getId()) {
			case R.id.associations_button:
				startActivity(new Intent(getActivity(), AssociationsActivity.class));
				break;
		}
	}
}
