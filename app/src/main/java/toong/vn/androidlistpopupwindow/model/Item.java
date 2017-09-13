package toong.vn.androidlistpopupwindow.model;

/**
 * Created by PhanVanLinh on 13/09/2017.
 * phanvanlinh.94vn@gmail.com
 */

public class Item {
    private String title;
    private int imageRes;

    public Item(String title, int imageRes) {
        this.title = title;
        this.imageRes = imageRes;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getImageRes() {
        return imageRes;
    }

    public void setImageRes(int imageRes) {
        this.imageRes = imageRes;
    }
}
