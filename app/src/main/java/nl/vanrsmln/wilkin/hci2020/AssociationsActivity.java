package nl.vanrsmln.wilkin.hci2020;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import nl.vanrsmln.wilkin.hci2020.ui.associations.AssociationsAdapter;

public class AssociationsActivity extends AppCompatActivity {

	RecyclerView recyclerView;
	RecyclerView.LayoutManager layoutManager;
	RecyclerView.Adapter adapter;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_associations);
		//Setting up the recycler view
		recyclerView = (RecyclerView)findViewById(R.id.associations_recycler);
		layoutManager = new LinearLayoutManager(this);
		recyclerView.setLayoutManager(layoutManager);
		adapter = new AssociationsAdapter();
		recyclerView.setAdapter(adapter);
	}
}
