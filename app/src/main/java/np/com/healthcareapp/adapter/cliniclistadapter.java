package np.com.healthcareapp.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import np.com.healthcareapp.R;
import np.com.healthcareapp.model.doctor;


public class cliniclistadapter extends RecyclerView.Adapter<cliniclistadapter.ClinicListViewHolder> {

    List<doctor> clinicList;
    Context context;

    public cliniclistadapter(Context context,List<doctor> clinicList){
        this.clinicList = clinicList;

    }

    @NonNull
    @Override
    public ClinicListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        return new ClinicListViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_cliniclist, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ClinicListViewHolder holder, int position) {
        holder.tvClinicName.setText(clinicList.get(position).getName());
        holder.tvLocation.setText(clinicList.get(position).getLocation());
        holder.tvPhoneNumber.setText(clinicList.get(position).getNumber());


    }

    @Override
    public int getItemCount() {
        return clinicList.size();
    }


    public static class ClinicListViewHolder extends RecyclerView.ViewHolder{

        TextView tvClinicName;
        TextView tvLocation;
        TextView tvPhoneNumber;
        ImageView ivAmb2;
        ImageView ivAmb3;

        public ClinicListViewHolder(@NonNull View itemView) {
            super(itemView);

            tvClinicName = itemView.findViewById(R.id.tvClinicName);
            tvLocation = itemView.findViewById(R.id.tvLocation);
            tvPhoneNumber = itemView.findViewById(R.id.tvPhoneNumber);
            ivAmb2 = itemView.findViewById(R.id.ivAmb2);
            ivAmb3 = itemView.findViewById(R.id.ivAmb3);
        }
    }
}
