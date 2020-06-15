package nl.vanrsmln.wilkin.hci2020.ui.security;

import android.content.Context;
import android.media.Image;
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

			contactImage.setOnClickListener(v -> {
				if(getAdapterPosition() == 2) {
					Toast.makeText(v.getContext(), "Sharing your location...", Toast.LENGTH_LONG).show();
				}
			});
		}
	}
}
