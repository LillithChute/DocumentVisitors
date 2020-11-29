import static org.junit.Assert.assertEquals;

import document.BasicStringVisitor;
import document.Document;
import document.HtmlStringVisitor;
import document.MarkdownStringVisitor;
import document.WordCountVisitor;
import document.element.BasicText;
import document.element.BoldText;
import document.element.Heading;
import document.element.HyperText;
import document.element.ItalicText;
import document.element.Paragraph;
import org.junit.Before;
import org.junit.Test;

/**
 * Test for the visitor lab.
 */
public class TestVisitor {

  private Document document;
  private BasicStringVisitor basicStringVisitor;
  private HtmlStringVisitor htmlStringVisitor;
  private MarkdownStringVisitor markDownStringVisitor;

  /**
   * Create the text elements and then add them to the document.  This additionally tests whether
   * the document constructor works since we are creating one here.
   */
  @Before
  public void setup() {
    // Create different elements
    // 5 words
    final Heading heading = new Heading("The Lord of the Rings", 1);

    // 31 words
    BasicText basic = new BasicText("It's a dangerous business, Frodo, going out your door. "
            + "You step "
            + "onto the road, and if you don't keep your feet, there's no knowing where "
            + "you might be swept off to.");

    // 57 words
    BasicText basic2 = new BasicText("I am old, Gandalf. I don't look it, but I am beginning to "
            + "feel it in "
            + "my heart of hearts. Well preserved indeed! Why, I feel all thin, sort of "
            + "stretched, if you know what I mean: like butter that has been scraped over too "
            + "much bread. That can't be right. I need a change, or something.");

    // 8 words
    final BoldText bold = new BoldText("Moonlight drowns out all but the brightest stars.");


    // 6 words
    final HyperText hyperText = new HyperText("The Lord of the Rings quotes.",
            "https://www.goodreads.com/"
            + "work/quotes/3462456-the-lord-of-the-rings");

    // 11 words
    final ItalicText italic = new ItalicText("Death is just another path, one that we "
            + "all must take.");

    // 88 total words
    Paragraph paragraph = new Paragraph();
    paragraph.add(heading);
    paragraph.add(basic);
    paragraph.add(hyperText);
    paragraph.add(basic2);

    // Build the document.
    document = new Document();
    document.add(heading);
    document.add(paragraph);
    document.add(bold);
    document.add(hyperText);
    document.add(italic);

    // Create the visitors
    basicStringVisitor = new BasicStringVisitor();
    htmlStringVisitor = new HtmlStringVisitor();
    markDownStringVisitor = new MarkdownStringVisitor();
  }

  @Test
  public void testWordCount() {
    assertEquals(129, document.countWords());
  }

  @Test(expected = IllegalStateException.class)
  public void testWordCountVisitorNotVisited() {
    WordCountVisitor wordCountVisitor = new WordCountVisitor();
    wordCountVisitor.getCount();
  }

  @Test
  public void testBasicStringVisitor() {
    assertEquals("The Lord of the Rings The Lord of the Rings It's a dangerous business, "
                    + "Frodo, going out your door. You step onto the road, and if you don't "
                    + "keep your feet, there's no knowing where you might be swept off to. The "
                    + "Lord of the Rings quotes. I am old, Gandalf. I don't look it, but I "
                    + "am beginning to feel it in my heart of hearts. Well preserved indeed! "
                    + "Why, I feel all thin, sort of stretched, if you know what I mean: like "
                    + "butter that has been scraped over too much bread. That can't be right. "
                    + "I need a change, or something. Moonlight drowns out all but the "
                    + "brightest stars. The Lord of the Rings quotes. Death is just another "
                    + "path, one that we all must take.",
            document.toText(basicStringVisitor));
  }

  @Test(expected = IllegalStateException.class)
  public void testBasicStringVisitorNotVisited() {
    BasicStringVisitor basicStringVisitor = new BasicStringVisitor();
    basicStringVisitor.getTextAccumulator();
  }

  @Test
  public void testHtmlStringVisitor() {
    assertEquals("<h1>The Lord of the Rings</h1>\n"
                    + "<p><h1>The Lord of the Rings</h1>\n"
                    + "It's a dangerous business, Frodo, going out your door. You step onto "
                    + "the road, and if you don't keep your feet, there's no knowing where "
                    + "you might be swept off to.\n"
                    + "<a href=\"https://www.goodreads.com/work/quotes"
                    + "/3462456-the-lord-of-the-rings\">The Lord of the Rings quotes.</a>\n"
                    + "I am old, Gandalf. I don't look it, but I am beginning to feel it in my "
                    + "heart of hearts. Well preserved indeed! Why, I feel all thin, sort of "
                    + "stretched, if you know what I mean: like butter that has been scraped "
                    + "over too much bread. That can't be right. I need a change, or something.\n"
                    + "</p>\n"
                    + "<b>Moonlight drowns out all but the brightest stars.</b>\n"
                    + "<a href=\"https://www.goodreads.com/work/quotes"
                    + "/3462456-the-lord-of-the-rings\">The Lord of the Rings quotes.</a>\n"
                    + "<i>Death is just another path, one that we all must take.</i>",
            document.toText(htmlStringVisitor));
  }

  @Test(expected = IllegalStateException.class)
  public void testHtmlStringVisitorNotVisited() {
    HtmlStringVisitor htmlStringVisitor = new HtmlStringVisitor();
    htmlStringVisitor.getHtmlAccumulator();
  }

  @Test
  public void testMarkDownStringVisitor() {
    assertEquals("# The Lord of the Rings\n"
                    + "\n"
                    + "# The Lord of the Rings\n"
                    + "It's a dangerous business, Frodo, going out your door. You step onto "
                    + "the road, and if you don't keep your feet, there's no knowing where "
                    + "you might be swept off to.\n"
                    + "[The Lord of the Rings quotes.](https://www.goodreads.com/work/quotes"
                    + "/3462456-the-lord-of-the-rings)\n"
                    + "I am old, Gandalf. I don't look it, but I am beginning to feel it in "
                    + "my heart of hearts. Well preserved indeed! Why, I feel all thin, sort "
                    + "of stretched, if you know what I mean: like butter that has been "
                    + "scraped over too much bread. That can't be right. I need a change, or "
                    + "something.\n"
                    + "\n"
                    + "**Moonlight drowns out all but the brightest stars.**\n"
                    + "[The Lord of the Rings quotes.](https://www.goodreads.com/work/quotes"
                    + "/3462456-the-lord-of-the-rings)\n"
                    + "*Death is just another path, one that we all must take.*",
            document.toText(markDownStringVisitor));
  }

  @Test(expected = IllegalStateException.class)
  public void testMarkDownStringVisitorNotVisited() {
    MarkdownStringVisitor markdownStringVisitor = new MarkdownStringVisitor();
    markdownStringVisitor.getMarkDownAccumulator();
  }
}
