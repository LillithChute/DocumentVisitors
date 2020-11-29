package document.element;

/**
 * Interface that represents an element in our document.
 */
public interface TextElement {

  /**
   * Returns the text contained within the element.
   *
   * @return the text
   */
  String getText();

  /**
   * Method for applying visitors to this document.
   *
   * @param visitor The visitor to use
   * @param <R> Generic type.
   * @return Generic object type.
   */
  <R> R accept(TextElementVisitor<R> visitor);

}
