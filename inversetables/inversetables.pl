#!/usr/bin/perl

@balise = ("date","rubrique","titre","contact","urlImage","legendeImage");

$corpus = "text_lemmatise.xml";

foreach $bal (@balise){
	`perl inversetables/index.pl $bal $corpus > inversetables/inversetable_$bal.txt`;

}

`cat text_lemmatise.xml | perl segmente_TT.pl -r -f -n| perl inversetables/indexTexte.pl > inversetables/inversetable_texte.txt`;
