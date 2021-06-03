package in.darshana.jansampark.fragments;


import android.os.Bundle;
import android.os.Handler;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.LinearSmoothScroller;
import androidx.recyclerview.widget.RecyclerView;

import com.smarteist.autoimageslider.SliderView;
import java.util.ArrayList;

import in.darshana.jansampark.R;
import in.darshana.jansampark.adapters.ImageSliderAdapter;
import in.darshana.jansampark.adapters.NewsAdapter;
import in.darshana.jansampark.model.ImageSlider;
import in.darshana.jansampark.model.News;

public class DashboardFragment extends Fragment {
    View mView;
    String url1 = "https://i.picsum.photos/id/10/2500/1667.jpg?hmac=J04WWC_ebchx3WwzbM-Z4_KC_LeLBWr5LZMaAkWkF68";
    String url2 = "https://i.picsum.photos/id/1/5616/3744.jpg?hmac=kKHwwU8s46oNettHKwJ24qOlIAsWN9d2TtsXDoCWWsQ";
    String url3 = "https://i.picsum.photos/id/0/5616/3744.jpg?hmac=3GAAioiQziMGEtLbfrdbcoenXoWAW-zlyEAMkfEdBzQ";

    ArrayList<ImageSlider> mSliderImageArrayList;
    SliderView mSliderView;
    ImageSliderAdapter mSliderImageAdapter;
    ImageView mImageHome,mImageWork,mImageComplaint,mImageContactus;
    ImageView mImageCampaign,mImageProfile;
    CardView mCardViewContactus,mCardViewNews,mCardViewAboutus, mCardViewComplaint;
    CardView mCardViewWork,mCardViewGovSchemes;

    private RecyclerView mRecyclerViewNews;
    private ArrayList<News> mNewsArrayList;
    NewsAdapter mNewsAdapter;
    LinearLayoutManager linearLayoutManager;
    int scrollCount = 0;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mView = inflater.inflate(R.layout.dashboard_fragment,container,false);
        init();
        return mView;
    }

    private void init() {
        mSliderImageArrayList = new ArrayList<>();

        mSliderView = mView.findViewById(R.id.sliderview);

        mSliderImageArrayList.add(new ImageSlider(url1));
        mSliderImageArrayList.add(new ImageSlider(url2));
        mSliderImageArrayList.add(new ImageSlider(url3));

        mImageHome = mView.findViewById(R.id.img_Home);
        mImageProfile = mView.findViewById(R.id.img_Person);
        mImageWork = mView.findViewById(R.id.img_Work);
        mImageComplaint = mView.findViewById(R.id.img_Complaint);
        mImageCampaign = mView.findViewById(R.id.img_Campaign);
        mImageContactus = mView.findViewById(R.id.img_ContactUs);

        mCardViewContactus = mView.findViewById(R.id.cardview_contactus);
        mCardViewNews = mView.findViewById(R.id.cardview_news);

        mCardViewContactus.setOnClickListener(new ContactUsCardViewClickListener());
        mCardViewNews.setOnClickListener(new NewsCardViewClickListener());

        mCardViewAboutus = mView.findViewById(R.id.cardview_aboutus);
        mCardViewAboutus.setOnClickListener(new AboutusCardViewClickListener());

        mCardViewComplaint = mView.findViewById(R.id.cardview_complaint);
        mCardViewComplaint.setOnClickListener(new ComplaintCardViewClickListener());

        mCardViewWork = mView.findViewById(R.id.cardview_work);
        mCardViewWork.setOnClickListener(new WorkCardViewClickListener());

        mCardViewGovSchemes = mView.findViewById(R.id.cardview_govschemes);
        mCardViewGovSchemes.setOnClickListener(new GovSchemesCardViewClickListener());





        mSliderImageAdapter = new ImageSliderAdapter(getActivity(), mSliderImageArrayList);

        mSliderView.setAutoCycleDirection(SliderView.LAYOUT_DIRECTION_LTR);

        mSliderView.setSliderAdapter(mSliderImageAdapter);

        mSliderView.setScrollTimeInSec(3);

        mSliderView.startAutoCycle();

        //news recyclerview
        mRecyclerViewNews = mView.findViewById(R.id.recyclerviewNews);

        mNewsArrayList = new ArrayList<>();
        mNewsArrayList.add(new News("Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum."

        ));

        mNewsArrayList.add(new News("Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum."

        ));

        mNewsArrayList.add(new News("Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum."

        ));

        mNewsAdapter = new NewsAdapter(getActivity(),mNewsArrayList);

        //linearLayoutManager = new LinearLayoutManager(getActivity(),LinearLayoutManager.HORIZONTAL,false);

        //mRecyclerViewNews.setLayoutManager(linearLayoutManager);
        //mRecyclerViewNews.setAdapter(mNewsAdapter);

         linearLayoutManager = new LinearLayoutManager(getActivity()) {

            @Override
            public void smoothScrollToPosition(RecyclerView recyclerView, RecyclerView.State state, int position) {
                LinearSmoothScroller smoothScroller = new LinearSmoothScroller(getActivity()) {
                    private static final float SPEED = 2500f;// Change this value (default=25f)

                    @Override
                    protected float calculateSpeedPerPixel(DisplayMetrics displayMetrics) {
                        return SPEED / displayMetrics.densityDpi;
                    }
                };
                smoothScroller.setTargetPosition(position);
                startSmoothScroll(smoothScroller);
            }
        };

        autoScrollAnother();
        linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        mRecyclerViewNews.setLayoutManager(linearLayoutManager);
        mRecyclerViewNews.setAdapter(mNewsAdapter);

    }

    private void autoScrollAnother() {
        scrollCount = 0;
        final Handler handler = new Handler();
        final Runnable runnable = new Runnable() {
            @Override
            public void run() {
                mRecyclerViewNews.smoothScrollToPosition((scrollCount++));
                if (scrollCount == mNewsAdapter.getItemCount()) {
                    mNewsArrayList.addAll(mNewsArrayList);
                    mNewsAdapter.notifyDataSetChanged();
                }
                handler.postDelayed(this, 2000);
            }
        };
        handler.postDelayed(runnable, 2000);
    }


    private class ContactUsCardViewClickListener implements View.OnClickListener {
        @Override
        public void onClick(View view) {
            Fragment mFragment = new ContactUsFragment();
            if(mFragment != null){
                FragmentTransaction ft = getParentFragmentManager().beginTransaction();
                ft.replace(R.id.containerNew, mFragment).addToBackStack("");
                ft.commit();
            }
        }
    }

    private class NewsCardViewClickListener implements View.OnClickListener {
        @Override
        public void onClick(View view) {
            Fragment mFragment = new NewsFragment();
            if(mFragment != null){
                FragmentTransaction ft = getParentFragmentManager().beginTransaction();
                ft.replace(R.id.containerNew, mFragment).addToBackStack("");
                ft.commit();
            }
        }
    }

    private class AboutusCardViewClickListener implements View.OnClickListener {
        @Override
        public void onClick(View view) {
            Fragment mFragment = new AboutusFragment();
            if(mFragment != null){
                FragmentTransaction ft = getParentFragmentManager().beginTransaction();
                ft.replace(R.id.containerNew, mFragment).addToBackStack("");
                ft.commit();
            }
        }
    }

    private class ComplaintCardViewClickListener implements View.OnClickListener {
        @Override
        public void onClick(View view) {
            Fragment mFragment = new ComplaintFragment();
            if(mFragment != null){
                FragmentTransaction ft = getParentFragmentManager().beginTransaction();
                ft.replace(R.id.containerNew, mFragment).addToBackStack("");
                ft.commit();
            }
        }
    }

    private class WorkCardViewClickListener implements View.OnClickListener {
        @Override
        public void onClick(View view) {
            Fragment mFragment = new WorkFragment();
            if(mFragment != null){
                FragmentTransaction ft = getParentFragmentManager().beginTransaction();
                ft.replace(R.id.containerNew, mFragment).addToBackStack("");
                ft.commit();
            }
        }
    }

    private class GovSchemesCardViewClickListener implements View.OnClickListener {
        @Override
        public void onClick(View view) {
            Fragment mFragment = new GovSchemeFragment();
            if(mFragment != null){
                FragmentTransaction ft = getParentFragmentManager().beginTransaction();
                ft.replace(R.id.containerNew, mFragment).addToBackStack("");
                ft.commit();
            }
        }
    }
}
