#!/bin/bash
# number of occurences of words accross all documents

./segmente_TT.pl -f < ./text.xml | ./stoplist/clean.sh | sort | uniq -c | ./stoplist/clean_spaces.sh
