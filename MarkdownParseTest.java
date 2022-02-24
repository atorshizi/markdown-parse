import static org.junit.Assert.*;
import java.beans.Transient;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import org.junit.*;
import java.util.*;

public class MarkdownParseTest {
    String PATH = "C:\\Users\\ators\\Documents\\(1) UCSD Stuff\\2ND YEAR\\CLASSES\\2-CSE15L\\markdown-parse\\";
    ArrayList<String> file1 = new ArrayList<>();
    ArrayList<String> file2 = new ArrayList<>();
    ArrayList<String> file3 = new ArrayList<>();
    ArrayList<String> file4 = new ArrayList<>();
    @Before
    public void setUp(){
        file1.add("https://something.com");
        file1.add("some-page.html");
        // file1.add("");
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
        Path fileName = Path.of(PATH + "test-file2.md");
	    String contents = Files.readString(fileName);
        assertEquals(MarkdownParse.getLinks(contents), file2);
        
        Path fileName2 = Path.of(PATH + "test-file.md");
	    String contents2 = Files.readString(fileName2);
        assertEquals(MarkdownParse.getLinks(contents2), file1);
    }


    //Lab Report 4 Tests
    @Test
    public void TestOurSnippit1() throws IOException{
        Path fileName = Path.of(PATH + "snip1.md");
	    String contents = Files.readString(fileName);
        ArrayList<String> expected = new ArrayList<>();
        expected.add("`google.com");
        expected.add("google.com");
        expected.add("ucsd.edu");
        ArrayList<String> actual = MarkdownParse.getLinks(contents);
        assertEquals(expected, actual);
    }

    @Test
    public void TestReviewedSnippit1() throws IOException{
        Path fileName = Path.of(PATH + "snip1.md");
	    String contents = Files.readString(fileName);
        ArrayList<String> expected = new ArrayList<>();
        expected.add("`google.com");
        expected.add("google.com");
        expected.add("ucsd.edu");
        ArrayList<String> actual = MarkdownParseReviewed.getLinks(contents);
        assertEquals(expected, actual);
    }


    @Test
    public void TestOurSnippit2() throws IOException{
        Path fileName = Path.of(PATH + "snip2.md");
	    String contents = Files.readString(fileName);
        ArrayList<String> expected = new ArrayList<>();
        expected.add("a.com");
        expected.add("a.com(())");
        expected.add("example.com");
        ArrayList<String> actual = MarkdownParse.getLinks(contents);
        assertEquals(expected, actual);
    }

    @Test
    public void TestReviewedSnippit2() throws IOException{
        Path fileName = Path.of(PATH + "snip2.md");
	    String contents = Files.readString(fileName);
        ArrayList<String> expected = new ArrayList<>();
        expected.add("a.com");
        expected.add("a.com(())");
        expected.add("example.com");
        ArrayList<String> actual = MarkdownParseReviewed.getLinks(contents);
        assertEquals(expected, actual);
    }

    @Test
    public void TestOurSnippit3() throws IOException{
        Path fileName = Path.of(PATH + "snip3.md");
	    String contents = Files.readString(fileName);
        ArrayList<String> expected = new ArrayList<>();
        expected.add("https://www.twitter.com");
        expected.add("https://ucsd-cse15l-w22.github.io/");
        expected.add("https://cse.ucsd.edu/");
        ArrayList<String> actual = MarkdownParse.getLinks(contents);
        assertEquals(expected, actual);
    }

    @Test
    public void TestReviewedSnippit3() throws IOException{
        Path fileName = Path.of(PATH + "snip3.md");
	    String contents = Files.readString(fileName);
        ArrayList<String> expected = new ArrayList<>();
        expected.add("https://www.twitter.com");
        expected.add("https://ucsd-cse15l-w22.github.io/");
        expected.add("https://cse.ucsd.edu/");
        ArrayList<String> actual = MarkdownParseReviewed.getLinks(contents);
        assertEquals(expected, actual);
    }
}