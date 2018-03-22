#!/usr/bin/perl
use strict;
use warnings;

sub log10 {
	my $n = shift;
	return log($n)/log(10);
}

my $doc_count = `ls ./extraction/BULLETINS | wc -l`;

while (my $line = <>) {
	my ($df, $word) = split / /, $line;
	my $idf = log10($doc_count/$df);
	print "$idf $word";
}
