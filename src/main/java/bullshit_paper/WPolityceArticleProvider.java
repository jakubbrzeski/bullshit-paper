package bullshit_paper;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.LinkedList;
import java.util.List;

public class WPolityceArticleProvider implements IArticleProvider{

    private final String chromeUserAgent = "Mozilla/5.0 (Windows NT 6.2; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/32.0.1667.0 Safari/537.36";
    private final String searchURL = "http://wpolityce.pl/szukaj?q=";
    private final String urlPrefix = "http://wpolityce.pl";

    private String buildQuery(List<String> tags) {
        try {
            StringBuilder sb = new StringBuilder();
            for (String tag : tags) {
                sb.append(URLEncoder.encode(tag, "UTF-8")).append("+");
            }
            return sb.substring(0, sb.length() - 1);
        } catch (UnsupportedEncodingException ex) {
            return null;
        }
    }

    @Override
    public List<Document> getDocuments(List<String> tags) {
        if (tags == null || tags.isEmpty()) {
            return new LinkedList<Document>();
        }
        try {
            System.out.println("In provider...");
            LinkedList<Document> res = new LinkedList<>();
            String url = searchURL + buildQuery(tags);
            Document doc = Jsoup.connect(url).timeout(10000).userAgent(chromeUserAgent).get();
            for (Element e : doc.select("div.content_wide_searchresult_entry")) {
                String articleURL = urlPrefix + e.select("a[href]").attr("href");
                System.out.println("Article url:" + articleURL);
                Document article = Jsoup.connect(articleURL).timeout(10000).userAgent(chromeUserAgent).get();
                res.add(article);
            }
            return res;
        } catch (IOException ex) {
            return new LinkedList<Document>();
        }
    }
}
