#!/bin/bash

antlr=$(echo lib/antlr-*.jar)
grammar=$1
grammar_file="$grammar.g4"
antlr_dir="src/$grammar"

rm -rf $(echo $antlr_dir/*)

java -jar $antlr -visitor $grammar_file -o $antlr_dir -package $grammar
owo_print "done parsing antlr code."

java_compile
