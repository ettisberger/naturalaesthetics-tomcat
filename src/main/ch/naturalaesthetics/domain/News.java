package main.ch.naturalaesthetics.domain;

/**
 * User: ettisberger
 * Date: 02/08/14
 * Time: 15:16
 */

public class News extends AbstractDomain {

    private String title;
    private String text;
    private String author;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
}
