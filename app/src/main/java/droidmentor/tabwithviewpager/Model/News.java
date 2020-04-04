package droidmentor.tabwithviewpager.Model;


import com.parse.ParseObject;
import java.util.Date;

/**
 * Created by Hobba on 12/04/2018.
 */

public class News {
    String Title;
    String date;
    String about;

    public News(String title, String date, String about) {
        Title = title;
        this.date = date;
        this.about = about;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getAbout() {
        return about;
    }

    public void setAbout(String about) {
        this.about = about;
    }

    @Override
    public String toString() {
        return "News{" +
                "Title='" + Title + '\'' +
                ", date=" + date +
                ", about='" + about + '\'' +
                '}';
    }

}
