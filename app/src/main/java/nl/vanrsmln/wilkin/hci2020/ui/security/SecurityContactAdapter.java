package nl.vanrsmln.wilkin.hci2020.ui.security;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import nl.vanrsmln.wilkin.hci2020.R;
import java.util.ArrayList;

public class SecurityContactAdapter extends RecyclerView.Adapter<SecurityContactHolder> {

	Context c;
	ArrayList<SecurityModel> models;

	public SecurityContactAdapter(Context c, ArrayList<SecurityModel> models) {
		this.c = c;
		this.models = models;
	}

	@NonNull
	@Override
	public SecurityContactHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
		View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.contact_rows, null);
		return new SecurityContactHolder(view);
	}

	@Override
	public void onBindViewHolder(@NonNull SecurityContactHolder holder, int position) {
		holder.textTitle.setText(models.get(position).getTitle());
		holder.textDescription.setText(models.get(position).getDescription());
		holder.iconView.setImageResource(models.get(position).getIcon());
	}

	@Override
	public int getItemCount() {
		return models.size();
	}
}
