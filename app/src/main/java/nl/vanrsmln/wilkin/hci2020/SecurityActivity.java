package nl.vanrsmln.wilkin.hci2020;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import nl.vanrsmln.wilkin.hci2020.ui.security.SecurityContactAdapter;
import nl.vanrsmln.wilkin.hci2020.ui.security.SecurityModel;

import java.util.ArrayList;

public class SecurityActivity extends AppCompatActivity {

	RecyclerView recyclerView;
	SecurityContactAdapter securityContactAdapter;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_security);

		recyclerView = findViewById(R.id.security_contact);
		recyclerView.setLayoutManager(new LinearLayoutManager(this));

		securityContactAdapter = new SecurityContactAdapter(this, getMyList());
		recyclerView.setAdapter(securityContactAdapter);
	}

	private ArrayList<SecurityModel> getMyList() {
		ArrayList<SecurityModel> models = new ArrayList<>();
		SecurityModel model = new SecurityModel();
		model.setTitle("Call Emergency Services");
		model.setDescription("Click here to call 112 directly");
		model.setIcon(R.drawable.ic_local_hospital_red_24dp);
		models.add(model);

		return models;
	}
}
