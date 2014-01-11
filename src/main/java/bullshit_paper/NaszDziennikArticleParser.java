package bullshit_paper;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

public class NaszDziennikArticleParser implements IArticleParser{

	private Document document;
	@Override
	public IArticle parseDocument(Document document) {
		this.document = document;
        return new Article(getTitle(), getContent(), getDate(), getComments(), getImages());
	}

    private String getTitle() {
    	Elements el = document.select("h1");
    	if(el.isEmpty()) return "Szok! Bigos się przypalił";
        String title = el.text();
        return title;
    }
	
    private String getContent() {
    	if(!document.select("div.content").isEmpty()){
    		return document.select("div.content").get(0).text();
    	}
    	else if(!document.select("#article-content").isEmpty()){
    		return document.select("#article-content").get(0).text();
    	}
    	return "W smoleńsku był zamach.";
    }
    private Date getDate() {
    	Elements el = document.select("title");
    	if(el.isEmpty()){
    		// try with select("#article-date") ? - uncomfortable format
    		System.out.println(document.select("#article-date").text());
    		return new Date();
    	}
    	String[] parts = el.text().split("[ ]");
    	String datestr = parts[parts.length-1];
    	Date date = new Date();
		try {
			date = new SimpleDateFormat("yyyy-MM-dd").parse(datestr);
		} catch (ParseException e) {
			System.out.println("Parse Excpetion");
		}

    	return date;
    }
    // There are no comments
    private List<IComment> getComments() {
    	return null;
    }
    
    private List<IImage> getImages() {
        LinkedList<IImage> images = new LinkedList<>();
        String url = document.select("#image img").attr("src");
        System.out.println(url);
        try {
            Image image = new Image(new URL(url));
            images.add(image);
        } catch (MalformedURLException ex) {
            // malformed url - don't add image
        } catch (IOException ex) {
            // can't construct image - don't add
        }
        return images;
    }
    
}
