package bullshit_paper;

import com.sun.org.apache.bcel.internal.generic.ICONST;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by ciemny on 1/8/14.
 */
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
        System.out.println("Title: " + title);
        return title;
    }

    private String getContent() {
        System.out.println("Getting content...");
        String content = new String();
        Elements elements = document.select("#content_leftwidecol div").get(0).children();
        boolean pOccured = false;
        for(Element element: elements) {
            // sometimes article ends with dashes and ad
            if(element.text().contains("-----"))
                break;
            if(element.tagName().equals("p") || element.tagName().equals("blockquote")) {
                pOccured = true;
                content += element.text();
            }
            else if(element.tagName().equals("div") && pOccured)
                break;
//            System.out.println(element.tag());
        }
//        System.out.println(content);
        return content;
    }

    private Date getDate() {
        // date is in h4 tag
        Elements elements = document.select("h4");
        System.out.println("dupa");
        String strDate = new String();
        for(Element element: elements) {
            System.out.println(element.text());
            if(element.text().contains("opublikowano")) {
                strDate = element.text().split("\\|")[0];
                strDate = strDate.substring(14);
                System.out.println("strDate: " + strDate);
                System.out.println(OnetDate.parse(strDate));
            }
        }
        return OnetDate.parse(strDate);
    }

    private List<IComment> getComments() {
//        Comment comment = new Comment();
        List<IComment> retList = new LinkedList<>();
        Elements comments = document.select("div.content_comments_post_lev0");
        for(Element comment: comments) {
            String content = new String();
            String author = new String();
            Date date = new Date();
            content = comment.select("div.content_comments_post_body").get(0).text();
            author = comment.select("span.comment_post_author").get(0).text();
            String strDate = comment.select("span.comment_post_timestamp").get(0).text();
            author = author.replaceAll("\\(.*\\)", "");
            System.out.println("Author: " + author);
            System.out.println("Content: " + content);
            System.out.println("Date: " + date);
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
