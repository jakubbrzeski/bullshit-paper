package bullshit_paper;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.*;

public class WPolityceArticleParser implements IArticleParser {

    private Document document;
    private final String urlPrefix = "http://wpolityce.pl";
    @Override
    public IArticle parseDocument(Document document) {
        this.document = document;
        return new Article(getTitle(), getContent(), getDate(), getComments(), getImages());
    }

    private String getTitle() {
        // Example: Stany Zjednoczone: 21 ofiar śmiertelnych mrozów | wPolityce.pl | codziennie ważne informacje ze świata polityki
        String title = document.select("title").text().split("\\|")[0];
        return title;
    }

    private String getContent() {
        String content = new String();
        Elements elements = document.select("#content_leftwidecol div").get(0).children();
        boolean pOccurred = false;
        for(Element element: elements) {
            // sometimes article ends with dashes and ad
            if(element.text().contains("-----"))
                break;
            if(element.tagName().equals("p") || element.tagName().equals("blockquote")) {
                pOccurred = true;
                content += element.text();
            }
            // content is between some divs
            else if(element.tagName().equals("div") && pOccurred)
                break;
        }
        return content;
    }

    private Date getDate() {
        // date is in h4 tag
        Elements elements = document.select("h4");
        String strDate = new String();
        for(Element element: elements) {
            if(element.text().contains("opublikowano")) {
                strDate = element.text().split("\\|")[0];
                strDate = strDate.substring(14);
            }
        }
        // wpolityce uses the same format
        return OnetDate.parse(strDate);
    }

    private List<IComment> getComments() {
        List<IComment> retList = new LinkedList<>();
        Elements comments = document.select("div.content_comments_post_lev0");
        for(Element comment: comments) {
            String content = new String();
            String author = new String();
            Date date = new Date();
            content = comment.select("div.content_comments_post_body").get(0).text();
            author = comment.select("span.comment_post_author").get(0).text();
            String strDate = comment.select("span.comment_post_timestamp").get(0).text();
            // author name can contain "(gość)" and "([ip address])"
            author = author.replaceAll("\\(.*\\)", "");
            retList.add(new Comment(content, author, date));
        }
        return retList;
    }

    private List<IImage> getImages() {
        LinkedList<IImage> images = new LinkedList<>();
        String url = document.select("div.content_article_photo img").attr("src");
        try {
            Image image = new Image(new URL(urlPrefix + url));
            images.add(image);
        } catch (MalformedURLException ex) {
            // malformed url - don't add image
        } catch (IOException ex) {
            // can't construct image - don't add
        }
        return images;
    }

}
