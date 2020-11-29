package document;

import document.element.BasicText;
import document.element.BoldText;
import document.element.Heading;
import document.element.HyperText;
import document.element.ItalicText;
import document.element.Paragraph;
import document.element.TextElementVisitor;

/**
 * Visitor for building a basic string for a document.
 */
public class BasicStringVisitor implements TextElementVisitor<Void> {

  private StringBuilder textAccumulator;

  /**
   * Default constructor.
   */
  public BasicStringVisitor() {
    this.textAccumulator = new StringBuilder();
  }

  /**
   * Returns a string concatenation of all the text in the document.
   *
   * @return The accumulated text.
   */
  public String getTextAccumulator() {
    if (textAccumulator.length() <= 0) {
      throw new IllegalStateException("Visitor has not been used yet.");
    }

    return textAccumulator.toString();
  }

  @Override
  public Void visitBasicText(BasicText current) {
    textAccumulator.append(current.getText()).append(" ");
    return null;
  }

  @Override
  public Void visitBoldText(BoldText current) {
    textAccumulator.append(current.getText()).append(" ");
    return null;
  }

  @Override
  public Void visitHeading(Heading current) {
    textAccumulator.append(current.getText()).append(" ");
    return null;
  }

  @Override
  public Void visitHyperText(HyperText current) {
    textAccumulator.append(current.getText()).append(" ");
    return null;
  }

  @Override
  public Void visitItalicText(ItalicText current) {
    textAccumulator.append(current.getText()).append(" ");
    return null;
  }

  @Override
  public Void visitParagraph(Paragraph current) {
    textAccumulator.append(current.getText()).append(" ");
    return null;
  }

  @Override
  public String toString() {
    return textAccumulator.toString().trim();
  }
}
