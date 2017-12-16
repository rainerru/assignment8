#!/bin/bash
#javac -d out src/assignment8_int/*.java
#javac -d out src/rainer_sieberer/*.java
#javac -d out src/rainer_sieberer.p1/*.java
#javac -d out test/rainer_sieberer/*.java
cd src
javac -d ../out assignment8_int/*.java
javac -d ../out rainer_sieberer/*.java
javac -d ../out rainer_sieberer/p1/*.java
javac -d ../out ../test/rainer_sieberer/*.java
cd ..
