package in.darshana.jansampark.model;

public class NewsModel {
    private String mNews;
    private int mNewsImg;

    public NewsModel(String mNews,int mNewsImg) {
        this.mNews = mNews;
        this.mNewsImg = mNewsImg;
    }

    public String getmNews() {
        return mNews;
    }

    public void setmNews(String mNews) {
        this.mNews = mNews;
    }

    public int getmNewsImg() {
        return mNewsImg;
    }

    public void setmNewsImg(int mNewsImg) {
        this.mNewsImg = mNewsImg;
    }
}
