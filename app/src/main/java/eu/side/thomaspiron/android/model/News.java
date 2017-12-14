package eu.side.thomaspiron.android.model;

/**
 * Created by mdupierreux1 on 1/12/15.
 */
public class News {

    private String alias;
    private String title;
    private String introtext;
    private String fulltext;
    private String image;

    public News(String alias, String title, String introtext, String fulltext) {
        this.alias = alias;
        this.title = title;
        this.introtext = introtext;
        this.fulltext = fulltext;
    }

    public News(String alias, String title, String introtext, String fulltext, String image) {
        this.alias = alias;
        this.title = title;
        this.introtext = introtext;
        this.fulltext = fulltext;
        this.image = image;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getIntrotext() {
        return introtext;
    }

    public void setIntrotext(String introtext) {
        this.introtext = introtext;
    }

    public String getFulltext() {
        return fulltext;
    }

    public void setFulltext(String fulltext) {
        this.fulltext = fulltext;
    }
}
