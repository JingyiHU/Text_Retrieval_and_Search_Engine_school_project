# Text-Retrieval-and-Search-Engines

# Introduction

Course at University of Technology of Compiegne, France.

Link : http://www4.utc.fr/~lo17/

# Modules

- Extraction : transforms raw data into XML document
- Stoplist : statistical analysis on XML document to determine stoplist
- Lemmatization : transforms XML document into lemmatized XML document
- Inverse tables : creates inverse tables to prepare for attribute specific querying.
- Correction : uses generated data to provide algorithms for transforming a natural language query into an SQL query which is then used to provide relevant search results

# Extraction

	./extraction.sh

Output : text.xml, a structured document based on the raw input data (in extraction/BULLETINS).

# Stoplist

	./stoplist.sh

Output : stoplist\_filter.pl, a perl script to remove specific words from the previously generated XML document.

# Lemmatization

	./lemme_successeurs.sh

This step can take several minutes.
Output : lemme\_sucesseurs.txt, a text file containing words and their associated lemma.

	./lemme_filter.sh

Output : text\_lemmatise.xml, an XML document where words are transformed into their associated lemma based on the data contained in lemme_successeurs.txt.

# Inverse tables

	./inversetable.sh

Output : inversetables/inversetable_*.txt.

# Correction

Copy the lemmas data to the java project :

	cp ./lemme_successeurs.txt ./correction/src/main/resources/data/lemmas.txt


