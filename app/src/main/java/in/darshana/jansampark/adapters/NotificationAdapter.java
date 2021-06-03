package in.darshana.jansampark.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import in.darshana.jansampark.R;
import in.darshana.jansampark.model.Notifications;

public class NotificationAdapter extends RecyclerView.Adapter<NotificationAdapter.Viewholder>{
    private Context context;
    private ArrayList<Notifications> mNotificationsArrayList;

    public NotificationAdapter(Context context, ArrayList<Notifications> mNotificationsArrayList) {
        this.context = context;
        this.mNotificationsArrayList = mNotificationsArrayList;
    }

    @NonNull
    @Override
    public NotificationAdapter.Viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_notification,parent,false);
        return new Viewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull NotificationAdapter.Viewholder holder, int position) {
        Notifications mNotifications = mNotificationsArrayList.get(position);
        holder.notificationText.setText(mNotifications.getmNotificationText());
        holder.notificationIcon.setImageResource(mNotifications.getnNotificationIcon());
    }

    @Override
    public int getItemCount() {
        return mNotificationsArrayList.size();
    }

    public class Viewholder extends RecyclerView.ViewHolder {
        private ImageView notificationIcon;
        private TextView notificationText;
        public Viewholder(@NonNull View itemView) {
            super(itemView);
            notificationIcon = itemView.findViewById(R.id.imgNotification);
            notificationText = itemView.findViewById(R.id.txtviewNotificationtitle);
        }
    }
}