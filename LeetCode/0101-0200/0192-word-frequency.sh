# Read from the file words.txt and output the word frequency list to stdout.
cat words.txt | tr "[:blank:]" "\n" | awk '{if ($1) a[$1]++;} END {for (i in a) print i " " a[i];}' | sort -nrk2