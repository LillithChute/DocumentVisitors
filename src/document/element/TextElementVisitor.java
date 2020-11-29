package document.element;

/**
 * Enumerates the visitors(verbs) used in this application.
 *
 * @param <R> Generic type.
 */
public interface TextElementVisitor<R> {
  
  R visitBasicText(BasicText current);
  
  R visitBoldText(BoldText current);

  R visitHeading(Heading current);

  R visitHyperText(HyperText current);

  R visitItalicText(ItalicText current);

  R visitParagraph(Paragraph current);
}
