package nl.vanrsmln.wilkin.hci2020.repairs;

import android.content.DialogInterface;
import android.os.Bundle;
import android.widget.*;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import nl.vanrsmln.wilkin.hci2020.R;


public class NewRepairFragment extends Fragment
		implements AdapterView.OnItemSelectedListener {

	String[] buildings = {"HG", "WN", "OZW", "MF", "Intium", "NU", "Transitorium", "UMC", "Acta", "O|2", "BelleVue"};

	public View onCreateView(@NonNull LayoutInflater inflater,
							 ViewGroup container, Bundle savedInstanceState) {
		View root = inflater.inflate(R.layout.fragment_new_repair, container,
				false);

		Spinner spin = (Spinner) root.findViewById(R.id.spinner_buildings);
		ArrayAdapter<String> adapter = new ArrayAdapter<String>(getContext(), android.R.layout.simple_spinner_dropdown_item);
		spin.setAdapter(adapter);
		spin.setOnItemSelectedListener(this);

		Button submit = root.findViewById(R.id.button_submit);
		submit.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				showMessageDialog("hi");
			}
		});

		return root;
	}

	@Override
	public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
		Toast.makeText(getContext(), "Selected Building: " + buildings[position], Toast.LENGTH_SHORT).show();
	}

	@Override
	public void onNothingSelected(AdapterView<?> parent) {

	}

	private void showMessageDialog(String str) {
		AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
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


}
