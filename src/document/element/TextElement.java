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
   * @param visitor
   * @param <R>
   * @return
   */
  <R> R accept(TextElementVisitor<R> visitor);

}
