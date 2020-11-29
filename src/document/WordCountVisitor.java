package document;

import document.element.BasicText;
import document.element.BoldText;
import document.element.Heading;
import document.element.HyperText;
import document.element.ItalicText;
import document.element.Paragraph;
import document.element.TextElementVisitor;

/**
 * This is a visitor that does operations to count words.
 */
public class WordCountVisitor implements TextElementVisitor<String> {

  private int count;

  /**
   * Constructor to ensure that this is visited at least once before returning data.
   */
  public WordCountVisitor() {
    this.count = -1;
  }

  @Override
  public String visitBasicText(BasicText current) {
    String text = current.getText();

    // Get the actual count
    getWordCountHelper(text);

    // Return null because there is nothing to return since this is stateful.
    return null;
  }

  @Override
  public String visitBoldText(BoldText current) {
    String text = current.getText();

    // Get the actual count
    getWordCountHelper(text);

    // Return null because there is nothing to return since this is stateful.
    return null;
  }

  @Override
  public String visitHeading(Heading current) {
    String text = current.getText();

    // Get the actual count
    getWordCountHelper(text);

    // Return null because there is nothing to return since this is stateful.
    return null;
  }

  @Override
  public String visitHyperText(HyperText current) {
    String text = current.getText();

    // Get the actual count
    getWordCountHelper(text);

    // Return null because there is nothing to return since this is stateful.
    return null;
  }

  @Override
  public String visitItalicText(ItalicText current) {
    String text = current.getText();

    // Get the actual count
    getWordCountHelper(text);

    // Return null because there is nothing to return since this is stateful.
    return null;
  }

  @Override
  public String visitParagraph(Paragraph current) {
    String text = current.getText();

    // Get the actual count
    getWordCountHelper(text);

    // Return null because there is nothing to return since this is stateful.
    return null;
  }

  /**
   * Accessor for the result of this visitor.
   *
   * @return the word count.
   */
  public int getCount() {
    if (count < 0) {
      throw new IllegalStateException("Visitor has not been used yet.");
    }

    return count;
  }

  /**
   * A simple helper to avoid redundant code that splits the text and counts words.
   *
   * @param text The text of words to count.
   */
  private void getWordCountHelper(String text) {
    String[] wordArray = text.split(" ");
    count = wordArray.length;
  }
}
