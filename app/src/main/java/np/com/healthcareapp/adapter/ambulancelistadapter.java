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


public class ambulancelistadapter extends RecyclerView.Adapter<ambulancelistadapter.AmbulanceListViewHolder> {

    List<doctor> ambulanceList;
    Context context;

    public ambulancelistadapter(List<doctor> ambulanceList){
        this.ambulanceList = ambulanceList;

    }

    @NonNull
    @Override
    public AmbulanceListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        return new AmbulanceListViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_ambulancelist, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull AmbulanceListViewHolder holder, int position) {
        holder.tvLocationName.setText(ambulanceList.get(position).getName());
        holder.tvServiceArea.setText(ambulanceList.get(position).getLocation());
      //  holder.tvPhoneNumber.setText(ambulanceList.get(position).getNumber());


    }

    @Override
    public int getItemCount() {
        return ambulanceList.size();
    }


    public static class AmbulanceListViewHolder extends RecyclerView.ViewHolder{

        TextView tvLocationName;
        TextView tvServiceArea;
       // TextView tvPhoneNumber;
        ImageView ivAmb1;
        ImageView ivAmb2;
        //ImageView ivAmb3;

        public AmbulanceListViewHolder(@NonNull View itemView) {
            super(itemView);

            tvLocationName = itemView.findViewById(R.id.tvLocationName);
            tvServiceArea = itemView.findViewById(R.id.tvServiceArea);
          //  tvPhoneNumber = itemView.findViewById(R.id.tvPhoneNumber);
            ivAmb1 = itemView.findViewById(R.id.ivAmb1);
            ivAmb2 = itemView.findViewById(R.id.ivAmb2);
          //  ivAmb3 = itemView.findViewById(R.id.ivAmb3);
        }
    }
}
