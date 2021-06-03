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
import in.darshana.jansampark.adapters.NotificationAdapter;
import in.darshana.jansampark.model.Notifications;

public class NotificationFragment extends Fragment {
    private RecyclerView mRecyclerViewNotification;
    View mView;

    // Arraylist for storing data
    private ArrayList<Notifications> mNotificationsArrayList;

    NotificationAdapter mNotificationAdapter;
    LinearLayoutManager linearLayoutManager;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
      mView = inflater.inflate(R.layout.notification_fragment,container,false);

        init();
        return mView;
    }

    private void init() {
        mRecyclerViewNotification = mView.findViewById(R.id.recyclerviewNotifications);

        mNotificationsArrayList = new ArrayList<>();
        mNotificationsArrayList.add(new Notifications("Notification1", R.drawable.ic_baseline_notifications_black_24));
        mNotificationsArrayList.add(new Notifications("Notification2", R.drawable.ic_baseline_notifications_black_24));
        mNotificationsArrayList.add(new Notifications("Notification3", R.drawable.ic_baseline_notifications_black_24));
        mNotificationsArrayList.add(new Notifications("Notification4", R.drawable.ic_baseline_notifications_black_24));
        mNotificationsArrayList.add(new Notifications("Notification5", R.drawable.ic_baseline_notifications_black_24));
        mNotificationsArrayList.add(new Notifications("Notification6", R.drawable.ic_baseline_notifications_black_24));
        mNotificationsArrayList.add(new Notifications("Notification7", R.drawable.ic_baseline_notifications_black_24));
        mNotificationsArrayList.add(new Notifications("Notification8", R.drawable.ic_baseline_notifications_black_24));

        // we are initializing our adapter class and passing our arraylist to it.
        mNotificationAdapter = new NotificationAdapter(getActivity(), mNotificationsArrayList);

        // below line is for setting a layout manager for our recycler view.
        // here we are creating vertical list so we will provide orientation as vertical
        linearLayoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false);

        // in below two lines we are setting layoutmanager and adapter to our recycler view.
        mRecyclerViewNotification.setLayoutManager(linearLayoutManager);
        mRecyclerViewNotification.setAdapter(mNotificationAdapter);
    }
}
