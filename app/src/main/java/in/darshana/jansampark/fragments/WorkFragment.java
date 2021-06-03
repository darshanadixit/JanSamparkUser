package in.darshana.jansampark.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import in.darshana.jansampark.R;
import in.darshana.jansampark.adapters.NewsModelAdapter;
import in.darshana.jansampark.adapters.WorkAdapter;
import in.darshana.jansampark.model.NewsModel;
import in.darshana.jansampark.model.WorkModel;

public class WorkFragment extends Fragment {
    View view;
    private RecyclerView mRecyclerViewWork;
    private ArrayList<WorkModel> mWorkModelArrayList;
    WorkAdapter mWorkAdapter;
    LinearLayoutManager linearLayoutManager;

    String url1 = "https://i.picsum.photos/id/10/2500/1667.jpg?hmac=J04WWC_ebchx3WwzbM-Z4_KC_LeLBWr5LZMaAkWkF68";
    String url2 = "https://i.picsum.photos/id/1/5616/3744.jpg?hmac=kKHwwU8s46oNettHKwJ24qOlIAsWN9d2TtsXDoCWWsQ";
    String url3 = "https://i.picsum.photos/id/0/5616/3744.jpg?hmac=3GAAioiQziMGEtLbfrdbcoenXoWAW-zlyEAMkfEdBzQ";

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.work_fragment,container,false);
        init();
        return view;
    }

    private void init() {
        mRecyclerViewWork = view.findViewById(R.id.recyclerviewWorkFragment);

        mWorkModelArrayList = new ArrayList<>();
        mWorkModelArrayList.add(new WorkModel(url1,"Work Title 1",
                "\"Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua."));

        mWorkModelArrayList.add(new WorkModel(url2,"Work Title 2",
                "\"Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua."));

        mWorkModelArrayList.add(new WorkModel(url3,"Work Title 3",
                "\"Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua."));

        mWorkModelArrayList.add(new WorkModel(url1,"Work Title 4",
                "\"Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua."));

        mWorkModelArrayList.add(new WorkModel(url2,"Work Title 5",
                "\"Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua."));

        mWorkModelArrayList.add(new WorkModel(url3,"Work Title 6",
                "\"Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua."));

        mWorkAdapter = new WorkAdapter(getActivity(),mWorkModelArrayList);

        linearLayoutManager = new LinearLayoutManager(getActivity(),LinearLayoutManager.VERTICAL,false);

        mRecyclerViewWork.setLayoutManager(linearLayoutManager);
        mRecyclerViewWork.setAdapter(mWorkAdapter);
    }
}
