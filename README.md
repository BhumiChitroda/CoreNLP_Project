Development Platform - Eclipse 
Server - Apache Tomcat Server
Build Tool - Maven
Toolset/library - CoreNLP 4.2.2

The project uses Java with Spring at the server and serves an Angular app at the Front-End.
Server-Side: At the server side we have the configuration files such as pom.xml, servelet-context.xml which tell the server the dependencies required and the location to scan components in the project hierarchy.
There 2 main classes on the server:

CoreNLP.java: This class uses the CoreNLP Stanford library, to derive linguistic annotations for text. The function class has functions that return the following:
Number of words and word list
Number of sentences and sentence list
Number of Nouns and noun list
Number of Adjectives and adjective list.
The class is designed in a way that follows the principles of encapsulation and reusability. The variables of a class are hidden and can be only accessed through getter methods.

The controller class: The controller provides endpoints for the front-end to interact with the server and return processed data.

At the front-end: The Angular app provides a text area for the user to provide the text to be analyzed. After hitting the run button a text document is generated with all the information about the text.
Angular uses TypeScript for validation and text enhancement.
