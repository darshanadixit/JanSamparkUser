package in.darshana.jansampark.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;

import in.darshana.jansampark.R;


public class ProfileFragment extends Fragment {
    AutoCompleteTextView mAutoCompleteTextViewGender;
    View view;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.fragment_profile, container, false);
        init();
        return view;
    }

    private void init() {
        mAutoCompleteTextViewGender = view.findViewById(R.id.autoCompleteProfileGender);

        String[] types = getResources().getStringArray(R.array.gender);
        ArrayAdapter adapter = new ArrayAdapter(requireContext(),R.layout.dropdown_menu_complaint_type,types);
        mAutoCompleteTextViewGender.setAdapter(adapter);
    }
}