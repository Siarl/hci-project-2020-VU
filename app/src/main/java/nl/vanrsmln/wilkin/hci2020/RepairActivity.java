package nl.vanrsmln.wilkin.hci2020;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class RepairActivity extends AppCompatActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_repair);

		BottomNavigationView navView = findViewById(R.id.nav_repair);
		AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
				R.id.nav_repair_new, R.id.nav_repair_current)
				.build();

		NavController navController = Navigation.findNavController(this, R.id.nav_repair_fragment);
		NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
		NavigationUI.setupWithNavController(navView, navController);
	}


}
