package bullshit_paper;

import org.junit.Test;

import java.io.FileOutputStream;
import java.util.Arrays;
import java.util.List;

public class WPolitycePlayground {
    @Test
    public void test() throws Exception {


        List<SectionInfo> sectionInfos = Arrays.asList(new SectionInfo[]{
                        new SectionInfo(Arrays.asList("Doda"), "Doda", java.awt.Color.PINK, true,
                                "W Polityce", new WPolityceArticleParser(), new WPolityceArticleProvider()),
                        new SectionInfo(Arrays.asList("asdpaosdaposkdada"), "asdpaosdaposkdada", java.awt.Color.PINK, true,
                                 "W Polityce", new WPolityceArticleParser(), new WPolityceArticleProvider()),
        });
        new PaperGenerator().generate("W Polityce", sectionInfos, new FileOutputStream("w_polityce.pdf"));
    }
}
