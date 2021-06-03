package in.darshana.jansampark.adapters;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import in.darshana.jansampark.R;
import in.darshana.jansampark.fragments.GovSchemeFragment;
import in.darshana.jansampark.fragments.SchemeDetailsFragment;
import in.darshana.jansampark.model.GovScheme;
import in.darshana.jansampark.model.WorkModel;

public class GovSchemeAdapter extends RecyclerView.Adapter<GovSchemeAdapter.Viewholder> {
    private Context mContext;
    private ArrayList<GovScheme> mGovSchemeArrayList;
    /*private RecyclerViewClickListener mRecyclerViewClickListener;

    public GovSchemeAdapter(ArrayList<GovScheme> mGovSchemeArrayList,RecyclerViewClickListener mRecyclerViewClickListener) {
        this.mGovSchemeArrayList = mGovSchemeArrayList;
        this.mRecyclerViewClickListener = mRecyclerViewClickListener;
    }*/

    public GovSchemeAdapter(Context mContext, ArrayList<GovScheme> mGovSchemeArrayList) {
        this.mContext = mContext;
        this.mGovSchemeArrayList = mGovSchemeArrayList;
    }

    @NonNull
    @Override
    public GovSchemeAdapter.Viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_schemes, parent, false);
        return new Viewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull GovSchemeAdapter.Viewholder holder, int position) {
        GovScheme mGovScheme = mGovSchemeArrayList.get(position);
        holder.mSchemeTitle.setText(mGovScheme.getmSchemeTitle());

        holder.mButtonMoreInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AppCompatActivity activity = (AppCompatActivity) view.getContext();
                SchemeDetailsFragment mSchemeDetailsFragment = new SchemeDetailsFragment();
                activity.getSupportFragmentManager().beginTransaction().replace(R.id.containerNew, mSchemeDetailsFragment).addToBackStack(null).commit();

            }
        });

    }

    @Override
    public int getItemCount() {
        return mGovSchemeArrayList.size();
    }

    public class Viewholder extends RecyclerView.ViewHolder {
        private TextView mSchemeTitle;
        private Button mButtonMoreInfo;

        public Viewholder(@NonNull View itemView) {
            super(itemView);
            mSchemeTitle = itemView.findViewById(R.id.txtviewSchemeTitle);
            mButtonMoreInfo = itemView.findViewById(R.id.btn_more_info_schemes);
            //itemView.setOnClickListener(this);
        }


       /* @Override
        public void onClick(View view) {
            mRecyclerViewClickListener.onClick(view, position);
        }*/
    }

    /*public interface RecyclerViewClickListener{
        void onClick(View v, int Postion);
    }

    public void setmRecyclerViewClickListener(RecyclerViewClickListener mRecyclerViewClickListener) {
        this.mRecyclerViewClickListener = mRecyclerViewClickListener;
    }*/
}