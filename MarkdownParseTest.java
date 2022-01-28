import static org.junit.Assert.*;

import java.beans.Transient;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import org.junit.*;
import java.util.*;

public class MarkdownParseTest {
    ArrayList<String> file1 = new ArrayList<>();
    ArrayList<String> file2 = new ArrayList<>();
    ArrayList<String> file3 = new ArrayList<>();
    ArrayList<String> file4 = new ArrayList<>();
    @Before
    public void setUp(){
        file1.add("https://something.com");
        file1.add("some-page.html");
        file1.add("");
        file1.add("www.google.com/test");

        file2.add("https://something.com");
        file2.add("some-page.html");
    }
    @Test
    public void addition() {
        assertEquals(2, 1 + 1);
    }
    @Test
    public void TestGetLink() throws IOException{
        Path fileName = Path.of("C:\\Users\\ators\\Documents\\(1) My Documents\\(1) UCSD Stuff\\2ND YEAR\\CLASSES\\2-CSE15L\\markdown-parse\\test-file2.md");
	    String contents = Files.readString(fileName);
        assertEquals(MarkdownParse.getLinks(contents), file2);
        
        Path fileName2 = Path.of("C:\\Users\\ators\\Documents\\(1) My Documents\\(1) UCSD Stuff\\2ND YEAR\\CLASSES\\2-CSE15L\\markdown-parse\\test-file1.md");
	    String contents2 = Files.readString(fileName2);
        assertEquals(MarkdownParse.getLinks(contents2), file1);
    }
}