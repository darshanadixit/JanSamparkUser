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

import in.darshana.jansampark.R;
import in.darshana.jansampark.model.News;
import in.darshana.jansampark.model.NewsModel;

public class NewsModelAdapter extends RecyclerView.Adapter<NewsModelAdapter.Viewholder> {
    private Context mContext;
    private ArrayList<NewsModel> mNewsModelArrayList;

    public NewsModelAdapter(Context mContext, ArrayList<NewsModel> mNewsModelArrayList) {
        this.mContext = mContext;
        this.mNewsModelArrayList = mNewsModelArrayList;
    }

    @NonNull
    @Override
    public NewsModelAdapter.Viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_news_fragment,parent,false);
        return new Viewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull NewsModelAdapter.Viewholder holder, int position) {
        NewsModel mNews = mNewsModelArrayList.get(position);
        holder.newsText.setText(mNews.getmNews());
        holder.newsImg.setImageResource(mNews.getmNewsImg());
    }

    @Override
    public int getItemCount() {
        return mNewsModelArrayList.size();
    }

    public class Viewholder extends RecyclerView.ViewHolder {
        private TextView newsText;
        private ImageView newsImg;
        public Viewholder(@NonNull View itemView) {
            super(itemView);
            newsText = itemView.findViewById(R.id.txtviewNewsFragment);
            newsImg = itemView.findViewById(R.id.imgNewsFragment);
        }
    }
}
