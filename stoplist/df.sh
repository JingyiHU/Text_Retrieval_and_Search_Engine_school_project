#!/bin/bash
# number of documents in which each word appears
./segmente_TT.pl -f < ./text.xml | ./stoplist/clean.sh | sort -u | cut -f1 | uniq -c | ./stoplist/clean_spaces.sh
