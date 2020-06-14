package nl.vanrsmln.wilkin.hci2020;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import nl.vanrsmln.wilkin.hci2020.ui.security.SecurityAdapter;

public class SecurityActivity extends AppCompatActivity {

	RecyclerView recyclerView;
	RecyclerView.LayoutManager layoutManager;
	RecyclerView.Adapter adapter;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_security);
		//Setting up the recycler view
		recyclerView = findViewById(R.id.security_recycler);
		layoutManager = new LinearLayoutManager(this);
		recyclerView.setLayoutManager(layoutManager);
		adapter = new SecurityAdapter();
		recyclerView.setAdapter(adapter);
	}
}
