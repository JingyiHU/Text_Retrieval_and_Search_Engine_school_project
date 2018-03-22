#!/usr/bin/perl

use strict;
use warnings;
use Data::Dumper;

my %tf_idf_table;
my %tf_idf_table_count;
my $sum = 0;
my $count = 0;
my @tf_idf_values;

while (my $line = <>) {
	$line =~ s/^\s+|\s+$//g;
	my ($tf_idf, $word, $file) = split / /, $line;
	$tf_idf_table{$word} += $tf_idf;
	$tf_idf_table_count{$word} += 1;
}

my %tf_idf_table_mean;

while(my($word, $tf_idf) = each %tf_idf_table) {
	my $tf_idf_mean = $tf_idf / $tf_idf_table_count{$word};
	$tf_idf_table_mean{$word} = $tf_idf_mean;

	push @tf_idf_values, $tf_idf_mean;
	$sum += $tf_idf_mean;
	$count += 1;
}

@tf_idf_values = sort { $a <=> $b } @tf_idf_values;

my $mean = $sum / $count;
my $cutoff = 0.005;
my $lower_bound = $tf_idf_values[$count*$cutoff];
# no upper bound
#my $upper_bound = $tf_idf_values[$count - $count*$cutoff];
my $upper_bound = $tf_idf_values[$count-1]*10000;

my %stop_list;

my $in_bounds_count = 0;
while(my($word, $tf_idf_mean) = each %tf_idf_table_mean) {
	if ($tf_idf_mean > $lower_bound && $tf_idf_mean < $upper_bound) {
		$in_bounds_count += 1;
	} else {
		$stop_list{$word} = $tf_idf_mean;
	}
}

print "lb: $lower_bound, ub: $upper_bound, mean: $mean, count: $count\n";
print "in_bounds_count: $in_bounds_count\n";

my @stop_list_table = sort { $stop_list{$b} <=> $stop_list{$a} } keys %stop_list;

foreach my $word (@stop_list_table) {
	print $stop_list{$word}, " $word\n"
}
