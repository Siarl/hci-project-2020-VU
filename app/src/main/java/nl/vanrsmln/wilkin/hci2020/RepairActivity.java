package nl.vanrsmln.wilkin.hci2020;

import android.view.MenuItem;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import nl.vanrsmln.wilkin.hci2020.repairs.CurrentRepairFragment;
import nl.vanrsmln.wilkin.hci2020.repairs.NewRepairFragment;

public class RepairActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

	String[] buildings = {"HG", "WN", "OZW", "MF", "Intium", "NU", "Transitorium", "UMC", "Acta", "O|2", "BelleVue"};

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_repair);

        Spinner spin = (Spinner) findViewById(R.id.spinner_buildings);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item);
        spin.setAdapter(adapter);
        spin.setOnItemSelectedListener(this);

        BottomNavigationView navView = findViewById(R.id.nav_repair);
        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
                R.id.nav_repair_new, R.id.nav_repair_current)
                .build();

        NavController navController = Navigation.findNavController(this, R.id.nav_repair_fragment);
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
        NavigationUI.setupWithNavController(navView, navController);
	}

	@Override
	public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
		Toast.makeText(getApplicationContext(), "Selected Building: " + buildings[position], Toast.LENGTH_SHORT).show();
	}

	@Override
	public void onNothingSelected(AdapterView<?> parent) {

	}

	public void openFragment(Fragment fragment) {
		FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
		transaction.replace(R.id.repair_fragment, fragment);
		transaction.addToBackStack(null);
		transaction.commit();
	}

	private void showMessageDialog(String str) {
		AlertDialog.Builder builder = new AlertDialog.Builder(this);
		builder.setMessage(str);
		builder.setCancelable(false);
		builder.setNeutralButton("OK", new DialogInterface.OnClickListener() {
			@Override
			public void onClick(DialogInterface dialog, int which) {
				dialog.dismiss();
			}
		});
		AlertDialog alert = builder.create();
		alert.show();
	}

	public void createRequest(View view) {
		showMessageDialog("Repair Request created!");
		Intent intent = new Intent(this, CurrentRepairFragment.class);
		startActivity(intent);
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
