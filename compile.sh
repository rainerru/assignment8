#!/bin/bash
cd src
javac -d ../out assignment8_int/*.java
javac -d ../out rainer_sieberer/*.java
javac -d ../out rainer_sieberer/p1/*.java
javac -d ../out rainer_sieberer/p2/*.java
javac -d ../out rainer_sieberer/p3/*.java
javac -d ../out ../test/rainer_sieberer/*.java
cd ..
