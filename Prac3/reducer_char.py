#!/usr/bin/env python
import sys

current_char = None
count = 0

for line in sys.stdin:
    char, value = line.strip().split('\t')
    value = int(value)

    if char == current_char:
        count += value
    else:
        if current_char:
            print("{0}\t{1}".format(current_char, count))
        current_char = char
        count = value

if current_char:
    print("{0}\t{1}".format(current_char, count))
