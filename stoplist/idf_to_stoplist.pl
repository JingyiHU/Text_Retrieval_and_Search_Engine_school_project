#!/usr/bin/perl

use strict;
use warnings;
use Data::Dumper;

my %idf_table;
my $sum = 0;
my $count = 0;
my @idf_values;

while (my $line = <>) {
	$line =~ s/^\s+|\s+$//g;
	my ($idf, $word) = split / /, $line;
	$idf_table{$word} = $idf;
	push @idf_values, $idf;
	$sum += $idf;
	$count += 1;
}
@idf_values = sort { $a <=> $b } @idf_values;

my $df_text = `./df.sh`;
my %df_table;

foreach my $line (split /\n/, $df_text) {
	$line =~ s/^\s+|\s+$//g;
	my ($df, $word) = split / /, $line;
	$df_table{$word} = $df;
}

my $mean = $sum / $count;
my $cutoff = 0.005;
my $lower_bound = $idf_values[$count*$cutoff];
# no upper bound
my $upper_bound = $idf_values[$count-1]*10000;

my $in_bounds_count = 0;
while(my($word, $idf) = each %idf_table) {
	#print "$word $idf";
	if ($idf > $lower_bound) {
		$in_bounds_count += 1;
	} else {
		print $df_table{$word}, " $idf $word\n";
	}
}

print "lb: $lower_bound, ub: $upper_bound, mean: $mean, count: $count\n";
print "in_bounds_count: $in_bounds_count\n";
