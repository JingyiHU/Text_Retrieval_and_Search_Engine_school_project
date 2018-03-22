./tf_idf.pl | ./tf_idf_to_stoplist.pl  | cut -d ' ' -f2 | awk 'NF{print $0 "\t"}' | ./newcreeFiltre.pl
