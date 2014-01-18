package bullshit_paper;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ciemny on 1/18/14.
 */
public class ParsersProvider {
    public static class ParserObject {
        final String name;

        final IArticleParser parser;
        final IArticleProvider provider;
        public ParserObject(String name, IArticleParser parser, IArticleProvider provider) {
            this.name = name;
            this.parser = parser;
            this.provider = provider;
        }

        public String getName() {
            return name;
        }

        public IArticleParser getParser() {
            return parser;
        }

        public IArticleProvider getProvider() {
            return provider;
        }

        @Override
        public String toString() {
            return name;
        }

    }

    private List<ParserObject> parsers = new ArrayList<ParserObject>();

    public List<ParserObject> getParsers() {
        return parsers;
    }

    ParsersProvider add(ParserObject parserObject) {
        this.parsers.add(parserObject);
        return this;
    }

    ParsersProvider add(String name, IArticleParser parser, IArticleProvider provider) {
        this.parsers.add(new ParserObject(name, parser, provider));
        return this;
    }

    void init() {
        this.add("Onet", new OnetArticleParser(), new OnetArticleProvider())
            .add("Nasz Dziennik", new NaszDziennikArticleParser(), new NaszDziennikArticleProvider())
            .add("W Potylice", new WPolityceArticleParser(), new WPolityceArticleProvider());
    }

    public ParsersProvider() {
        init();
    }

}
