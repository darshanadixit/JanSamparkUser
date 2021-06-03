package in.darshana.jansampark.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.smarteist.autoimageslider.SliderViewAdapter;

import java.util.List;

import in.darshana.jansampark.R;
import in.darshana.jansampark.model.ImageSlider;

public class ImageSliderAdapter extends SliderViewAdapter<ImageSliderAdapter.SliderAdapterViewHolder> {

        private final List<ImageSlider> mSliderImageDataList;
        private Context mContext;

        public ImageSliderAdapter(Context mContext, List<ImageSlider> mSliderImageDataList) {
            this.mContext = mContext;
            this.mSliderImageDataList = mSliderImageDataList;
        }

        @Override
        public SliderAdapterViewHolder onCreateViewHolder(ViewGroup parent) {
            View view = LayoutInflater.from(mContext).inflate(R.layout.slider_image_data,null);
            return new SliderAdapterViewHolder(view);
        }

        @Override
        public void onBindViewHolder(SliderAdapterViewHolder viewHolder, int position) {
            final ImageSlider mSliderImageItems = mSliderImageDataList.get(position);

            Glide.with(viewHolder.itemView)
                    .load(mSliderImageItems.getmImageUrl())
                    .fitCenter()
                    .into(viewHolder.imageViewBackground);
        }

        @Override
        public int getCount() {
            return  mSliderImageDataList.size();
        }

        public class SliderAdapterViewHolder extends SliderViewAdapter.ViewHolder {
            private ImageView imageViewBackground;
            private View mItemView;


            public SliderAdapterViewHolder(View itemView) {
                super(itemView);
                imageViewBackground = itemView.findViewById(R.id.myimage);
                this.mItemView = itemView;
            }
        }
    }

