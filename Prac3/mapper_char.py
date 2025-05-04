#!/usr/bin/env python
import sys

for line in sys.stdin:
    line = line.strip().replace(" ", "")
    for char in line:
        print("{0}\t1".format(char))
