package main.ch.naturalaesthetics.persistence;
import javax.persistence.*;

/**
 * User: ettisberger
 * Date: 02/08/14
 * Time: 15:16
 */

@Entity
@Table(name = "news")
public class NewsEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String title;
    private String text;
    private String author;


    public final int getId() {
        return id;
    }

    public final void setId(final int id) {
        this.id = id;
    }

    public final String getTitle() {
        return title;
    }

    public final void setTitle(final String title) {
        this.title = title;
    }

    public final String getText() {
        return text;
    }

    public final void setText(final String text) {
        this.text = text;
    }

    public final String getAuthor() {
        return author;
    }

    public final void setAuthor(final String author) {
        this.author = author;
    }
}
