#!/bin/bash

# requires "grun" from the arch "antlr4" package

# usage: ./antlr_parsing_tree.sh ./program
# note: the './' before './program' is mandatory
# obs: the script looks very weird and redundant, but every operation is required

out_dir="./out"
src_dir="./src"

args="-gui"
grammar="Tuga"
grammar_file="$grammar.g4"
start_rule="tuga"
program="$1"

# setup grammar in correct placement for grun
cp $(echo "$src_dir/$grammar_file") $(echo "$out_dir/$grammar/")

cd $out_dir
grun $(echo "$grammar.$grammar $start_rule .$program $args")
