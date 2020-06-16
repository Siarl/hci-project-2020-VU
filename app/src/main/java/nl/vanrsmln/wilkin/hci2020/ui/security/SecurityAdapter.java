package nl.vanrsmln.wilkin.hci2020.ui.security;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.media.Image;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import nl.vanrsmln.wilkin.hci2020.R;

public class SecurityAdapter  extends RecyclerView.Adapter<SecurityAdapter.ViewHolder> {

	private final int[] images = {
		R.drawable.ic_call_red_24dp,
		R.drawable.ic_call_red_24dp,
		R.drawable.ic_notifications_active_red_24dp
	};

	private final String[] contact = {
		"CLICK TO CALL CAMPUS SECURITY",
		"CLICK TO CALL 112",
		"CLICK TO CALL SOS "
	};

	private final String[] numbers = {
		"campus security phone",
		"112",
		"Your location will be shared with the security team"
	};

	@NonNull
	@Override
	public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
		View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.security_cardview, parent, false);
		ViewHolder viewHolder = new ViewHolder(v);
		return viewHolder;
	}

	@Override
	public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
		holder.contactImage.setImageResource(images[position]);
		holder.contactText.setText(contact[position]);
		holder.contactNumber.setText(numbers[position]);
	}

	@Override
	public int getItemCount() {
		return contact.length;
	}

	public class ViewHolder extends RecyclerView.ViewHolder{
		public int currentItem;
		public ImageView contactImage;
		public TextView contactText;
		public TextView contactNumber;
		public ViewHolder(@NonNull View itemView) {
			super(itemView);
			contactImage = itemView.findViewById(R.id.call_image);
			contactText = itemView.findViewById(R.id.contact_title);
			contactNumber = itemView.findViewById(R.id.contact_number);

			contactNumber.setOnClickListener(v -> {
				if(getAdapterPosition() == 2) {
					AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(v.getContext());
					alertDialogBuilder.setMessage("Are you sure? Calling an SOS should only be done in case of dire emergencies. Anyone that is found to be calling false alarms will be reprimanded accordingly.");
					alertDialogBuilder.setTitle("SOS");
					alertDialogBuilder.setPositiveButton("SOS", (dialog, which) -> {
						Toast.makeText(v.getContext(), "Sending your location....", Toast.LENGTH_LONG).show();
					});
					alertDialogBuilder.setNegativeButton("Cancel", (dialog, which) -> {
						Toast.makeText(v.getContext(), "SOS Cancelled", Toast.LENGTH_SHORT).show();
					});
					AlertDialog alert = alertDialogBuilder.create();
					alert.show();
				}
			});
		}
	}
}
