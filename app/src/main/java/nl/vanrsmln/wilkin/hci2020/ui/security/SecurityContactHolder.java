package nl.vanrsmln.wilkin.hci2020.ui.security;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import nl.vanrsmln.wilkin.hci2020.R;

public class SecurityContactHolder extends RecyclerView.ViewHolder {
	ImageView iconView;
	TextView textTitle, textDescription;

	public SecurityContactHolder(@NonNull View itemView) {
		super(itemView);
		this.iconView = itemView.findViewById(R.id.call_security_icon);
		this.textTitle = itemView.findViewById(R.id.call_security_text);
		this.textTitle = itemView.findViewById(R.id.call_security_description);
	}
}
