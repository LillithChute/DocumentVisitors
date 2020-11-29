package document;

import document.element.TextElement;
import document.element.TextElementVisitor;
import java.util.ArrayList;
import java.util.List;

/**
 *  Represents a document of text elements.
 */
public class Document {
  
  private final List<TextElement> content;

  /**
   * Constructor that creates an empty list of elements.
   */
  public Document() {
    content = new ArrayList<>();
  }

  /**
   * Adds text elements to the document.
   *
   * @param e A text element.
   */
  public void add(TextElement e) {
    content.add(e);
  }

  /**
   * This counts the total number of words in the document.
   *
   * @return The number of words.
   */
  public int countWords() {
    WordCountVisitor visitor = new WordCountVisitor();
    int count = 0;

    for (TextElement element
            : content) {
      element.accept(visitor);
      count += visitor.getCount();
    }

    return count;
  }

  /**
   * Returns a string representation of the text based on the visitor passed in.
   *
   * @param visitor The type of visitor to this document.
   * @return The text.
   */
  public String toText(TextElementVisitor visitor) {
    for (TextElement element
            : content) {
      element.accept(visitor);
    }

    return visitor.toString();
  }
}
