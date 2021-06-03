package in.darshana.jansampark.model;

public class WorkModel {
    private String mWorkImageUrl;
    private String mWorkTitleText;
    private String mWorkMainText;

    public WorkModel(String mWorkImageUrl, String mWorkTitleText, String mWorkMainText) {
        this.mWorkImageUrl = mWorkImageUrl;
        this.mWorkTitleText = mWorkTitleText;
        this.mWorkMainText = mWorkMainText;
    }

    public String getmWorkImageUrl() {
        return mWorkImageUrl;
    }

    public void setmWorkImageUrl(String mWorkImageUrl) {
        this.mWorkImageUrl = mWorkImageUrl;
    }

    public String getmWorkTitleText() {
        return mWorkTitleText;
    }

    public void setmWorkTitleText(String mWorkTitleText) {
        this.mWorkTitleText = mWorkTitleText;
    }

    public String getmWorkMainText() {
        return mWorkMainText;
    }

    public void setmWorkMainText(String mWorkMainText) {
        this.mWorkMainText = mWorkMainText;
    }
}
