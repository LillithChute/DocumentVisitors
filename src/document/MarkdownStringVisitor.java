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
 * Visitor for building a markdown string for a document.
 */
public class MarkdownStringVisitor implements TextElementVisitor<Void> {

  private final StringBuilder markDownAccumulator;

  /**
   * Default constructor.
   */
  public MarkdownStringVisitor() {
    this.markDownAccumulator = new StringBuilder();
  }

  /**
   * Returns a string concatenation of all the text in the document.
   *
   * @return The accumulated text.
   */
  public String getMarkDownAccumulator() {
    if (markDownAccumulator.length() <= 0) {
      throw new IllegalStateException("Visitor has not been used yet.");
    }

    return markDownAccumulator.toString();
  }

  @Override
  public Void visitBasicText(BasicText current) {
    markDownAccumulator.append(current.getText()).append("\n");
    return null;
  }

  @Override
  public Void visitBoldText(BoldText current) {
    markDownAccumulator.append("**").append(current.getText()).append("**").append("\n");
    return null;
  }

  @Override
  public Void visitHeading(Heading current) {

    switch (current.getLevel()) {
      case 1:
        markDownAccumulator.append("# ").append(current.getText()).append("\n");
        break;
      case 2:
        markDownAccumulator.append("## ").append(current.getText()).append("\n");
        break;
      default:
        markDownAccumulator.append("### ").append(current.getText()).append("\n");
        break;
    }

    return null;
  }

  @Override
  public Void visitHyperText(HyperText current) {
    markDownAccumulator.append("[").append(current.getText()).append("]")
            .append("(").append(current.getUrl()).append(")").append("\n");
    return null;
  }

  @Override
  public Void visitItalicText(ItalicText current) {
    markDownAccumulator.append("*").append(current.getText()).append("*").append("\n");
    return null;
  }

  @Override
  public Void visitParagraph(Paragraph current) {

    markDownAccumulator.append("\n");

    for (TextElement element :
            current.getContent()) {
      element.accept(this);
    }

    markDownAccumulator.append("\n");
    return null;
  }

  @Override
  public String toString() {
    return markDownAccumulator.toString().trim();
  }
}
