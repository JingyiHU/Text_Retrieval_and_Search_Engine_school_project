#!/usr/bin/perl
use strict;
use warnings;

my $idf_text = `./stoplist/df.sh | ./stoplist/df_to_idf.pl`;
my %idf_table;

foreach my $line (split /\n/, $idf_text) {
	my ($idf, $word) = split / /, $line;
	$idf_table{$word} = $idf;
}

my $tf_text = `./stoplist/tf.sh`;

foreach my $line (split /\n/, $tf_text) {
	my ($tf, $word, $file) = split / /, $line;
	print $tf*$idf_table{$word}, " $word $file\n";
}
