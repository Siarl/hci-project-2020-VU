package nl.vanrsmln.wilkin.hci2020.ui.security;

import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import nl.vanrsmln.wilkin.hci2020.R;

public class SecurityAdapter  extends RecyclerView.Adapter<SecurityAdapter.ViewHolder> {

	private int[] images = {
		R.drawable.ic_call_red_24dp
	};

	private String[] contact = {
		"CLICK TO CALL CAMPUS SECURITY"
	};

	private String[] numbers = {
		"campus security phone"
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
		}
	}
}
