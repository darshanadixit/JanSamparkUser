package in.darshana.jansampark.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import in.darshana.jansampark.R;



public class SchemeDetailsFragment extends Fragment {
    private TextView mtxtViewSchemeDetails;
    View view;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view= inflater.inflate(R.layout.fragment_scheme_details, container, false);

        mtxtViewSchemeDetails = view.findViewById(R.id.txtviewSchemeDetails);
        return view;
    }
}