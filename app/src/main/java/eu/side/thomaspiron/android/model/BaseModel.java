package eu.side.thomaspiron.android.model;

/**
 * Created by mdupierreux1 on 24/06/15.
 */
public class BaseModel {
    private String text;
    private String image;
    private String shareUrl;

    public BaseModel(String text, String image, String shareUrl) {
        this.text = text;
        this.image = image;
        this.shareUrl = shareUrl;
    }

    public BaseModel(String text, String image) {
        this. text = text;
        this.image = image;
    }

    public String getText() {
        return text;
    }

    public String getImage() {
        return image;
    }

    public void setText(String text) {
        this.text = text;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getShareUrl() {
        return shareUrl;
    }

    public void setShareUrl(String shareUrl) {
        this.shareUrl = shareUrl;
    }
}
