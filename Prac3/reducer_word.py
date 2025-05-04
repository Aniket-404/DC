#!/usr/bin/env python
import sys

current_word = None
count = 0

for line in sys.stdin:
    word, value = line.strip().split('\t')
    value = int(value)

    if word == current_word:
        count += value
    else:
        if current_word:
            print("{0}\t{1}".format(current_word, count))
        current_word = word
        count = value

if current_word:
    print("{0}\t{1}".format(current_word, count))
