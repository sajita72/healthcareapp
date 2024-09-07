package np.com.healthcareapp.adapter;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import np.com.healthcareapp.R;
import np.com.healthcareapp.medicine_detail;
import np.com.healthcareapp.model.doctor;


public class medicinelistadapter extends RecyclerView.Adapter<medicinelistadapter.MedicineListViewHolder> {

    List<doctor> medicineList;
    Context context;

    public medicinelistadapter(Context context,List<doctor> medicineList){
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
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), medicine_detail.class);
                intent.putExtra("name",medicineList.get(position).getName());
                intent.putExtra("speciality",medicineList.get(position).getSpeciality());
                intent.putExtra("price",medicineList.get(position).getPrice());
                v.getContext().startActivity(intent);

                //sideeffectchaipricemahunxa
            }
        });

    }

    @Override
    public int getItemCount() {
        return medicineList.size();
    }


    public static class MedicineListViewHolder extends RecyclerView.ViewHolder{

        TextView tvMedicineName,tvMedicineDescription,tvsideeffect;
    

        public MedicineListViewHolder(@NonNull View itemView) {
            super(itemView);

            tvMedicineName = itemView.findViewById(R.id.tvMedicineName);
            tvMedicineDescription = itemView.findViewById(R.id.description);
            tvsideeffect = itemView.findViewById(R.id.tvsideeffect);
        }
    }
}

