package bullshit_paper;

import java.awt.*;
import java.util.*;
import java.util.List;

public class SectionInfo
{
    private final List<String> _tags;
    private final String _name;
    private final java.awt.Color _headerColor;
    private final boolean _sudoku;
    private final ParsersProvider.ParserObject _parserObject;

    public SectionInfo(List<String> tags, String name, Color headerColor, boolean sudoku, ParsersProvider.ParserObject parserObject)
    {
        _tags = tags;
        _name = name;
        _headerColor = headerColor;
        _sudoku = sudoku;
        _parserObject = parserObject;
    }

    public SectionInfo(List<String> tags, String name, Color headerColor, boolean sudoku, String portalName, IArticleParser parser, IArticleProvider provider)
    {
        _tags = tags;
        _name = name;
        _headerColor = headerColor;
        _sudoku = sudoku;
        _parserObject = new ParsersProvider.ParserObject(portalName, parser, provider);
    }
    
    public List<String> getTags() { return  _tags; }
    public String getName() { return _name; }
    public java.awt.Color getHeaderColor() { return  _headerColor; }
    public boolean  getSudoku() { return _sudoku; }
    public ParsersProvider.ParserObject getParserObject() { return _parserObject; }
}