package nl.vanrsmln.wilkin.hci2020.ui.associations;

import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.snackbar.Snackbar;
import nl.vanrsmln.wilkin.hci2020.R;

public class AssociationsAdapter extends RecyclerView.Adapter<AssociationsAdapter.ViewHolder> {

	private final String[] names = {
		"STORM",
		"VCSVU",
		"SABA"
	};

	private final String[] descriptions = {
		"The study association for students of the Faculties of Mathematics and Computer Science",
		"VCSVU is the association for all chemistry and pharmaceutical sciences students",
		"Business Analytics students, this is the place for you!"
	};

	private final int[] logos = {
		R.drawable.ic_storm_logo,
		R.drawable.ic_vcsvu_logo,
		R.drawable.ic_saba_logo
	};

	class ViewHolder extends RecyclerView.ViewHolder {
		public int currentItem;
		public TextView itemName;
		public TextView itemDescription;
		public ImageView itemLogo;

		public ViewHolder(View itemView) {
			super(itemView);
			itemName = (TextView)itemView.findViewById(R.id.association_name);
			itemDescription = (TextView)itemView.findViewById(R.id.association_description);
			itemLogo = (ImageView)itemView.findViewById(R.id.association_logo);
			itemView.setOnClickListener((v) -> {
				int position = getAdapterPosition();
				Snackbar.make(v, "Click detected", Snackbar.LENGTH_LONG).setAction("Action", null).show();
			});
		}
	}

	@NonNull
	@Override
	public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
		View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.associations_cardview, parent, false);
		ViewHolder viewHolder = new ViewHolder(v);
		return viewHolder;
	}

	@Override
	public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
		holder.itemDescription.setText(descriptions[position]);
		holder.itemName.setText(names[position]);
		holder.itemLogo.setImageResource(logos[position]);
	}

	@Override
	public int getItemCount() {
		return names.length;
	}
}
