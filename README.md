Backgammon game
Developers : [Atique Shaikh](https://github.com/AtiqueUCD), 
[Emile Aydar](https://github.com/xXMagIkZzR4mBOXx) and [Sangharsh Patil](https://github.com/Sangharsh11).

Entry by Atique, Date - 28-Oct-23
Added Checkers and Spike class for support.
Emile and Sanghar add the class flies and acknowladge this Entry.


Entry by Atique, Date - 31-Oct-23
merged Sangharsh class with board class. YTT.

Fo compilation use the following command so that we exclude the JUnit test file, which is
causing compilation error.
Command :- javac $(find . -name '*.java' ! -name '*Test*' -print)