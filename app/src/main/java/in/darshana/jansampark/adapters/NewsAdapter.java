package in.darshana.jansampark.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import in.darshana.jansampark.R;
import in.darshana.jansampark.model.News;

public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.Viewholder> {
    private Context mContext;
    private ArrayList<News> mNewsArrayList;

    public NewsAdapter(Context mContext, ArrayList<News> mNewsArrayList) {
        this.mContext = mContext;
        this.mNewsArrayList = mNewsArrayList;
    }

    @NonNull
    @Override
    public NewsAdapter.Viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_news,parent,false);
        return new Viewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull NewsAdapter.Viewholder holder, int position) {
        News mNews = mNewsArrayList.get(position);
        holder.newsText.setText(mNews.getmNews());
        //holder.newsImg.setImageResource(mNews.getmNewsImg());
    }

    @Override
    public int getItemCount() {
        return mNewsArrayList.size();
    }

    public class Viewholder extends RecyclerView.ViewHolder {
        private TextView newsText;
        //private ImageView newsImg;
        public Viewholder(@NonNull View itemView) {
            super(itemView);
            newsText = itemView.findViewById(R.id.txtviewNews);
            //newsImg = itemView.findViewById(R.id.imgNews);
        }
    }
}
