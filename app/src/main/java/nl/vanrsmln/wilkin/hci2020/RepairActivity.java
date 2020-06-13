package nl.vanrsmln.wilkin.hci2020;

import android.content.DialogInterface;
import android.content.Intent;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class RepairActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

	String[] buildings = {"HG", "WN", "OZW", "MF", "Intium", "NU", "Transitorium", "UMC", "Acta", "O|2", "BelleVue"};

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_repair);
		BottomNavigationView navView = findViewById(R.id.repair_nav);
		Spinner spin = (Spinner) findViewById(R.id.spinner_buildings);
		ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item);
		spin.setAdapter(adapter);
		spin.setOnItemSelectedListener(this);
		navView.setOnNavigationItemSelectedListener(navigationItemSelectedListener);
		openFragment(CurrentRepairFragment.newInstance("", ""));
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
