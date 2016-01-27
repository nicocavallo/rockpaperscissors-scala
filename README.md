Rock Paper Scissors - Scala Version
====================================

This is an attempt to solve eBay Coding challenge

MVP includes

* Command line interface
* Human vs Computer Mode
* Computer vs Computer Mode

Extra: Extended version (Rock Paper Scissors Spock Lizard) added

Command line playable version
-----------------------------

To run the app from the command line:

```
sbt run
```

To run extended (Rock Paper Scissors Spock Lizard) version:

```
sbt "run extended"
```

To compile and run tests
-------------------------

```
sbt clean test
```
About the tests
---------------

* challenge.RockPaperScissorsSpec: Tests game logic
* challenge.InputParserSpec: Tests parsing from the standard input
* challenge.GameAppSpec: Tests the GameApp by mocking its collaborator InputParser.

Code is mostly covered
----------------------

To run coverage reports:

```
sbt clean coverage test coverageReport
```

TODO
----

* Add web interface
* Add JavaFX (ScalaFX?) support??
* Create Android app??

