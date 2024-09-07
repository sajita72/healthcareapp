package np.com.healthcareapp.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import np.com.healthcareapp.R;
import np.com.healthcareapp.model.MyBookingModel;

public class upcomminglistadapter extends RecyclerView.Adapter<upcomminglistadapter.UpcommingListViewHOlder> {
    Context context;
    //List<doctor> appointmentList;
    ArrayList<MyBookingModel.Message> bookList;
    private upcomminglistadapter.OnItemClickListener onItemClickListener;
    public upcomminglistadapter.OnCancelClickListener onCancelClickListener;
    public upcomminglistadapter.OnRescheduleClickListener onRescheduleClickListener;

    public upcomminglistadapter(Context context, ArrayList<MyBookingModel.Message> bookList){
        this.context= context;
        this.bookList= bookList;
        Log.v("appointmentsection",context + " " + String.valueOf(bookList.size()));
    }



    @NonNull
    @Override
    public upcomminglistadapter.UpcommingListViewHOlder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new UpcommingListViewHOlder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_upcoimingappoint,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull upcomminglistadapter.UpcommingListViewHOlder holder, int position) {
        holder.tvdate.setText(bookList.get(position).getDate_appointment());
        holder.tvtime.setText(bookList.get(position).getTime_appointment());
        String name = bookList.get(position).getDoctor().getName() != null ? bookList.get(position).getDoctor().getName() : "No name";
        holder.tvProductName.setText(name);
        holder.tvSpecialist.setText(bookList.get(position).getDoctor().getSpecialist());
        holder.imageView.setImageResource(R.drawable.doctor1);
        if(holder.btn1 != null){
            holder.btn1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(onCancelClickListener != null){
                        onCancelClickListener.onCancelClick(bookList.get(position).getId());
                    }
                }
            });
        }
        if(holder.btn2 != null){
            holder.btn2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(onRescheduleClickListener != null){
                        onRescheduleClickListener.onRescheduleClick(bookList.get(position).getId());
                    }
                }
            });
        }

    }

    @Override
    public int getItemCount(){
        return bookList.size();
    }

    public interface OnItemClickListener {
        void onItemCLick(String id);
    }
    public interface OnCancelClickListener{
        void onCancelClick(String id);
    }public interface OnRescheduleClickListener{
        void onRescheduleClick(String id);
    }

    public void setOnItemClickListener(upcomminglistadapter.OnItemClickListener listener){
        this.onItemClickListener = listener;
    }

    public void setOnCancelClickListener(upcomminglistadapter.OnCancelClickListener cancelListener){
        this.onCancelClickListener = cancelListener;
    }public void setOnRescheduleClickListener(upcomminglistadapter.OnRescheduleClickListener rescheduleClickListener){
        this.onRescheduleClickListener = rescheduleClickListener;
    }



    public static class UpcommingListViewHOlder extends RecyclerView.ViewHolder {

        TextView tvProductName;
        TextView tvSpecialist;
        TextView tvdate;
        TextView tvtime;
        TextView userid;
        TextView doctorid;
        ImageView imageView;
        Button btn1,btn2;

        public UpcommingListViewHOlder(@NonNull View itemView) {
            super(itemView);
            tvProductName = itemView.findViewById(R.id.tvProductName);
            tvSpecialist = itemView.findViewById(R.id.tvspecialist);
            tvdate = itemView.findViewById(R.id.tvdate);
            tvtime = itemView.findViewById(R.id.tvtime);
            imageView = itemView.findViewById(R.id.ivProduct);

            btn1 = itemView.findViewById(R.id.btncancel);
            btn2 = itemView.findViewById(R.id.btnreshedule);
        }


    }
}
