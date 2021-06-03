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
import in.darshana.jansampark.adapters.GovSchemeAdapter;
import in.darshana.jansampark.adapters.WorkAdapter;
import in.darshana.jansampark.model.GovScheme;
import in.darshana.jansampark.model.WorkModel;

public class GovSchemeFragment extends Fragment {
    View view;
    private RecyclerView mRecyclerViewGovScheme;
    private ArrayList<GovScheme> mGovSchemeArrayList ;
    GovSchemeAdapter mGovSchemeAdapter;
    LinearLayoutManager linearLayoutManager;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
       view = inflater.inflate(R.layout.scheme_fragment,container,false);
       init();
       return view;
    }

    private void init() {
        mRecyclerViewGovScheme = view.findViewById(R.id.recyclerviewSchemeFragment);

        mGovSchemeArrayList = new ArrayList<>();
        mGovSchemeArrayList.add(new GovScheme("Covid-19 Vaccination Camp"));
        mGovSchemeArrayList.add(new GovScheme("Girl Child Education"));
        mGovSchemeArrayList.add(new GovScheme("PM Jandhan Yojana"));
        mGovSchemeArrayList.add(new GovScheme("Ujawala Yojana"));
        mGovSchemeArrayList.add(new GovScheme("Manarega Yojana"));
        mGovSchemeArrayList.add(new GovScheme("Covid-19 Vaccination Camp"));
        mGovSchemeArrayList.add(new GovScheme("Girl Child Education"));
        mGovSchemeArrayList.add(new GovScheme("PM Jandhan Yojana"));
        mGovSchemeArrayList.add(new GovScheme("Ujawala Yojana"));
        mGovSchemeArrayList.add(new GovScheme("Manarega Yojana"));

        mGovSchemeAdapter = new GovSchemeAdapter(getActivity(),mGovSchemeArrayList);

        linearLayoutManager = new LinearLayoutManager(getActivity(),LinearLayoutManager.VERTICAL,false);

        mRecyclerViewGovScheme.setLayoutManager(linearLayoutManager);
        mRecyclerViewGovScheme.setAdapter(mGovSchemeAdapter);
    }
}
