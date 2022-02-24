
CLASSPATH = lib/junit-4.13.2.jar:lib/hamcrest-core-1.3.jar:lib/commonmark-0.18.1.jar:.

MarkdownParseTest.class: mdpt.java mdp.class
	javac -cp $(CLASSPATH) mdpt.java

MarkdownParse.class: mdp.java
	javac -cp $(CLASSPATH) mdp.java

test: mdpt.class
	java -cp $(CLASSPATH) org.junit.runner.JUnitCore mdpt 