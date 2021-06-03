package in.darshana.jansampark.model;

public class Notifications {
    private String mNotificationText;
    private int nNotificationIcon;

    public Notifications(String mNotificationText, int nNotificationIcon) {
        this.mNotificationText = mNotificationText;
        this.nNotificationIcon = nNotificationIcon;
    }

    public String getmNotificationText() {
        return mNotificationText;
    }

    public void setmNotificationText(String mNotificationText) {
        this.mNotificationText = mNotificationText;
    }

    public int getnNotificationIcon() {
        return nNotificationIcon;
    }

    public void setnNotificationIcon(int nNotificationIcon) {
        this.nNotificationIcon = nNotificationIcon;
    }
}
