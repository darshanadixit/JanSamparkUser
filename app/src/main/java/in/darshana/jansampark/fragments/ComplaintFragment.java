package in.darshana.jansampark.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import in.darshana.jansampark.R;

public class ComplaintFragment extends Fragment {
    AutoCompleteTextView mAutoCompleteTextViewComplaintType;
    View view;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
       view = inflater.inflate(R.layout.complaint_fragment,container,false);
       init();
       return view;
    }

    private void init() {
        mAutoCompleteTextViewComplaintType = view.findViewById(R.id.autoCompleteComplaintType);

        String[] types = getResources().getStringArray(R.array.complaint_type);
        ArrayAdapter adapter = new ArrayAdapter(requireContext(),R.layout.dropdown_menu,types);
        mAutoCompleteTextViewComplaintType.setAdapter(adapter);
    }
}
