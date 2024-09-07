package np.com.healthcareapp.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import java.util.ArrayList;
import java.util.List;

import np.com.healthcareapp.R;
import np.com.healthcareapp.doctordetail;
import np.com.healthcareapp.model.DoctorModel;
import np.com.healthcareapp.model.doctor;
import np.com.healthcareapp.package_detail;


public class productlistadapter extends RecyclerView.Adapter<productlistadapter.ProductListViewHolder>{
    Context context;
    List<doctor> productList;
    ArrayList<DoctorModel.Doctors> originalArray;

    ArrayList<DoctorModel.Doctors> filterArray;
    private productlistadapter.OnItemClickListener onItemClickListener;

    public productlistadapter(Context context, ArrayList<DoctorModel.Doctors> originalArray) {
        this.context = context;
        this.originalArray = originalArray;
        this.filterArray = new ArrayList<>(originalArray);
    }


    @NonNull
    @Override
    public ProductListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ProductListViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_doctorlist,parent, false
        ));
    }





    @Override
    public void onBindViewHolder(@NonNull ProductListViewHolder holder, int position) {
        DoctorModel.Doctors currentDoctor = filterArray.get(position);
        holder.tvProductName.setText(currentDoctor.getName());
        holder.tvProductSpeciality.setText(currentDoctor.getSpecialist());
        holder.tvProductDegree.setText(currentDoctor.getDescription());
        holder.ivProduct.setImageResource(R.drawable.doctor1);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (onItemClickListener != null) {
                    onItemClickListener.onItemClick(currentDoctor.getId(),currentDoctor.getName(),currentDoctor.getSpecialist(),currentDoctor.getDescription());
                }
            }
        });
    }

    public void filter(String text){
        filterArray.clear();
        text = text.toLowerCase();
        for (DoctorModel.Doctors doctor: originalArray){
            String name = doctor.getName() != null ? doctor.getName().toLowerCase() : "";
            String specialist = doctor.getSpecialist() != null ? doctor.getSpecialist().toLowerCase() : "";
            String degree = doctor.getDescription() != null ? doctor.getDescription().toLowerCase() : "";
            if(name.contains(text) || specialist.contains(text) || degree.contains(text)){
                filterArray.add(doctor);
            }
            notifyDataSetChanged();
        }
    }

    @Override
    public int getItemCount() {
        return filterArray.size();
    }

    public static class ProductListViewHolder extends RecyclerView.ViewHolder{
        TextView tvProductName;
        TextView tvProductSpeciality;
        TextView tvProductDegree;
        ImageView ivProduct;

        public  ProductListViewHolder(@NonNull View itemView) {
            super(itemView);
            tvProductName = itemView.findViewById(R.id.tvProductName);
            tvProductSpeciality = itemView.findViewById(R.id.tvProductSpeciality);
            tvProductDegree = itemView.findViewById(R.id.tvProductDegree);
            ivProduct = itemView.findViewById(R.id.ivProduct);
        }
    }

   public interface OnItemClickListener{
        void onItemClick(String id, String name, String specialist, String degree);
   }
    public void setOnItemClickListener(productlistadapter.OnItemClickListener listener){
        this.onItemClickListener = listener;
    }

}
