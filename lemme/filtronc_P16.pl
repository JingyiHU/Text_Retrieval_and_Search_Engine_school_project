#!/usr/bin/perl


if ($ARGV[0] =~ /-v/) {
	shift(@ARGV);
	$bavard=1;
}
#use open ':utf8';
use open qw(:std :utf8);
while(<>) {
	chop;
	($successeurs,$mot)=split(/\t/);
	$limite="2";
	while ($successeurs =~ /(...*1)([$limite-9])/) {
		$successeurs=$1.$2;
		if ($2 >= 9) {
#          si on trouve un maximum à 9 précédé d'un 1, inutile d'aller chercher plus loin
			last;
		}
		else {
			$limite=$2+1;
		}
	}
	$res = substr ($mot,0,length($successeurs));
	if ($bavard==1) {	
		print "$mot\t";
	}
	print "$mot\t$res\n";
}
