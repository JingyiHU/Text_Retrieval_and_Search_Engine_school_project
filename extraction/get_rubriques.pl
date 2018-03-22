#!/usr/bin/perl -l

use strict;
use utf8;

use Encode qw( decode encode ); 
use HTML::Entities;
#use open ":encoding(iso-8859-1)";

use Data::Dumper qw(Dumper);
use feature qw(say);

# Read entire file into string
local $/;

sub match {
	my ( $regex, $text, $multimatch, $optional_match ) = @_;
	if (my @matches = $text =~ $regex) {
		my $number = @matches;
		if (!$multimatch && $number > 1) {
			print "Error $regex found more than once : $number matches";
			exit 1;
		}
		#if ($multimatch && $number > 1) {
			#print "Multimatch $number";
			#return @matches;
		#}
		return join('', @matches);
	} else {
		if (!$optional_match) {
			print "Error $regex not found in $text";
			exit 1;
		}
	}
	return -1;
}

my %rubriques;

while(<>) {
	my $rubrique = -1;

	my $text = encode('utf-8', decode_entities($_));
	$text =~ s/(<strong>)|(<\/strong>)|(<em>)|(<\/em>)//g;
	$text =~ s/(<br>)|(<br \/>)/ /g;

	$rubrique = match(qr/<p class="style96"><span class="style42">(.+)<\/span><span class="style17">/, $text);

	$rubriques{$rubrique} = 1;
} continue {
	close ARGV if eof;
}

my @rubriques;
foreach my $key (keys %rubriques) {
	push @rubriques, $key;
}

sort @rubriques;
foreach my $v (@rubriques) {
	print $v;
}
