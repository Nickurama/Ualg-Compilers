#!/bin/bash

antlr=$1
grammar_file=$2
antlr_dir=$3

java -jar $antlr $grammar_file -o $antlr_dir
owo_print "done parsing antlr code."
