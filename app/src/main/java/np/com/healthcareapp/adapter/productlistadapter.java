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


import java.util.List;

import np.com.healthcareapp.R;
import np.com.healthcareapp.doctordetail;
import np.com.healthcareapp.model.doctor;
import np.com.healthcareapp.package_detail;


public class productlistadapter extends RecyclerView.Adapter<productlistadapter.ProductListViewHolder>{

    List<doctor> productList;

    Context context;

    public productlistadapter(Context context,List<doctor> productList){
        this.productList = productList;

    }

    @NonNull
    @Override
    public ProductListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        return new ProductListViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_doctorlist,parent, false
        ));
    }

    @Override
    public void onBindViewHolder(@NonNull ProductListViewHolder holder, int position) {

        holder.tvProductName.setText(productList.get(position).getName());
        holder.tvProductSpeciality.setText(productList.get(position).getSpeciality());
        holder.tvProductDegree.setText(productList.get(position).getDegree());


        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), doctordetail.class);
                intent.putExtra("name",productList.get(position).getName());
                intent.putExtra("speciality",productList.get(position).getSpeciality());
                intent.putExtra("degree",productList.get(position).getDegree());
                intent.putExtra("description",productList.get(position).getDescription());
                v.getContext().startActivity(intent);
            }
        });


//        ImageLoader imageLoader = coil.imageLoader(context);
//        ImageRequest request = new ImageRequest.Builder(context)
//                .data(productList.get(position).getImage())
//                .crossfade(true)
//                .target(holder.ivProduct)
//                .build();
//        imageLoader.enqueue(request);
//        holder.tvProductName.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(ProductListAdapter.this, doctordetail.class);
//                startActivity(intent);
//            }
//        });
    }

    @Override
    public int getItemCount() {
        return productList.size();
    }

    public static class ProductListViewHolder extends RecyclerView.ViewHolder{

        //Doctor
        TextView tvProductName;
        TextView tvProductSpeciality;
        TextView tvProductDegree;
        ImageView ivProduct;

        public  ProductListViewHolder(@NonNull View itemView) {
            super(itemView);
            //doctor
            tvProductName = itemView.findViewById(R.id.tvProductName);
            tvProductSpeciality = itemView.findViewById(R.id.tvProductSpeciality);
            tvProductDegree = itemView.findViewById(R.id.tvProductDegree);
            ivProduct = itemView.findViewById(R.id.ivProduct);


        }
    }
}
