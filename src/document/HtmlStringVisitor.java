package document;

import document.element.BasicText;
import document.element.BoldText;
import document.element.Heading;
import document.element.HyperText;
import document.element.ItalicText;
import document.element.Paragraph;
import document.element.TextElement;
import document.element.TextElementVisitor;

/**
 * Visitor for building an HTML string for a document.
 */
public class HtmlStringVisitor implements TextElementVisitor<Void> {
  private final StringBuilder htmlAccumulator;

  /**
   * Default constructor.
   */
  public HtmlStringVisitor() {
    this.htmlAccumulator = new StringBuilder();
  }

  /**
   * Returns a string concatenation of all the text in the document.
   *
   * @return The accumulated text.
   */
  public String getHtmlAccumulator() {
    if (htmlAccumulator.length() <= 0) {
      throw new IllegalStateException("Visitor has not been used yet.");
    }

    return htmlAccumulator.toString();
  }

  @Override
  public Void visitBasicText(BasicText current) {
    htmlAccumulator.append(current.getText()).append("\n");

    return null;
  }

  @Override
  public Void visitBoldText(BoldText current) {
    htmlAccumulator.append("<b>").append(current.getText()).append("</b>").append("\n");

    return null;
  }

  @Override
  public Void visitHeading(Heading current) {

    switch (current.getLevel()) {
      case 1:
        htmlAccumulator.append("<h1>").append(current.getText()).append("</h1>").append("\n");
        break;
      case 2:
        htmlAccumulator.append("<h2>").append(current.getText()).append("</h2>").append("\n");
        break;
      default:
        htmlAccumulator.append("<h3>").append(current.getText()).append("</h3>").append("\n");
        break;
    }

    return null;
  }

  @Override
  public Void visitHyperText(HyperText current) {
    htmlAccumulator.append("<a href=\"").append(current.getUrl()).append("\">")
            .append(current.getText()).append("</a>\n");

    return null;
  }

  @Override
  public Void visitItalicText(ItalicText current) {
    htmlAccumulator.append("<i>").append(current.getText()).append("</i>").append("\n");

    return null;
  }

  @Override
  public Void visitParagraph(Paragraph current) {
    htmlAccumulator.append("<p>");

    for (TextElement element :
            current.getContent()) {
      element.accept(this);
    }

    htmlAccumulator.append("</p>").append("\n");

    return null;
  }

  @Override
  public String toString() {
    return htmlAccumulator.toString().trim();
  }
}
