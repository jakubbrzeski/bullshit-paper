package bullshit_paper;

import static java.lang.Math.min;
import java.io.FileOutputStream;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class OnetPlayground
{
    @Test
    public void test() throws Exception {

	List<SectionInfo> sectionInfos = Arrays.asList(new SectionInfo[] {
	    new SectionInfo(Arrays.asList("doda"), "Doda", java.awt.Color.PINK, true,
                "Onet", new OnetArticleParser(), new OnetArticleProvider()),
	    new SectionInfo(Arrays.asList("Smoleńsk"), "Smoleńsk", java.awt.Color.BLACK, false,
                "Onet", new OnetArticleParser(), new OnetArticleProvider()),
	    new SectionInfo(Arrays.asList("śnieg"), "Śnieg", java.awt.Color.BLUE, true,
                "Onet", new OnetArticleParser(), new OnetArticleProvider())
    });
    new PaperGenerator().generate("Onet BP", sectionInfos, new FileOutputStream("onettest.pdf"));
    }
}