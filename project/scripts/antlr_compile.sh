#!/bin/bash

cd src
antlr=$(echo ../lib/antlr-*.jar)
grammar="Tuga"
grammar_file="$grammar.g4"
antlr_dir="$grammar"

# rm -rf $(echo $antlr_dir/*)

java -jar $antlr -visitor $grammar_file -o $antlr_dir -package $grammar
owo_print "done parsing antlr code."

cd ..
java_compile
