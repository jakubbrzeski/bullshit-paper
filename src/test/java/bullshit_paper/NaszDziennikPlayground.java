package bullshit_paper;

import java.io.FileOutputStream;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class NaszDziennikPlayground {
	private final String chromeUserAgent = "Mozilla/5.0 (Windows NT 6.2; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/32.0.1667.0 Safari/537.36";
	@Test
    public void test() throws Exception {

        List<SectionInfo> sectionInfos = Arrays.asList(new SectionInfo[]{
                new SectionInfo(Arrays.asList("doda"), "Doda", java.awt.Color.PINK, true,
                        "Nasz Dziennik", new NaszDziennikArticleParser(), new NaszDziennikArticleProvider()),
                new SectionInfo(Arrays.asList("bigos"), "Bigos", java.awt.Color.BLACK, false,
                        "Nasz Dziennik", new NaszDziennikArticleParser(), new NaszDziennikArticleProvider()),
        });
        new PaperGenerator().generate("Nasz Dziennik", sectionInfos, new FileOutputStream("NaszDziennik.pdf"));
    }
}
