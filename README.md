# DocumentVisitors
The goal of this lab is to design and implement a Visitor design pattern.

What to do
Package: document

To start this assignment, download this provided starter code zip file (Links to an external site.) that contains several different types of text elements. Take a moment to familiarize yourself with the classes in the document.element package. Each class, implementing the TextElement interface, represents a different type of text formatting. Finally, the Document class in the document package is used to represent a generic document.

In this lab, we will be using the visitor design pattern to add new capabilities to the Document class.

To do this you need to add a method to the TextElement interface. Start by making the elements of the document "visitable" by adding the following method to the TextElement interface, and implementing it in the implementing classes:

public <R> R accept(TextElementVisitor<R> visitor)

Next, implement each of the following visitors, in the document package:

WordCountVisitor: counts the number of words that are in a document.

BasicStringVisitor generates a simple string representation of the document. In a simple string representation, the text of each element is added one at a time using a space between each element. Additional information (e.g., the level of a heading) is ignored.

HtmlStringVisitor generates an HTML version of the document. In HTML, white space is not important so each element of the document should be separated by a newline ("\n"). In addition, formatting tags should be added according to basic html syntax (Links to an external site.).

MarkdownStringVisitor generates a Markdown version of the document. Similar to HTML, white space is less important to the document so each element of the document should be separated by a newline ("\n"). In addition, formatting tags should be added according to basic markdown syntax (Links to an external site.).

Now, you should add two methods to the Document class that use these visitors:

countWords that returns the number of words in the document.

toText that takes one of these "string visitors" as a parameter and returns a String as per the above description. String visitors should accumulate their result and return it when toString is called on the visitor.