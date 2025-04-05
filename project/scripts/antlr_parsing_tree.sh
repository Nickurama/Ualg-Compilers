#!/bin/bash

# requires "grun" from the arch "antlr4" package
# third argument (program file) must be prefixed with "../" (because of cd before grun)

# usage: ./antlr_parsing_tree.sh grammar_name start_rule ./program args
# the above usage is obsolte and has been hardcoded

# out_dir="./out"
# src_dir="./src"
# grammar="$1"
# grammar_file="$grammar.g4"
# start_rule="$2"
# program="$3"
# shift
# shift
# shift
# args="$@"

# new usage: ./antlr_parsing_tree.sh ./program

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
