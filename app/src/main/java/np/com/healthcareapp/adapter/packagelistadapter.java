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


public class packagelistadapter extends RecyclerView.Adapter<packagelistadapter.PackageListViewHolder> {

    List<doctor> packageList;
    Context context;

    public packagelistadapter(List<doctor> packageList){
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
    }

    @Override
    public int getItemCount() {
        return packageList.size();
    }


    public static class PackageListViewHolder extends RecyclerView.ViewHolder{

        TextView tvPackageName;
        TextView tvPackagePrice;

        public PackageListViewHolder(@NonNull View itemView) {
            super(itemView);

            tvPackageName = itemView.findViewById(R.id.tvPackageName);
            tvPackagePrice = itemView.findViewById(R.id.tvPackagePrice);
        }
    }
}
