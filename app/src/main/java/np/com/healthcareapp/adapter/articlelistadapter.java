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


public class articlelistadapter extends RecyclerView.Adapter<articlelistadapter.ArticleListViewHolder> {

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

    }

    @Override
    public int getItemCount() {
        return articleList.size();
    }


    public static class ArticleListViewHolder extends RecyclerView.ViewHolder{

        TextView tvArticleName;
        TextView tvArticleSpeciality;

        public ArticleListViewHolder(@NonNull View itemView) {
            super(itemView);

            tvArticleName = itemView.findViewById(R.id.tvArticleName);
            tvArticleSpeciality = itemView.findViewById(R.id.tvArticleSpeciality);
        }
    }
}
