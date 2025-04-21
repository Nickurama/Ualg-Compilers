#!/bin/bash

# requires "grun" from the arch "antlr4" package
# third argument (program file) must be prefixed with "../" (because of cd before grun)

grammar=$1
out_dir="./out"

./antlr_compile.sh $grammar

cd $out_dir
grun $@
