package btl.weather;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Plan implements Serializable {
    private String content;
    private Date date;

    public Plan(String content, Date date) {
        this.content = content;
        this.date = date;
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

    @Override
    public String toString() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        return sdf.format(date) + " - " + content;
    }
}
