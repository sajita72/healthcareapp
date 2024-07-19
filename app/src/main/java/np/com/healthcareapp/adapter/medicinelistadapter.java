package np.com.healthcareapp.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import np.com.healthcareapp.R;
import np.com.healthcareapp.model.doctor;


public class medicinelistadapter extends RecyclerView.Adapter<medicinelistadapter.MedicineListViewHolder> {

    List<doctor> medicineList;
    Context context;

    public medicinelistadapter(List<doctor> medicineList){
        this.medicineList = medicineList;

    }

    @NonNull
    @Override
    public MedicineListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        return new MedicineListViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_medicinelist, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull MedicineListViewHolder holder, int position) {
        holder.tvMedicineName.setText(medicineList.get(position).getName());

    }

    @Override
    public int getItemCount() {
        return medicineList.size();
    }


    public static class MedicineListViewHolder extends RecyclerView.ViewHolder{

        TextView tvMedicineName;
    

        public MedicineListViewHolder(@NonNull View itemView) {
            super(itemView);

            tvMedicineName = itemView.findViewById(R.id.tvMedicineName);
        }
    }
}

