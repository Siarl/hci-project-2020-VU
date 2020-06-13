package nl.vanrsmln.wilkin.hci2020;

import android.view.MenuItem;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class RepairActivity extends AppCompatActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_repair);
		BottomNavigationView navView = findViewById(R.id.repair_nav);
		navView.setOnNavigationItemSelectedListener(navigationItemSelectedListener);
		openFragment(CurrentRepairFragment.newInstance("", ""));
	}

	public void openFragment(Fragment fragment) {
		FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
		transaction.replace(R.id.repair_fragment, fragment);
		transaction.addToBackStack(null);
		transaction.commit();
	}

	BottomNavigationView.OnNavigationItemSelectedListener navigationItemSelectedListener =
		menuItem -> {
			switch (menuItem.getItemId()) {
				case R.id.repair_new:
					openFragment(NewRepairFragment.newInstance("", ""));
					return true;
				case R.id.repair_current:
					openFragment(CurrentRepairFragment.newInstance("", ""));
					return true;
			}
			return false;
		};
}
