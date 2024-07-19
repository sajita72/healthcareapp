package np.com.healthcareapp.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import np.com.healthcareapp.R;
import np.com.healthcareapp.model.doctor;
import np.com.healthcareapp.package_detail;


public class packagelistadapter extends RecyclerView.Adapter<packagelistadapter.PackageListViewHolder> {

    Context context;
    List<doctor> packageList;



    public packagelistadapter( Context context, List<doctor> packageList){
        this.packageList = packageList;

    }




    @NonNull
    @Override
    public PackageListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        return new PackageListViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_packagelist, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull PackageListViewHolder holder, int position) {
        holder.tvPackageName.setText(packageList.get(position).getName());
        holder.tvPackagePrice.setText(packageList.get(position).getSpeciality());

holder.itemView.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        Intent intent = new Intent(v.getContext(), package_detail.class);
        intent.putExtra("name",packageList.get(position).getName());
        intent.putExtra("description",packageList.get(position).getDescription());
        v.getContext().startActivity(intent);

    }
});



    }

    @Override
    public int getItemCount() {
        return packageList.size();
    }


    public static class PackageListViewHolder extends RecyclerView.ViewHolder{

        TextView tvPackageName;
        TextView tvPackagePrice;

        TextView description;

        public PackageListViewHolder(@NonNull View itemView) {
            super(itemView);

            tvPackageName = itemView.findViewById(R.id.tvPackageName);
            tvPackagePrice = itemView.findViewById(R.id.tvPackagePrice);
            description = itemView.findViewById(R.id.description);



        }
    }
}
