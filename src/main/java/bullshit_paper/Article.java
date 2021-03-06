package bullshit_paper;

import java.util.Date;
import java.util.List;

public class Article extends PaperElement implements IArticle {

    private final String title;
    private final String content;
    private final Date date;
    private final List<IComment> comments;
    private final List<IImage> images;

    public Article(String title, String content, Date date, List<IComment> comments, List<IImage> images) {
        this.title = title;
        this.content = content;
        this.date = date;
        this.comments = comments;
        this.images = images;
    }

    @Override
    public String getTitle() {
        return title;
    }

    @Override
    public String getContent() {
        return content;
    }

    @Override
    public Date getDate() {
        return date;
    }

    @Override
    public List<IComment> getComments() {
        return comments;
    }

    @Override
    public List<IImage> getImages() {
        return images;
    }

}
