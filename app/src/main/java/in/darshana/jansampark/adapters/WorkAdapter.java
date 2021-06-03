package in.darshana.jansampark.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

import in.darshana.jansampark.R;

import in.darshana.jansampark.model.WorkModel;

public class WorkAdapter extends RecyclerView.Adapter<WorkAdapter.Viewholder> {
    private Context mContext;
    private ArrayList<WorkModel> mWorkModelArrayList;


    public WorkAdapter(Context mContext, ArrayList<WorkModel> mWorkModelArrayList) {
        this.mContext = mContext;
        this.mWorkModelArrayList = mWorkModelArrayList;
    }

    @NonNull
    @Override
    public WorkAdapter.Viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_work_fragment,parent,false);
        return new Viewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull WorkAdapter.Viewholder holder, int position) {
        WorkModel mWorkModel = mWorkModelArrayList.get(position);

        holder.workTitle.setText(mWorkModel.getmWorkTitleText());
        holder.workMainText.setText(mWorkModel.getmWorkMainText());

        Glide.with(holder.itemView).load(mWorkModel.getmWorkImageUrl())
                .fitCenter()
                .into(holder.workImage);
    }

    @Override
    public int getItemCount() {
        return mWorkModelArrayList.size();
    }

    public class Viewholder extends RecyclerView.ViewHolder {
        private ImageView workImage;
        private TextView workTitle, workMainText;
        public Viewholder(@NonNull View itemView) {
            super(itemView);
            workImage = itemView.findViewById(R.id.img_Work);
            workTitle = itemView.findViewById(R.id.txtviewWorkTitle);
            workMainText = itemView.findViewById(R.id.txtviewWorkMain);

        }
    }
}
