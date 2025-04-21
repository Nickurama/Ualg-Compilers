#!/bin/bash

# requires "grun" from the arch "antlr4" package
# third argument (program file) must be prefixed with "../" (because of cd before grun)

rm -rf $(echo antlr/*)

antlr=$(echo lib/antlr-*.jar)
# grammar_file="Cal.g4"
grammar_file="$1.g4"
antlr_dir="antlr"

./antlr_compile.sh $antlr $grammar_file $antlr_dir
javac $(echo $antlr_dir/*.java) -cp $antlr
owo_print "done compiling antlr code."

cd $antlr_dir
grun $@
