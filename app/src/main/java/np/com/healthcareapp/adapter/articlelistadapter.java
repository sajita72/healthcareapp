package np.com.healthcareapp.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import np.com.healthcareapp.R;
import np.com.healthcareapp.articlesdetail;
import np.com.healthcareapp.model.doctor;
import np.com.healthcareapp.package_detail;


public class articlelistadapter extends RecyclerView.Adapter<articlelistadapter.ArticleListViewHolder> {
protected Button btn;

    List<doctor> articleList;
    Context context;

    public articlelistadapter(List<doctor> articleList){
        this.articleList = articleList;

    }

    @NonNull
    @Override
    public ArticleListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        return new ArticleListViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_articlelist, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ArticleListViewHolder holder, int position) {
        holder.tvArticleName.setText(articleList.get(position).getName());
        holder.tvArticleSpeciality.setText(articleList.get(position).getSpeciality());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(v.getContext(), articlesdetail.class);
                intent.putExtra("name",articleList.get(position).getName());
                intent.putExtra("speciality",articleList.get(position).getSpeciality());
                v.getContext().startActivity(intent);
            }
        });


    }

    @Override
    public int getItemCount() {
        return articleList.size();
    }


    public static class ArticleListViewHolder extends RecyclerView.ViewHolder{

        TextView tvArticleName;
        TextView tvArticleSpeciality;
        TextView btnreadmore;

        public ArticleListViewHolder(@NonNull View itemView) {
            super(itemView);

            tvArticleName = itemView.findViewById(R.id.tvArticleName);
            tvArticleSpeciality = itemView.findViewById(R.id.tvArticleSpeciality);
        }
    }
}
