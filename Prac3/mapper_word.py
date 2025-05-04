#!/usr/bin/env python
import sys
import re

for line in sys.stdin:
    words = re.findall(r'\w+', line.lower())
    for word in words:
        print("{0}\t1".format(word))
