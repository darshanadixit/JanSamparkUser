package in.darshana.jansampark.fragments;

import android.os.Bundle;
import android.os.Handler;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.LinearSmoothScroller;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import in.darshana.jansampark.R;
import in.darshana.jansampark.adapters.NewsAdapter;
import in.darshana.jansampark.adapters.NewsModelAdapter;
import in.darshana.jansampark.model.News;
import in.darshana.jansampark.model.NewsModel;

public class NewsFragment extends Fragment {
    View view;
    private RecyclerView mRecyclerViewNews;
    private ArrayList<NewsModel> mNewsModelArrayList;
    NewsModelAdapter mNewsModelAdapter;
    LinearLayoutManager linearLayoutManager;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.news_fragment,container,false);

        init();
        return view;
    }

    private void init() {
        //news recyclerview
        mRecyclerViewNews = view.findViewById(R.id.recyclerviewNewsFragment);

        mNewsModelArrayList = new ArrayList<>();
        mNewsModelArrayList.add(new NewsModel("Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum."
            ,R.drawable.ic_baseline_android_orange_24
        ));

        mNewsModelArrayList.add(new NewsModel("Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum."
            , R.drawable.ic_baseline_android_orange_24
        ));

        mNewsModelArrayList.add(new NewsModel("Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum."
            ,R.drawable.ic_baseline_favorite_24
        ));

        mNewsModelAdapter = new NewsModelAdapter(getActivity(), mNewsModelArrayList);

        linearLayoutManager = new LinearLayoutManager(getActivity(),LinearLayoutManager.VERTICAL,false);

        mRecyclerViewNews.setLayoutManager(linearLayoutManager);
        mRecyclerViewNews.setAdapter(mNewsModelAdapter);

    }

}

