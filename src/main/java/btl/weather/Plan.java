package btl.weather;

import java.util.Date;

public class Plan {

    private String title;
    private String content;
    private Date date;

    public Plan(String title, String content, Date date) {
        this.title = title;
        this.content = content;
        this.date = date;
    }

    // Getter and Setter for title
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    // Getter and Setter for content
    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    // Getter and Setter for date
    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
