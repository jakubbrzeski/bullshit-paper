package bullshit_paper;

import org.junit.Test;

import java.io.FileOutputStream;
import java.util.Arrays;
import java.util.List;

public class WPolitycePlayground {
    @Test
    public void test() throws Exception {

        List<SectionInfo> sectionInfos = Arrays.asList(new SectionInfo[]{
                new SectionInfo(Arrays.asList("doda"), "Doda", java.awt.Color.PINK, true),
                new SectionInfo(Arrays.asList("Smoleńsk"), "Smoleńsk", java.awt.Color.BLACK, false),
        });
        new PaperGenerator().generate("W Polityce", sectionInfos, new FileOutputStream("w_polityce.pdf"),
                new WPolityceArticleProvider(), new WPolityceArticleParser());
    }
}
