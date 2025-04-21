#!/bin/bash

# requires "grun" from the arch "antlr4" package
# third argument (program file) must be prefixed with "../" (because of cd before grun)

antlr_dir="antlr"
antlr=$(echo lib/antlr-*.jar)

java -jar $antlr -o $antlr_dir
owo_print "done parsing antlr code."
javac $antlr_dir/*.java -cp $antlr
owo_print "done compiling antlr code."

cd $antlr_dir
grun $@
