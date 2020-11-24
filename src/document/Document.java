package document;

import document.element.TextElementVisitor;
import java.util.ArrayList;
import java.util.List;

import document.element.TextElement;

public class Document {
  
  private List<TextElement> content;
  
  public Document() {
    content = new ArrayList<>();
  }

  public void add(TextElement e) {
    content.add(e);
  }

  public int countWords() {
    return 0;
  }

  public String toText(??? visitor) {

    return null;
  }
}
