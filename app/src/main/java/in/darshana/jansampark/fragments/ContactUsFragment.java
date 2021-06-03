package in.darshana.jansampark.fragments;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import in.darshana.jansampark.R;

public class ContactUsFragment extends Fragment {
    ImageView mImageViewCall;
    View view;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.contact_us_fragment,container,false);
        init();
        return view;
    }

    private void init() {
        mImageViewCall = view.findViewById(R.id.imgCallIconContactus);

        mImageViewCall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent callIntent = new Intent(Intent.ACTION_DIAL);
                callIntent.setData(Uri.parse("tel: 8888888888"));
                startActivity(callIntent);
            }
        });
    }
}
