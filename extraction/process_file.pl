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

sub escape {
	my ( $str ) = @_;
	$str =~ s/&/&amp;/g;
	$str =~ s/</&lt;/g;
	$str =~ s/>/&gt;/g;
	$str =~ s/^\s*(.*?)\s*$/\1/g;
	#return "<![CDATA[$str]]>";
	return "$str";
}

sub to_xml {
	my ( $tag, $str ) = @_;
	my $escaped_str = escape($str);
	return "<$tag>$escaped_str</$tag>";
}

print "<corpus>";
while(<>) {
	my $filename = $ARGV;
	$filename =~ s/^.*?\/([\w\.]+)$/\1/;
	my $report_no = -1;
	my $date = -1;
	my $rubrique = -1;
	my $titre = -1;
	my $texte = -1;
	my $zone_texte = -1;
	my @images;
	my $contact = -1;

	my $text = encode('utf-8', decode_entities($_));
	$text =~ s/(<strong>)|(<\/strong>)|(<em>)|(<\/em>)//g;
	$text =~ s/(<br>)|(<br \/>)//g;
	$text =~ s/\n//g;

	$report_no = match(qr/<span class="style32">.*?BE France (\d+).*?<\/span>/, $text);
	$date = match(qr/<span class="style42">.*?([\d\/]+).*?<\/span>/, $text);
	$date =~ s/[\n\r]//g;
	$rubrique = match(qr/<p class="style96"><span class="style42">(.+)<\/span><span class="style17">/, $text);
	$titre = match(qr/<span class="style17">(.+?)<\/span>/, $text);

	# TODO : Ameliorer > element de structure
	if ($text =~ m/<([a-zA-Z]+) [^<>]*?class="FWExtra2">(.+?)<\/\1>.*?<[^<>]*?class="FWExtra2">/s) {
		$zone_texte = $2;
	} else {
		print "Error zone_texte not found in $text";
		exit 1;
	}

	# Match text
	if (my @matches = $zone_texte =~ m/<span class="style95">(.*?)<\/span>/sg) {
		$texte = join('', @matches);
	} else {
		print "Error text not found";
		exit 1;
	}

	# Match images
	# TODO : Ameliorer > element de structure
	while ($zone_texte =~ m/<img src="(.+?)"[^>]*>(?:<span class="style21">(.+?)<\/span>)?/sg) {
		my $image = {'url' => $1, 'legende' => $2};
		push @images, $image;
	}

	$contact = match(qr/<p class="style44"><span class="style85">(.+?)<\/span><\/p>/s, $text);
	$contact =~ s/<a.*?>(.*?)<\/a>/\1/g;


	#print "================================================================================";
	print "<bulletin>";
	print to_xml("fichier", $filename);
	print to_xml("numero", $report_no);
	print to_xml("date", $date);
	print to_xml("rubrique", $rubrique);
	print to_xml("titre", $titre);
	print to_xml("texte", $texte);
	#say Dumper \@images;
	print "<images>";
	foreach (@images) {
		print "<image>";
		print to_xml("urlImage", $$_{'url'});
		print to_xml("legendeImage", $$_{'legende'});
		print "</image>";
	}
	print "</images>";
	print to_xml("contact", $contact);
	#print "================================================================================";
	print "</bulletin>";
} continue {
	close ARGV if eof;
}
print "</corpus>";

